import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.OutputStreamWriter;
import java.net.Socket;

class ProtocolClient {
	// Ŭ���̾�Ʈ�� �ڵ����� �־���Ѵ� (������ ��ȭ�� �� ��) 
	// ��� �����ʹ� �ڵ����� ���ؼ� (�ڵ��� = ����)
	private Socket socket;
	private BufferedReader reader; // ������ ���� ������ �� 
	private BufferedWriter writer; 
	private BufferedReader keyboard; // Ű���带 ���� ������ ��
	
	public ProtocolClient(){
		try{
			socket = new Socket("192.168.0.28", 9500); // ���� ���� && ������ ������ ����IP, ��Ʈ��ȣ �ʿ�  
			// ���� ������ ���� Ŭ���̾�Ʈ�� ���� 
			// ip �ּҴ� ipconfig�� 
			// ping : ��Ʈ��ũ �˻� 
			// ping �� ip : �� ip �� �۵��ϴ���
			
			// ������ ���� ������ ��� 
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// Ű���带 ���� ������ ��� 
			keyboard = new BufferedReader(new InputStreamReader(System.in));
		}catch(UnknownHostException e){
			// �˼����� ������ ���� �� 
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);

		}catch(IOException e){
			// ������ ������ �ȵǴ� ��� : reader�� writer���� ���� ���� 
			System.out.println("������ ������ �ȵǾ����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void service(){
		String msg, line;

		while(true){
			// ����ڰ� ��ȭ�� ���� �� ���� 
			// Protocol�� EXIT ����� �ö����� 
			try{
				// ������ ������ : protocolServer.java�� ������ �� 
				// Ű����κ��� �޽����� �޴´�. (Ű����κ��� ������ �б� )
				msg = keyboard.readLine(); // ���͸� ĥ ������ �� �������� ����. (readLine�� ���͸� ���� �ʴ´� ) >> angel:200
				writer.write(msg+"\n"); // �����κ��� ������ >> ���� 
				// ���������� reader.readLine���� �д´�. �׷��� ���ʴ� readLine�̸� ���� ���͸� ã�µ� Ŭ���̾�Ʈ�� ���͸� ���� ���� ����. 
				// �׷��� ������ ���͸� �� �Բ� �������Ѵ�. 
				//writer.println(msg); �� ��쵵 �������� ���� �ڵ�� ������ �߿伺�� �˸��� ���� �Ϻη� ����.. 
				// writer.close(); �� ���� �ȵȴ�. ����ȴ�. 
				writer.flush(); // ���ۿ� ���� ��⸦ ����ش�. 
				// �׷��� ���� �����Ͱ� ���� �ڸ��� ����� ( ��ȭ�� �� �� �� �ϰ� ���� ���� �ƴϱ� ������ ) ���� �� Sytem.in.read(); �� ����� ��� 
				
				// �����κ��� �ޱ� 
				// �����κ��� ���� ���� �о �´� 
				line = reader.readLine(); 
				System.out.println(line); // �Ѿ�� ���� �� �ָ� �ȴ�. 
				
				// 200 : ���� 
				String[] arr = msg.split(":"); //�ݷ� �������� ���ڿ��� ������ �迭�� �޴´� >> "200", "angel" 
				if(arr[0].equals(Protocol.EXIT)){
					// ..���� �����ϼ̽��ϴ� �޼����� ���� line���� ��µ� ���� 
					// ���ʷ� close ���ش�. 
					reader.close();
					writer.close();
					socket.close();

					System.exit(0); // ���α׷��� ���̻� ������ �ʿ䰡 �����Ƿ� ���α׷� ���� 
				}
			}catch(IOException e){
				// ����ó���� �� ��� ������ ����ó���� �ʿ����� �����޽����� �� ���� ������ �Ǵ��Ѵ�.

				e.printStackTrace(); // �׳� �����޽����� ���� 
			}
		}// while()
	}
	public static void main(String[] args) {
		new ProtocolClient().service();
	}
}
