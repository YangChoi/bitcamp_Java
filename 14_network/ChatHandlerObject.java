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

			// Ŭ���̾�Ʈ���� ���� �����͸� �����ֱ� ������ 
			// ���������� Ŭ���̾�Ʈ ������ �ޱ⸦ ���� �ϱ� ���� writer�� ���� ���� (��� ��Ʈ��)
			writer = new ObjectOutputStream(socket.getOutputStream());
			// �Է½�Ʈ���� ���߿� 
			reader = new ObjectInputStream(socket.getInputStream());
			// ������� ������ ���� ������ ��� ��Ʈ���� ���� �������ش�. 
	}

	@Override
	public void run(){
		InfoDTO infoDTO = null;
		String nickName = null; // �г��Ӹ� ���� ���� ( �޽��� ������ �����ϰ� ��ɿ� �г����� �ʿ��ϱ� ����) 
			while(true){
				// Ŭ���̾�Ʈ�κ��� �ޱ� 
				// �г��� 
				try{
					infoDTO = (InfoDTO)reader.readObject(); // dto �����´�
				
					if(infoDTO.getCommand() ==Info.JOIN){
						
						nickName = infoDTO.getNickName(); // �г��� ������ ����
						
						// ��� Ŭ���̾�Ʈ���� ����޽��� ��������
						InfoDTO sendDTO = new InfoDTO();
						sendDTO.setCommand(Info.SEND);
						sendDTO.setMessage(nickName + "���� �����Ͽ����ϴ�.");
						broadcast(sendDTO); // ��� Ŭ���̾�Ʈ�鿡�� ������. 

					}else if(infoDTO.getCommand() == Info.EXIT){
						// ������ ������ EXIT �ϳ� �����ִ� �ֵ鿡�� ������ EXIT �ϳ� 
						InfoDTO sendDTO = new InfoDTO();
						//1. �������� EXIT ���� Ŭ���̾�Ʈ���� �亯 ������ 
						sendDTO.setCommand(Info.EXIT);
						writer.writeObject(sendDTO);
						writer.flush();

						reader.close();
						writer.close();
						socket.close();
						// �����Ը� ���� ���̹Ƿ� BROADCAST ���� 
						//2. �����ִ� Ŭ���̾�Ʈ���� EXIT �޼��� ������
						list.remove(this); // �� �ڽ��� �������Ѵ�.
						
						sendDTO.setCommand(Info.SEND);
						sendDTO.setMessage(nickName + "���� �����Ͽ����ϴ�");
						
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
		for(ChatHandlerObject handler : list){ // list �ȿ� handler
			try{
				handler.writer.writeObject(sendDTO); // ���� �޽����� ������. 
				handler.writer.flush(); // ���� ����ֱ� 
			}catch(IOException e){
				e.printStackTrace();
			}

		}// for
	}
}
