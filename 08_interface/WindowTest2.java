import java.awt.Button;
import java.awt.Frame;

import java.awt.Panel;
import java.awt.Color;

import java.awt.TextArea;
import java.awt.Font;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



//Frame - BorderLayout(��������)
// 
class WindowTest2 extends Frame implements ActionListener, WindowListener{
	private Button newBtn, exitBtn; // ��ư
	private TextArea area; 

	public void init(){
		//button
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");

		//TextArea
		area = new TextArea();
		area.setFont(new Font("BernhardFashion BT", Font.BOLD, 20)); // textarea ��Ʈ ����

		// panel (BTN���� ������ �г�)
		Panel p = new Panel(); // FlowLayout(�߾�~ ������� ��ġ)
		p.setBackground(new Color(100, 200, 255)); // �г� ���� ���� 
		p.add(newBtn);
		p.add(exitBtn); // �гο� �� ��ư�� �ִ´�
	
		add("North", p); // ���ʿ��� �г� ����
		add("Center", area); // �߾ӿ��� area ����

		//frame ����
		setBounds(900, 100, 300, 400); // ��ġ, âũ�� 
		setVisible(true);

		// event 
		// windowListener �����θ� ���� ������ �����Ƿ� this
		this.addWindowListener(this);
		exitBtn.addActionListener(this); // �̺�Ʈ�� �߻��ϴ� �ְ� exitBtn
		newBtn.addActionListener(this);
	}

	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == newBtn){
			area.setText(" "); //area�� �ʱ�ȭ
			area.setText(""); // �ٵ� �̰� �����ϳ��� ���°� �ȵǱ� ������ �ι��ϱ�..(���ٸ��� ���� �پ� ��
		}else if(e.getSource() == exitBtn){
			System.exit(0); //���� event���� �˷��ְ� ���⼭ ���� 
		}
	}

	// WindowListener Override
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		System.exit(0); // â�� ��������. 
	} // x�� ������ ���� 
	public void windowDeactivated(WindowEvent e){} // _ ���� 
	public void windowDeiconified(WindowEvent e){} // _ ������ ���� 
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}


	public static void main(String[] args) {
		new WindowTest2().init();
	}
}
