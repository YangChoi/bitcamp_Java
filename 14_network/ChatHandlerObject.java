import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.UnknownHostException;

class ChatHandlerObject extends Thread{
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private Socket socket;
	private List<ChatHandlerObject> list;

	
	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException{
		this.socket = socket;
		this.list = list;

			// 클라이언트에서 먼저 데이터를 보내주기 때문에 
			// 서버에서는 클라이언트 데이터 받기를 먼저 하기 위해 writer를 먼저 생성 (출력 스트림)
			writer = new ObjectOutputStream(socket.getOutputStream());
			// 입력스트림은 나중에 
			reader = new ObjectInputStream(socket.getInputStream());
			// 스레드는 순서가 없기 때문에 출력 스트림을 먼저 생성해준다. 
	}

	@Override
	public void run(){
		InfoDTO infoDTO = null;
		String nickName = null; // 닉네임만 따로 저장 ( 메시지 보내고 퇴장하고 기능에 닉네임이 필요하기 때문) 
			while(true){
				// 클라이언트로부터 받기 
				// 닉네임 
				try{
					infoDTO = (InfoDTO)reader.readObject(); // dto 가져온다
				
					if(infoDTO.getCommand() ==Info.JOIN){
						
						nickName = infoDTO.getNickName(); // 닉네임 꺼내서 보관
						
						// 모든 클라이언트에게 입장메시지 보내야함
						InfoDTO sendDTO = new InfoDTO();
						sendDTO.setCommand(Info.SEND);
						sendDTO.setMessage(nickName + "님이 입장하였습니다.");
						broadcast(sendDTO); // 모든 클라이언트들에게 나간다. 

					}else if(infoDTO.getCommand() == Info.EXIT){
						// 나에게 보내는 EXIT 하나 남아있는 애들에게 보내는 EXIT 하나 
						InfoDTO sendDTO = new InfoDTO();
						//1. 나가려고 EXIT 보낸 클라이언트에게 답변 보내기 
						sendDTO.setCommand(Info.EXIT);
						writer.writeObject(sendDTO);
						writer.flush();

						reader.close();
						writer.close();
						socket.close();
						// 나에게만 가는 것이므로 BROADCAST 안함 
						//2. 남아있는 클라이언트에게 EXIT 메세지 보내기
						list.remove(this); // 내 자신을 지워야한다.
						
						sendDTO.setCommand(Info.SEND);
						sendDTO.setMessage(nickName + "님이 퇴장하였습니다");
						
						broadcast(sendDTO);
						break;
						
					}else if(infoDTO.getCommand() == Info.SEND){
						InfoDTO sendDTO = new InfoDTO();
						sendDTO.setCommand(Info.SEND);
						sendDTO.setMessage("[" +nickName+ "]" + infoDTO.getMessage());
						broadcast(sendDTO);
					}

				}catch(IOException e){
					e.printStackTrace();

				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
		
		}// while
	}
	public void broadcast(InfoDTO sendDTO){
		for(ChatHandlerObject handler : list){ // list 안에 handler
			try{
				handler.writer.writeObject(sendDTO); // 현재 메시지를 보낸다. 
				handler.writer.flush(); // 버퍼 비워주기 
			}catch(IOException e){
				e.printStackTrace();
			}

		}// for
	}
}
