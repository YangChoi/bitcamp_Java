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


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class ChatClient extends JFrame implements ActionListener, Runnable{
	private JTextArea output; //output 용
	private JTextField input; 
	private JButton sendBtn;
	private Socket socket; // 소켓생성 
	private BufferedReader reader; 
	// bufferedWriter 안쓴다. 
	// 꼭 역슬래쉬를 붙여줘야하기 때문에..
	private PrintWriter writer; // 대신 printWriter를 써본다 

	public ChatClient(){
	
		output = new JTextArea(11, 23);
		output.setFont(new Font("Serif",Font.BOLD ,16));
		output.setEditable(false); // textarea를 수정 못하게 막는다. 

		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 스크롤 항상 보이기 
		add(scroll);

		JPanel sendP = new JPanel();
		sendP.setLayout(new BorderLayout()); // 화면을 늘리면 늘리는 대로 입력패널도 같이 늘어나게 (입력패널만 borderLayout 입힌다) 
		input = new JTextField();
		sendBtn = new JButton("보내기");
		sendP.add("Center", input); // 패널에서 input은 중앙에 위치 (가장 크게 잡히는 위치)
		sendP.add("East", sendBtn); // 패널에서 sendBtn은 동쪽에 위치 (가장 크게 잡히는 위치)
		
		Container c = getContentPane();
		
		c.add("Center", scroll);
		c.add("South", sendP);

		setTitle("채팅");
		setBounds(700, 200, 400, 500);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 그냥 꺼지면 안된다. 서버에게 끝낸다는 것을 알려줘야한다
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				// 이제 서버에게 끊겠다고 알리는 시점  
				writer.println("exit"); //(1)
				writer.flush();//(2)
			}
		});
	}
	
	public void service(){
		// 서버는 고정되지 않는다. 계속 바뀔 것이기 때문
		// 서버 IP를 따로 입력을 받는다. 
		//String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요",
		//						"서버IP", JOptionPane.INFORMATION_MESSAGE); // i 이모지가 뜨는 것이 INFORMATION_MESSAGE
		String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요",
								"192.168.28"); // 디폴트로 192 어쩌고가 들어간다. (아무말 설정이 없으면 ? 이모지가 뜬다)
	
		if(serverIP == null || serverIP.length() == 0){
			// null 일 경우는 없지만 가끔 있기 때문에 지정해준다. 
			// serverIP가 아예 잘못되면 채팅을 할 수 없으므로 종료 
			System.out.println("서버IP가 입력되지 않았습니다");
			System.exit(0);

		}

		// 닉네임 
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요.",
											"닉네임", JOptionPane.INFORMATION_MESSAGE);

		if(nickName == null || nickName.length() == 0){
			nickName = "guest"; // guest 라는 별명 준다. 
		}

		try{
			// 소켓생성 
			socket = new Socket(serverIP, 9500); // 서버IP가 고정적이면 안되기 때문 
			
			// SOCKET이 있지마자 IO가 들어온다 
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

		}catch(UnknownHostException e){
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);

		}catch(IOException e){
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}
		// 서버도 잘 찾고 연결이 잘 되었다면 
		// 들어온 표시를 한다 
		// 서버로 닉네임 보내기
		//writer.write(nickName); >> \n을 적어줘야한다. 
		writer.println(nickName); // \n 포함된 코드 
		writer.flush(); // 버퍼비우기
		
		// 스레드 
		Thread t = new Thread(this); // 나를 스레드로 만들어준다(this)
		
		// 스레드 시작
		t.start(); //>> run() 찾는다 
		
		// 이벤트 
		input.addActionListener(this);
		sendBtn.addActionListener(this);
	
	}// service()

	// start()에 의해서 여기로 도달한다 
	@Override
	public void run(){
		// 서버로부터 받기 
		String line;
		while(true){
			// 끝나고 나갈때까지 받는다. 

			try{
				line = reader.readLine();
				if(line == null || line.equals("exit")){

					// 종료되어도 백그라운드에서 스레드가 홀로 도는 경우가 있다. 
					// 그렇고 돌아가다 null이 들어올 수 있다.
					// 스레드가 홀로 돌다가 null이 들어온 경우도 종료로 간주하고 다 close 시키고 종료한다. 

					// 위에 window event로 exit를 받으면 종료하라 
					reader.close();
					writer.close();
					socket.close();

					System.exit(0);
				}

				// 종료가 아닌 일반적인 메세지일 경우 
				output.append(line + "\n"); // 받은 내용line을 output에 보낸다. 
				int pos = output.getText().length();
				// output의 text를 땡겨와 길이를 잰다. 
				output.setCaretPosition(pos); // 스크롤이 자동으로 따라감

			}catch(IOException e){
				e.printStackTrace();
			}
		}// while()
	} 

	// 버튼 액션 
	@Override
	public void actionPerformed(ActionEvent e){
		// 버튼 누르기는 물론 엔터 이벤트도 있어야한다. 
		// 버튼 이벤트는 텍스트 필드와 버튼 두군데서 발생 
	
		// input과 sendBtn 둘다 여기로 넘어온다. 
		// if문으로 갈라놓을 필요가 없다. >> 처리할 일이 같으니까. 
		// 보내기를 눌러 보내나, 엔터를 눌러 보내나 서버로 가는 것 똑같기 때문에 두 액션을 구분할 필요가 없다. 
		
		// 서버로 보내기 
		// JTextField 값 꺼내오기 
		String data = input.getText();
		// 꺼내온 데이터를 서버로 보내기 
		writer.println(data); 
		// 버퍼 비우기 
		writer.flush();
		// textfield를 꺠끗하게 비워준다 (초기화)
		input.setText("");

	}
	
	public static void main(String[] args) {
		new ChatClient().service();	
	}
}
