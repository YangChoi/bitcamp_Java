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
	private JTextArea output; //output ��
	private JTextField input; 
	private JButton sendBtn;
	private Socket socket; // ���ϻ��� 
	private BufferedReader reader; 
	// bufferedWriter �Ⱦ���. 
	// �� ���������� �ٿ�����ϱ� ������..
	private PrintWriter writer; // ��� printWriter�� �ẻ�� 

	public ChatClient(){
	
		output = new JTextArea(11, 23);
		output.setFont(new Font("Serif",Font.BOLD ,16));
		output.setEditable(false); // textarea�� ���� ���ϰ� ���´�. 

		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // ��ũ�� �׻� ���̱� 
		add(scroll);

		JPanel sendP = new JPanel();
		sendP.setLayout(new BorderLayout()); // ȭ���� �ø��� �ø��� ��� �Է��гε� ���� �þ�� (�Է��гθ� borderLayout ������) 
		input = new JTextField();
		sendBtn = new JButton("������");
		sendP.add("Center", input); // �гο��� input�� �߾ӿ� ��ġ (���� ũ�� ������ ��ġ)
		sendP.add("East", sendBtn); // �гο��� sendBtn�� ���ʿ� ��ġ (���� ũ�� ������ ��ġ)
		
		Container c = getContentPane();
		
		c.add("Center", scroll);
		c.add("South", sendP);

		setTitle("ä��");
		setBounds(700, 200, 400, 500);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �׳� ������ �ȵȴ�. �������� �����ٴ� ���� �˷�����Ѵ�
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				// ���� �������� ���ڴٰ� �˸��� ����  
				writer.println("exit"); //(1)
				writer.flush();//(2)
			}
		});
	}
	
	public void service(){
		// ������ �������� �ʴ´�. ��� �ٲ� ���̱� ����
		// ���� IP�� ���� �Է��� �޴´�. 
		//String serverIP = JOptionPane.showInputDialog(this, "���� IP�� �Է��ϼ���",
		//						"����IP", JOptionPane.INFORMATION_MESSAGE); // i �̸����� �ߴ� ���� INFORMATION_MESSAGE
		String serverIP = JOptionPane.showInputDialog(this, "���� IP�� �Է��ϼ���",
								"192.168.28"); // ����Ʈ�� 192 ��¼�� ����. (�ƹ��� ������ ������ ? �̸����� ���)
	
		if(serverIP == null || serverIP.length() == 0){
			// null �� ���� ������ ���� �ֱ� ������ �������ش�. 
			// serverIP�� �ƿ� �߸��Ǹ� ä���� �� �� �����Ƿ� ���� 
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);

		}

		// �г��� 
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���.",
											"�г���", JOptionPane.INFORMATION_MESSAGE);

		if(nickName == null || nickName.length() == 0){
			nickName = "guest"; // guest ��� ���� �ش�. 
		}

		try{
			// ���ϻ��� 
			socket = new Socket(serverIP, 9500); // ����IP�� �������̸� �ȵǱ� ���� 
			
			// SOCKET�� �������� IO�� ���´� 
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

		}catch(UnknownHostException e){
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);

		}catch(IOException e){
			System.out.println("������ ������ �ȵǾ����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		// ������ �� ã�� ������ �� �Ǿ��ٸ� 
		// ���� ǥ�ø� �Ѵ� 
		// ������ �г��� ������
		//writer.write(nickName); >> \n�� ��������Ѵ�. 
		writer.println(nickName); // \n ���Ե� �ڵ� 
		writer.flush(); // ���ۺ���
		
		// ������ 
		Thread t = new Thread(this); // ���� ������� ������ش�(this)
		
		// ������ ����
		t.start(); //>> run() ã�´� 
		
		// �̺�Ʈ 
		input.addActionListener(this);
		sendBtn.addActionListener(this);
	
	}// service()

	// start()�� ���ؼ� ����� �����Ѵ� 
	@Override
	public void run(){
		// �����κ��� �ޱ� 
		String line;
		while(true){
			// ������ ���������� �޴´�. 

			try{
				line = reader.readLine();
				if(line == null || line.equals("exit")){

					// ����Ǿ ��׶��忡�� �����尡 Ȧ�� ���� ��찡 �ִ�. 
					// �׷��� ���ư��� null�� ���� �� �ִ�.
					// �����尡 Ȧ�� ���ٰ� null�� ���� ��쵵 ����� �����ϰ� �� close ��Ű�� �����Ѵ�. 

					// ���� window event�� exit�� ������ �����϶� 
					reader.close();
					writer.close();
					socket.close();

					System.exit(0);
				}

				// ���ᰡ �ƴ� �Ϲ����� �޼����� ��� 
				output.append(line + "\n"); // ���� ����line�� output�� ������. 
				int pos = output.getText().length();
				// output�� text�� ���ܿ� ���̸� ���. 
				output.setCaretPosition(pos); // ��ũ���� �ڵ����� ����

			}catch(IOException e){
				e.printStackTrace();
			}
		}// while()
	} 

	// ��ư �׼� 
	@Override
	public void actionPerformed(ActionEvent e){
		// ��ư ������� ���� ���� �̺�Ʈ�� �־���Ѵ�. 
		// ��ư �̺�Ʈ�� �ؽ�Ʈ �ʵ�� ��ư �α����� �߻� 
	
		// input�� sendBtn �Ѵ� ����� �Ѿ�´�. 
		// if������ ������� �ʿ䰡 ����. >> ó���� ���� �����ϱ�. 
		// �����⸦ ���� ������, ���͸� ���� ������ ������ ���� �� �Ȱ��� ������ �� �׼��� ������ �ʿ䰡 ����. 
		
		// ������ ������ 
		// JTextField �� �������� 
		String data = input.getText();
		// ������ �����͸� ������ ������ 
		writer.println(data); 
		// ���� ���� 
		writer.flush();
		// textfield�� �Ʋ��ϰ� ����ش� (�ʱ�ȭ)
		input.setText("");

	}
	
	public static void main(String[] args) {
		new ChatClient().service();	
	}
}
