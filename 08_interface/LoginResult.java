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

		public LoginResult(String id, String pwd){ // Login���� id, pwd �޴´�. 
			this.id = id; 
			this.pwd = pwd; // ������ �ʵ忡 ����..

			// frame ����
			setBounds(1200, 300, 200, 200); // ��ġ, âũ�� 
			setVisible(true);

			// �̺�Ʈ 
			this.addWindowListener(this);

		} // ������ 

		public void paint(Graphics g){
			// �Է¹��� id, pwd�� ���⵵ ����ϹǷ� �ʵ�� ���� 
			if(id.equals("angel") && pwd.equals("1004")){
				g.drawString("�α��� ����", 67, 100);
			}else {
				g.drawString("�α��� ����", 67, 100);
			}
		}

	

		//WindowListener override
		public void windowActivated(WindowEvent e){}
		public void windowClosed(WindowEvent e){}
		public void windowClosing(WindowEvent e){
			setVisible(false); //Loginâ�� �Բ� ������ �ʰ� 
		} 
		public void windowDeactivated(WindowEvent e){} // _ ���� 
		public void windowDeiconified(WindowEvent e){} // _ ������ ���� 
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}
	

	
}
