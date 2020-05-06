import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;

class ChatHandler extends Thread{
	// 처리하는 쪽 
	// 서버에 의해서 넘겨주는 쪽 (지점)
	// 스레드가 되는 쪽 
	// 서버의 소켓을 가지고 있는 쪽 
	// 클라이언트의 소켓은 chatHandler의 소켓과 대화하는 것 
	
	private BufferedReader reader; 
	private PrintWriter writer; 
	
	// ChatHandler가 socket을 가져야하지만 현재 socket은 server가 가지고 있다.
	// server가 넘겨준다. 
	private Socket socket;
	private List<ChatHandler> list;
	public ChatHandler(Socket socket, List<ChatHandler> list) throws IOException{
		// 생성자 통해 보낸 것은 생성자 통해 받는다.
		// 그런데 생성자 안에서만 사는 것은 생명력이 짧으므로 필드로 보낸다. 
		this.socket = socket;
		//리스트에는 무엇을 담아주어야하나? ChatHandler를 담아준다. 
		// 현재 chathandler가 reader, writer가지고 있기 때문 
		this.list = list; 
	
		
		// reader, writer는 server가 아닌 handler 가 갖는다. 
		// 클라이언트로부터 데이터를 받고 보낸다. 
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	// 스레드 시작 시 바로 찾는 메서드 run()
	@Override
	public void run(){
		try{
			// 클라이언트로부터 받기 
			// 클라이언트는 닉네임을 가장 먼저 보낸다. 
			String nickName = reader.readLine(); // 메시지를 읽어들인다. 
			// 모든 클라이언트에게 입장 메시지 보낸다.(나 자신 포함)
			broadcast(nickName + "님 입장하였습니다." ); // 닉네임을 모든 클라이언트들에게 보낸다. 
			
			// 클라이언트로부터 보내기 
			String line;
			while(true){
				// 클라이언트가 종료할 때까지 
				line = reader.readLine(); // 메시지 받기 
				if(line == null || line.equals("exit")){
				// 스레드는 끝나도 백에서 돌기 때문에 체크해줘야한다.(null로 돌 수 있다) 
				
				// 나 자신에게 보내는 것들
				// 나가려고 exit를 보낸 클라이언트에게 답변 보내기 
				// 이거 안보내면 컴퓨터가 아무 일 없이 기다리기만 한다. 
				// 동기식
				// 반드시 답변을 보내줘야한다. 
				writer.println("exit");
				writer.flush();
				reader.close();
				writer.close();
				socket.close();
				
				// 남아 있는 클라이언트 
				list.remove(this); // 현 시점의 나(퇴장할 애)를 list에서 제거 
				broadcast(nickName + "님이 퇴장하였습니다.");
				// 1대 1채팅이 아니다. 
				// 한명이 나갔다고 해서 나머지 클라이언트와 연락 중인 서버의 소켓들까지 끊어지면 안된다. 
				// 남은 애들의 소켓은 끊어버리는 것이 아닌 누가 퇴장했다는 메시지를 보내줘야한다. 
				// 그런데 퇴장 전에 퇴장할 애 list를 없애줘야한다. 
				break; // while 나가는 것 > catch : 끝 

				} // if

				// 모든 클라이언트에게 메시지 보내기 (나가는게 아니라면 메시지 전달 )
				broadcast("["+nickName+"]" + line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void broadcast(String msg){
		for(ChatHandler handler : list){ // list 안에 handler
			handler.writer.println(msg); // 현재 메시지를 보낸다. 
			handler.writer.flush(); // 버퍼 비워주기 

		}// for
	}
}
