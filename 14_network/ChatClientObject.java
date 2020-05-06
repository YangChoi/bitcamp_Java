import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.IOException;
import java.net.UnknownHostException;
import java.net.Socket;

class ChatClientObject extends JFrame implements ActionListener, Runnable{
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	
	// 객체를 읽어온다. 
	private ObjectInputStream reader; 
	private ObjectOutputStream writer;  
	

	public ChatClientObject(){
		output = new JTextArea();
		output.setFont(new Font("Serif", Font.BOLD, 16));
		output.setEditable(false); // textarea 수정 못하게 

		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 스크롤바 항상보이기 
		

		JPanel sendP = new JPanel();
		sendP.setLayout(new BorderLayout());
		input = new JTextField();
		sendBtn = new JButton("보내기");
		sendP.add("Center", input);
		sendP.add("East", sendBtn);

		Container c = getContentPane();

		c.add("Center", scroll);
		c.add("South", sendP);

		setTitle("채팅");
		setBounds(700, 200, 400, 500);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				InfoDTO infoDTO = new InfoDTO();
				infoDTO.setCommand(Info.EXIT);
				try{
					writer.writeObject(infoDTO);
					writer.flush(); 
				}catch(IOException io){
					io.printStackTrace();
				}
			}
		});

	}

	public void service(){
	
		String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요",
								"192.168.28");

		if(serverIP == null || serverIP.length() == 0){
			System.out.println("서버IP가 입력되지 않았습니다");
			System.exit(0);

		}
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요.",
											"닉네임", JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0){
			nickName = "guest";
		}


		try{
			// 소켓생성 
			socket = new Socket(serverIP, 9500); // 서버IP가 고정적이면 안되기 때문 
		
			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());

		}catch(UnknownHostException e){
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);

		}catch(IOException e){
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}
		
		// 서버로 닉네임 보내기 
		InfoDTO infoDTO = new InfoDTO();
		
		// 가장 뭐를 할지 command를 넘겨준다 
		infoDTO.setCommand(Info.JOIN); // 입장
		infoDTO.setNickName(nickName); // 닉네임 보냄 
		try{
			writer.writeObject(infoDTO); // infoDTO를 보낸다.  

			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}

		Thread t = new Thread(this);
		t.start();

		input.addActionListener(this);
		sendBtn.addActionListener(this);

	}

	@Override
	public void run(){
		// 서버로 부터 받기 
		InfoDTO infoDTO = null;

		while(true){
				
			try{
				// OBJECT로 보내는데 왜 infoDTO가 받느냐 : 형변환
				infoDTO = (InfoDTO)reader.readObject(); // object로 읽어온다 	
				if(infoDTO.getCommand() == Info.EXIT){
					reader.close();
					writer.close();
					socket.close();

					System.exit(0);
				}else if(infoDTO.getCommand() == Info.SEND){
					output.append(infoDTO.getMessage() + "\n");
					int pos = output.getText().length();
					output.setCaretPosition(pos);
				}
			
			}catch(IOException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		} // while()
	}
	
	// 버튼액션 
	@Override
	public void actionPerformed(ActionEvent e){
		String data = input.getText();
		InfoDTO infoDTO = new InfoDTO();

		// data의 내용에 따라 명령이 달라진다(메세지일수도 있고 info일수도 있고)
		if(data.equals("exit")){
			infoDTO.setCommand(Info.EXIT);
		}else {
			infoDTO.setCommand(Info.SEND); 
			infoDTO.setMessage(data); 
		}
		try{
			writer.writeObject(infoDTO); 
			writer.flush();
			input.setText("");
		}catch(IOException io){
			io.printStackTrace();
		}
		input.setText("");
	}
	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}
