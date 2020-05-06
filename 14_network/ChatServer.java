import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

class ChatServer {
	// ���� 
	private ServerSocket serverSocket;
	private List<ChatHandler> list; // ���ϵ��� ��� �������� ArrayList ( �θ��� List�� ��´�) >> new �ȵǴ� �������̽� list 
	public ChatServer(){

		try{
			serverSocket = new ServerSocket(9500); // 9500�� ��Ʈ�� ��� ��ٸ���. 
			System.out.println("���� �غ� �Ϸ�");
			
			list = new ArrayList<ChatHandler>(); // ArrayList�� new ���ش�. 
			// protocolClient.java�� Ŭ���̾�Ʈ�� �ϳ� �ۿ� ������ �ʱ� ������ ������ �ϳ�, ���� list�� ���� �������� �ʿ䰡 ����.
			
			// Ŭ���̾�Ʈ�� ������ ����ä���Ѵ�. (accept)
			// �׷��� Ŭ���̾�Ʈ�� ���� ������ ����ä���Ѵ� >> ������ accept
			while(true){
				// Ŭ���̾�Ʈ�� ���� ������ 
				Socket socket = serverSocket.accept(); // ����ä�� 
				// ä��â�� �������� �� �� Ŭ���̾�Ʈ�� ���������� ��ȭ�� ���� ���� �ƴϴ� 
				// �������̴�. 
				// �׷��� �� ��ȭ������ �޾��� ������ ���� ���� �����尡 �Ǿ���Ѵ�. 
				// Ŭ���̾�Ʈ ���ϵ��� �����尡 �ȴٰ� �ϸ� ������ ���ϵ鵵 �����尡 ���־���Ѵ�. 
				// ��. ���� ��ü�� �����尡 �Ǵ� ���� �ƴϴ�. ������ �����尡 �����尡 �Ǵ� ���̴�. 
				// ������ ������ �� �� ����. kt ������ �ϳ���, kt�� �������� �������� ��. 
				// chatHandler�� �����. 
				ChatHandler handler = new ChatHandler(socket, list); // chathandler���� socket�� �����ش�.(ChatHandler�� thread�� ��ӹ޾����Ƿ� 
				// chathandler�� �� �������̴�) >> ������ ����
				handler.start(); // ������ ���� 
				
				list.add(handler); // list �ȿ� chathandler�� �ִ´�. (�� �ڵ鷯�� Ŭ���̾�Ʈ�� �����̴�)
				

			}// while
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
