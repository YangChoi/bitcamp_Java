import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

class ChatServer {
	// 본점 
	private ServerSocket serverSocket;
	private List<ChatHandler> list; // 소켓들을 모아 관리해줄 ArrayList ( 부모인 List로 잡는다) >> new 안되는 인터페이스 list 
	public ChatServer(){

		try{
			serverSocket = new ServerSocket(9500); // 9500번 포트를 잡고 기다린다. 
			System.out.println("서버 준비 완료");
			
			list = new ArrayList<ChatHandler>(); // ArrayList로 new 해준다. 
			// protocolClient.java는 클라이언트가 하나 밖에 들어오지 않기 때문에 소켓이 하나, 따라서 list로 묶어 관리해줄 필요가 없다.
			
			// 클라이언트가 들어오면 낚아채야한다. (accept)
			// 그런데 클라이언트가 들어올 때마다 낚아채야한다 >> 여러번 accept
			while(true){
				// 클라이언트가 들어올 때마다 
				Socket socket = serverSocket.accept(); // 낚아채기 
				// 채팅창을 생각했을 때 각 클라이언트가 순차적으로 대화가 오는 것이 아니다 
				// 스레드이다. 
				// 그러면 그 대화내용을 받아줄 서버의 소켓 역시 스레드가 되어야한다. 
				// 클라이언트 소켓들이 스레드가 된다고 하면 서버의 소켓들도 스레드가 되주어야한다. 
				// 단. 서버 자체가 스레드가 되는 것이 아니다. 서버의 스레드가 스레드가 되는 것이다. 
				// 서버는 여러개 될 수 없다. kt 서버는 하나고, kt의 기지국이 여러개인 것. 
				// chatHandler를 만든다. 
				ChatHandler handler = new ChatHandler(socket, list); // chathandler에게 socket을 보내준다.(ChatHandler는 thread를 상속받았으므로 
				// chathandler가 곧 스레드이다) >> 스레드 생성
				handler.start(); // 스레드 시작 
				
				list.add(handler); // list 안에 chathandler를 넣는다. (이 핸들러가 클라이언트의 갯수이다)
				

			}// while
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
