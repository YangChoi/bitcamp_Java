import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.net.Socket;

class ChatServerObject {

	private ServerSocket serverSocket;
	private List<ChatHandlerObject> list;


	public ChatServerObject(){
		
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("서버 준비 완료");

			list = new ArrayList<ChatHandlerObject>();

			while(true){
				Socket socket = serverSocket.accept();
				ChatHandlerObject handler = new ChatHandlerObject(socket, list); 
				handler.start();

				list.add(handler);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ChatServerObject();
	}
}
