import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.OutputStreamWriter;
import java.net.Socket;


class ProtocolServer {
	// �α����� �� ��, �α��� ������ ������ ���� �����ȴ�. 
	// ������ Ŭ���̾�Ʈ�� ��ٸ��� ���� 
	// �׻� ������ ������ ����
	private ServerSocket serverSocket;
	private BufferedReader reader; 
	private BufferedWriter writer; 
	private Socket socket; 
	private BufferedReader keyboard;

	public ProtocolServer(){

		try{
			// ������ Ŭ���̾�Ʈ�� ���� ��Ʈ �ȿ� �־���Ѵ�.
			// ������ 9500�� ��Ʈ�� ��� ��ٸ��� �ִ´�. 
			// ���� Ŭ���̾�Ʈ�� ��������� : ServerSocket�� while���� ���ѷ��� �����鼭 Ŭ���̾�Ʈ���� �������� ���ź��. 
			serverSocket = new ServerSocket(9500);
			System.out.println("�����غ� �Ϸ�");

			socket = serverSocket.accept(); // Ŭ���̾�Ʈ�� ���� æ��. (�׸��� �װ��� �޾��� socket) 
			// ���� Ŭ���̾�Ʈ�� �� ������ ��������ش�. 
			
			// ������ ���� reader, writer�� ���� �� 
			// ���⼭�� �ϳ��� Ŭ���̾�Ʈ ���� ���� ���̱� ������ while�� �Ⱦ��� �ٷ� �޽��� �ٿ�
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// ������ Ŭ���̾�Ʈ�� �ְ� �޾ƾ��ϱ� ������ ���� �� ���� 
			// client�� writer�� server�� reader�� �޾��� 
			// server�� writer�� client�� reader�� �޾��ش�. 

			keyboard = new BufferedReader(new InputStreamReader(System.in));
		}catch(IOException e){
			System.out.println("Ŭ���̾�Ʈ�� ������ �ȵǾ����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}

	}

	public void service(){
		String line;

		while(true){
			//��ȭ�� ��ӵǴ� �� ��� ���ư��� 
			try{
				// Ŭ���̾�Ʈ�κ��� ���� �޼��� �ޱ� 
				line = reader.readLine(); // �о���δ�. 
				// ���� 
				String[] arr = line.split(":"); // �ݷ� �������� ���ظ� �Ѵ�. 
				
				if(arr[0].equals(Protocol.ENTER)){ // "100", "angel"
					writer.write(arr[1] + "�� �����Ͽ����ϴ� \n"); // line�� ���� �ν� ���ϱ� ������ �� ���� �־��ֱ� 
					writer.flush();

					
				}else if(arr[0].equals(Protocol.EXIT)){ //200�� ���� Protocol.EXIT�� �� ����(�ٸ� ����鵵 �˾ƺ� �� ����)
					// EXIT
					writer.write(arr[1] + "�� �����Ͽ����ϴ� \n");
					writer.flush();
					// Ŭ���̾�Ʈ�� close�Ǹ� ������ ���� close�Ѵ� 
					reader.close();
					writer.close();
					socket.close();

					System.exit(0);

				}else if(arr[0].equals(Protocol.SEND_MESSAGE)){
					// SEND-MESSAGE
					writer.write("[" +arr[1]+ "] " +arr[2]+"\n");
					writer.flush();
				}
				// Ŭ���̾�Ʈ�η� ������ (����)
			}catch(IOException e){
				e.printStackTrace();
			}
		}// while
	}
	public static void main(String[] args) {
		new ProtocolServer().service();	
	}
}
