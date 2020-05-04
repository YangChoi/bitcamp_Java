import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.OutputStreamWriter;
import java.net.Socket;


class ProtocolServer {
	// 로그인을 할 때, 로그인 이전에 서버가 먼저 가동된다. 
	// 서버가 클라이언트를 기다리는 형태 
	// 항상 실행은 서버를 먼저
	private ServerSocket serverSocket;
	private BufferedReader reader; 
	private BufferedWriter writer; 
	private Socket socket; 
	private BufferedReader keyboard;

	public ProtocolServer(){

		try{
			// 서버와 클라이언트가 같은 포트 안에 있어야한다.
			// 서버가 9500번 포트를 잡고 기다리고 있는다. 
			// 만약 클라이언트가 여러개라면 : ServerSocket이 while으로 무한루프 돌리면서 클라이언트들을 잡으려고 대기탄다. 
			serverSocket = new ServerSocket(9500);
			System.out.println("서버준비 완료");

			socket = serverSocket.accept(); // 클라이언트를 낚아 챈다. (그리고 그것을 받아줄 socket) 
			// 현재 클라이언트와 내 서버를 연결시켜준다. 
			
			// 소켓을 통해 reader, writer가 생긴 것 
			// 여기서는 하나의 클라이언트 소켓 잡을 것이기 때문에 while문 안쓰고 바로 메시지 뛰움
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 서버와 클라이언트가 주고 받아야하기 때문에 양쪽 다 생성 
			// client의 writer를 server의 reader가 받아줌 
			// server의 writer를 client의 reader가 받아준다. 

			keyboard = new BufferedReader(new InputStreamReader(System.in));
		}catch(IOException e){
			System.out.println("클라이언트와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}

	}

	public void service(){
		String line;

		while(true){
			//대화가 계속되는 한 계속 돌아간다 
			try{
				// 클라이언트로부터 오는 메세지 받기 
				line = reader.readLine(); // 읽어들인다. 
				// 분해 
				String[] arr = line.split(":"); // 콜론 기준으로 분해를 한다. 
				
				if(arr[0].equals(Protocol.ENTER)){ // "100", "angel"
					writer.write(arr[1] + "님 입장하였습니다 \n"); // line은 엔터 인식 안하기 때문에 꼭 엔터 넣어주기 
					writer.flush();

					
				}else if(arr[0].equals(Protocol.EXIT)){ //200번 보다 Protocol.EXIT가 더 좋다(다른 사람들도 알아볼 수 있음)
					// EXIT
					writer.write(arr[1] + "님 퇴장하였습니다 \n");
					writer.flush();
					// 클라이언트가 close되면 서버도 같이 close한다 
					reader.close();
					writer.close();
					socket.close();

					System.exit(0);

				}else if(arr[0].equals(Protocol.SEND_MESSAGE)){
					// SEND-MESSAGE
					writer.write("[" +arr[1]+ "] " +arr[2]+"\n");
					writer.flush();
				}
				// 클라이언트로로 보내기 (응답)
			}catch(IOException e){
				e.printStackTrace();
			}
		}// while
	}
	public static void main(String[] args) {
		new ProtocolServer().service();	
	}
}
