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



//Frame - BorderLayout(동서남북)
// 
class WindowTest2 extends Frame implements ActionListener, WindowListener{
	private Button newBtn, exitBtn; // 버튼
	private TextArea area; 

	public void init(){
		//button
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");

		//TextArea
		area = new TextArea();
		area.setFont(new Font("BernhardFashion BT", Font.BOLD, 20)); // textarea 폰트 설정

		// panel (BTN들을 감싸줄 패널)
		Panel p = new Panel(); // FlowLayout(중앙~ 순서대로 배치)
		p.setBackground(new Color(100, 200, 255)); // 패널 배경색 지정 
		p.add(newBtn);
		p.add(exitBtn); // 패널에 각 버튼을 넣는다
	
		add("North", p); // 북쪽에다 패널 넣음
		add("Center", area); // 중앙에다 area 넣음

		//frame 설정
		setBounds(900, 100, 300, 400); // 위치, 창크기 
		setVisible(true);

		// event 
		// windowListener 구현부를 내가 가지고 있으므로 this
		this.addWindowListener(this);
		exitBtn.addActionListener(this); // 이벤트를 발생하는 애가 exitBtn
		newBtn.addActionListener(this);
	}

	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == newBtn){
			area.setText(" "); //area를 초기화
			area.setText(""); // 근데 이게 공백하나로 덮는게 안되기 때문에 두번하기..(별다른거 없이 근야 ㅇ
		}else if(e.getSource() == exitBtn){
			System.exit(0); //위의 event에서 알려주고 여기서 실행 
		}
	}

	// WindowListener Override
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		System.exit(0); // 창을 꺼버린다. 
	} // x를 누르는 시점 
	public void windowDeactivated(WindowEvent e){} // _ 해제 
	public void windowDeiconified(WindowEvent e){} // _ 누르는 시점 
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}


	public static void main(String[] args) {
		new WindowTest2().init();
	}
}
