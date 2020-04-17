import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.Font;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

import java.awt.Graphics;

class LoginResult extends Frame implements WindowListener {
		private String id, pwd;

		public LoginResult(String id, String pwd){ // Login에서 id, pwd 받는다. 
			this.id = id; 
			this.pwd = pwd; // 데이터 필드에 전달..

			// frame 설정
			setBounds(1200, 300, 200, 200); // 위치, 창크기 
			setVisible(true);

			// 이벤트 
			this.addWindowListener(this);

		} // 생성자 

		public void paint(Graphics g){
			// 입력받은 id, pwd를 여기도 써야하므로 필드로 지정 
			if(id.equals("angel") && pwd.equals("1004")){
				g.drawString("로그인 성공", 67, 100);
			}else {
				g.drawString("로그인 실패", 67, 100);
			}
		}

	

		//WindowListener override
		public void windowActivated(WindowEvent e){}
		public void windowClosed(WindowEvent e){}
		public void windowClosing(WindowEvent e){
			setVisible(false); //Login창과 함께 꺼지지 않게 
		} 
		public void windowDeactivated(WindowEvent e){} // _ 해제 
		public void windowDeiconified(WindowEvent e){} // _ 누르는 시점 
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}
	

	
}
