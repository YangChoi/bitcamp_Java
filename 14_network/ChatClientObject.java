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
	
	// ��ü�� �о�´�. 
	private ObjectInputStream reader; 
	private ObjectOutputStream writer;  
	

	public ChatClientObject(){
		output = new JTextArea();
		output.setFont(new Font("Serif", Font.BOLD, 16));
		output.setEditable(false); // textarea ���� ���ϰ� 

		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // ��ũ�ѹ� �׻��̱� 
		

		JPanel sendP = new JPanel();
		sendP.setLayout(new BorderLayout());
		input = new JTextField();
		sendBtn = new JButton("������");
		sendP.add("Center", input);
		sendP.add("East", sendBtn);

		Container c = getContentPane();

		c.add("Center", scroll);
		c.add("South", sendP);

		setTitle("ä��");
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
	
		String serverIP = JOptionPane.showInputDialog(this, "���� IP�� �Է��ϼ���",
								"192.168.28");

		if(serverIP == null || serverIP.length() == 0){
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);

		}
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���.",
											"�г���", JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0){
			nickName = "guest";
		}


		try{
			// ���ϻ��� 
			socket = new Socket(serverIP, 9500); // ����IP�� �������̸� �ȵǱ� ���� 
		
			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());

		}catch(UnknownHostException e){
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);

		}catch(IOException e){
			System.out.println("������ ������ �ȵǾ����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		
		// ������ �г��� ������ 
		InfoDTO infoDTO = new InfoDTO();
		
		// ���� ���� ���� command�� �Ѱ��ش� 
		infoDTO.setCommand(Info.JOIN); // ����
		infoDTO.setNickName(nickName); // �г��� ���� 
		try{
			writer.writeObject(infoDTO); // infoDTO�� ������.  

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
		// ������ ���� �ޱ� 
		InfoDTO infoDTO = null;

		while(true){
				
			try{
				// OBJECT�� �����µ� �� infoDTO�� �޴��� : ����ȯ
				infoDTO = (InfoDTO)reader.readObject(); // object�� �о�´� 	
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
	
	// ��ư�׼� 
	@Override
	public void actionPerformed(ActionEvent e){
		String data = input.getText();
		InfoDTO infoDTO = new InfoDTO();

		// data�� ���뿡 ���� ����� �޶�����(�޼����ϼ��� �ְ� info�ϼ��� �ְ�)
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
