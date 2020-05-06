import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;

class ChatHandler extends Thread{
	// ó���ϴ� �� 
	// ������ ���ؼ� �Ѱ��ִ� �� (����)
	// �����尡 �Ǵ� �� 
	// ������ ������ ������ �ִ� �� 
	// Ŭ���̾�Ʈ�� ������ chatHandler�� ���ϰ� ��ȭ�ϴ� �� 
	
	private BufferedReader reader; 
	private PrintWriter writer; 
	
	// ChatHandler�� socket�� ������������ ���� socket�� server�� ������ �ִ�.
	// server�� �Ѱ��ش�. 
	private Socket socket;
	private List<ChatHandler> list;
	public ChatHandler(Socket socket, List<ChatHandler> list) throws IOException{
		// ������ ���� ���� ���� ������ ���� �޴´�.
		// �׷��� ������ �ȿ����� ��� ���� ������� ª���Ƿ� �ʵ�� ������. 
		this.socket = socket;
		//����Ʈ���� ������ ����־���ϳ�? ChatHandler�� ����ش�. 
		// ���� chathandler�� reader, writer������ �ֱ� ���� 
		this.list = list; 
	
		
		// reader, writer�� server�� �ƴ� handler �� ���´�. 
		// Ŭ���̾�Ʈ�κ��� �����͸� �ް� ������. 
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	// ������ ���� �� �ٷ� ã�� �޼��� run()
	@Override
	public void run(){
		try{
			// Ŭ���̾�Ʈ�κ��� �ޱ� 
			// Ŭ���̾�Ʈ�� �г����� ���� ���� ������. 
			String nickName = reader.readLine(); // �޽����� �о���δ�. 
			// ��� Ŭ���̾�Ʈ���� ���� �޽��� ������.(�� �ڽ� ����)
			broadcast(nickName + "�� �����Ͽ����ϴ�." ); // �г����� ��� Ŭ���̾�Ʈ�鿡�� ������. 
			
			// Ŭ���̾�Ʈ�κ��� ������ 
			String line;
			while(true){
				// Ŭ���̾�Ʈ�� ������ ������ 
				line = reader.readLine(); // �޽��� �ޱ� 
				if(line == null || line.equals("exit")){
				// ������� ������ �鿡�� ���� ������ üũ������Ѵ�.(null�� �� �� �ִ�) 
				
				// �� �ڽſ��� ������ �͵�
				// �������� exit�� ���� Ŭ���̾�Ʈ���� �亯 ������ 
				// �̰� �Ⱥ����� ��ǻ�Ͱ� �ƹ� �� ���� ��ٸ��⸸ �Ѵ�. 
				// �����
				// �ݵ�� �亯�� ��������Ѵ�. 
				writer.println("exit");
				writer.flush();
				reader.close();
				writer.close();
				socket.close();
				
				// ���� �ִ� Ŭ���̾�Ʈ 
				list.remove(this); // �� ������ ��(������ ��)�� list���� ���� 
				broadcast(nickName + "���� �����Ͽ����ϴ�.");
				// 1�� 1ä���� �ƴϴ�. 
				// �Ѹ��� �����ٰ� �ؼ� ������ Ŭ���̾�Ʈ�� ���� ���� ������ ���ϵ���� �������� �ȵȴ�. 
				// ���� �ֵ��� ������ ��������� ���� �ƴ� ���� �����ߴٴ� �޽����� ��������Ѵ�. 
				// �׷��� ���� ���� ������ �� list�� ��������Ѵ�. 
				break; // while ������ �� > catch : �� 

				} // if

				// ��� Ŭ���̾�Ʈ���� �޽��� ������ (�����°� �ƴ϶�� �޽��� ���� )
				broadcast("["+nickName+"]" + line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void broadcast(String msg){
		for(ChatHandler handler : list){ // list �ȿ� handler
			handler.writer.println(msg); // ���� �޽����� ������. 
			handler.writer.flush(); // ���� ����ֱ� 

		}// for
	}
}
