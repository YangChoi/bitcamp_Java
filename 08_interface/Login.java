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
	private TextField idT, pwdT; // 딱 한 줄 쓸 수 있는 TextField
	private Button loginBtn, cancelBtn;
	
	public Login(){
		
		setLayout(null); // layout의 모든 배치 백지화 - 정 가운데에 idt 넣을 것이기 때문에 

		//Label
		Label idL = new Label("아이디");  // 아이디 라벨
		idL.setBounds(50, 80, 50, 26);
		
		Label pwdL = new Label("비밀번호"); // 비밀번호 라벨 
		pwdL.setBounds(50, 110, 50, 26);

		//button
		loginBtn = new Button("로그인");
		cancelBtn = new Button("취소");

		loginBtn.setBounds(80, 150, 60, 40);
		cancelBtn.setBounds(150, 150, 60, 40);

		// textField
		idT = new TextField(); // 아이디 텍스트필드 
		idT.setBounds(120, 80, 100, 26);

		pwdT = new TextField(); // 비밀번호 텍스트필드 
		pwdT.setBounds(120, 108, 100, 26); 
		pwdT.setEchoChar('*'); // 비밀번호 가리기 
	

		// frame에 붙이기 
		add(idL); 
		add(idT);
		add(pwdL); 
		add(pwdT);
		add(loginBtn);
		add(cancelBtn);

		// frame 설정
		setBounds(900, 100, 300, 300); // 위치, 창크기 
		setVisible(true);
		
		// 이벤트
		this.addWindowListener(new WindowExit()); // x버튼 누르면 창 닫히게 
		loginBtn.addActionListener(this);
		cancelBtn.addActionListener(this); 
		
		
	
	}
	
	//ActionListener Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == loginBtn){
				String id = idT.getText(); // 값을 꺼내옴 
				String pwd = pwdT.getText();
				new LoginResult(id, pwd); // LoginResult 부르기 
				// 생성자를 통해서 LoginResult에 id, pwd 값 주기 

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
Event Source - 누가 ? 어디서 ? 
Event Listener 
Event Handler (구현부)

Source.addListener(Handler의 위치) 

*/