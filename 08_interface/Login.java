import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.Font;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Login extends Frame implements ActionListener{
	private TextField idT, pwdT; // �� �� �� �� �� �ִ� TextField
	private Button loginBtn, cancelBtn;
	
	public Login(){
		
		setLayout(null); // layout�� ��� ��ġ ����ȭ - �� ����� idt ���� ���̱� ������ 

		//Label
		Label idL = new Label("���̵�");  // ���̵� ��
		idL.setBounds(50, 80, 50, 26);
		
		Label pwdL = new Label("��й�ȣ"); // ��й�ȣ �� 
		pwdL.setBounds(50, 110, 50, 26);

		//button
		loginBtn = new Button("�α���");
		cancelBtn = new Button("���");

		loginBtn.setBounds(80, 150, 60, 40);
		cancelBtn.setBounds(150, 150, 60, 40);

		// textField
		idT = new TextField(); // ���̵� �ؽ�Ʈ�ʵ� 
		idT.setBounds(120, 80, 100, 26);

		pwdT = new TextField(); // ��й�ȣ �ؽ�Ʈ�ʵ� 
		pwdT.setBounds(120, 108, 100, 26); 
		pwdT.setEchoChar('*'); // ��й�ȣ ������ 
	

		// frame�� ���̱� 
		add(idL); 
		add(idT);
		add(pwdL); 
		add(pwdT);
		add(loginBtn);
		add(cancelBtn);

		// frame ����
		setBounds(900, 100, 300, 300); // ��ġ, âũ�� 
		setVisible(true);
		
		// �̺�Ʈ
		this.addWindowListener(new WindowExit()); // x��ư ������ â ������ 
		loginBtn.addActionListener(this);
		cancelBtn.addActionListener(this); 
		
		
	
	}
	
	//ActionListener Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == loginBtn){
				String id = idT.getText(); // ���� ������ 
				String pwd = pwdT.getText();
				new LoginResult(id, pwd); // LoginResult �θ��� 
				// �����ڸ� ���ؼ� LoginResult�� id, pwd �� �ֱ� 

			}else if(e.getSource() == cancelBtn){
				idT.setText(" ");
				idT.setText(""); 
				pwdT.setText(" ");
				pwdT.setText("");
			}
		}
	

	public static void main(String[] args) {
		new Login();
	}
}

/*
Event Source - ���� ? ��� ? 
Event Listener 
Event Handler (������)

Source.addListener(Handler�� ��ġ) 

*/