import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.OutputStreamWriter;
import java.net.Socket;

class ProtocolClient {
	// 클라이언트는 핸드폰이 있어야한다 (서버와 대화를 할 용) 
	// 모든 데이터는 핸드폰을 통해서 (핸드폰 = 소켓)
	private Socket socket;
	private BufferedReader reader; // 소켓을 통해 들어오는 것 
	private BufferedWriter writer; 
	private BufferedReader keyboard; // 키보드를 통해 들어오는 것
	
	public ProtocolClient(){
		try{
			socket = new Socket("192.168.0.28", 9500); // 소켓 마련 && 서버와 연결할 서버IP, 포트번호 필요  
			// 내가 서버고 내가 클라이언트인 상태 
			// ip 주소는 ipconfig로 
			// ping : 네트워크 검사 
			// ping 내 ip : 내 ip 잘 작동하는지
			
			// 소켓을 통해 들어오는 경우 
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// 키보드를 통해 들어오는 경우 
			keyboard = new BufferedReader(new InputStreamReader(System.in));
		}catch(UnknownHostException e){
			// 알수없는 서버가 있을 시 
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);

		}catch(IOException e){
			// 서버와 연결이 안되는 경우 : reader와 writer에서 나는 에러 
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void service(){
		String msg, line;

		while(true){
			// 사용자가 대화를 끊을 때 까지 
			// Protocol에 EXIT 상수가 올때까지 
			try{
				// 서버로 보내기 : protocolServer.java로 보내는 것 
				// 키보드로부터 메시지를 받는다. (키보드로부터 데이터 읽기 )
				msg = keyboard.readLine(); // 엔터를 칠 때까지 한 라인으로 본다. (readLine은 엔터를 읽지 않는다 ) >> angel:200
				writer.write(msg+"\n"); // 서버로부터 나가라 >> 에러 
				// 서버측에서 reader.readLine으로 읽는다. 그런데 양쪽다 readLine이면 서로 엔터를 찾는데 클라이언트는 엔터를 보낸 적이 없다. 
				// 그렇기 때문에 엔터를 꼭 함께 보내야한다. 
				//writer.println(msg); 이 경우도 가능한테 위의 코드로 엔터의 중요성을 알리기 위해 일부러 쓴다.. 
				// writer.close(); 는 쓰면 안된다. 종료된다. 
				writer.flush(); // 버퍼에 남은 찌꺼기를 비워준다. 
				// 그래야 다음 데이터가 들어올 자리가 생긴다 ( 대화를 한 번 만 하고 끝낼 것이 아니기 때문에 ) 전에 쓴 Sytem.in.read(); 와 비슷한 경우 
				
				// 서버로부터 받기 
				// 서버로부터 받은 것을 읽어만 온다 
				line = reader.readLine(); 
				System.out.println(line); // 넘어온 것을 찍어만 주면 된다. 
				
				// 200 : 끊자 
				String[] arr = msg.split(":"); //콜론 기준으로 문자열을 나누어 배열로 받는다 >> "200", "angel" 
				if(arr[0].equals(Protocol.EXIT)){
					// ..님이 퇴장하셨습니다 메세지는 위의 line에서 출력된 상태 
					// 차례로 close 해준다. 
					reader.close();
					writer.close();
					socket.close();

					System.exit(0); // 프로그램을 더이상 유지할 필요가 없으므로 프로그램 종료 
				}
			}catch(IOException e){
				// 예외처리할 때 어디서 어디까지 예외처리가 필요한지 에러메시지를 잘 보고 범위를 판단한다.

				e.printStackTrace(); // 그냥 에러메시지만 찍어라 
			}
		}// while()
	}
	public static void main(String[] args) {
		new ProtocolClient().service();
	}
}
