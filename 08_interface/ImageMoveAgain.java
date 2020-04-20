import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

//JDK11에서는 HTML5의 font 태그 없음 >> HTML5의 span으로 사용할 것   

// *은 클래스인터페이스에만 먹힌다. 
// 따라서 java.awt.event.*;까지는 써주어야한다.
// event같은 패키지는 * 안먹는다. 

//font tag의 속성 (attribute)
/**
<font style ="color:red; font-size : 30px">
	이미지를 이동하는 클래스 
</font>
*/
class ImageMoveAgain extends Frame implements ActionListener, KeyListener, WindowListener{
	private Button newBtn, leftBtn, upBtn, downBtn, rightBtn; 
	/**
	<font style ="color:red; font-size : 30px">
		x와 y는 이미지의 시작 위치 
	</font>
	*/
	private int x = 100, y = 100;
	/**
	<font style ="color:red; font-size : 30px">
		버튼생성하고 Frame 크기를 설정 
	</font>
	*/
	public void init(){

		// frame 설정
		setResizable(false); // 창 크기 변경 불가 
		setBounds(700, 100, 500, 500); // 위치, 창크기 
		setVisible(true);

	

		
		// button
		newBtn = new Button("NEW");
		leftBtn = new Button("←");
		upBtn = new Button("↑");
		downBtn = new Button("↓");
		rightBtn = new Button("→"); 

				
		// 패널 추가 
		Panel p = new Panel();
		
		p.add(newBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		add("North", p); // 패널 북쪽에 위치 


		// 각 버튼의 포커스를 버림 
		// 그래야 VK_ESCAPE가 먹음 
		newBtn.setFocusable(false);
		downBtn.setFocusable(false);
		upBtn.setFocusable(false);
		rightBtn.setFocusable(false);
		leftBtn.setFocusable(false);

	} // init()
	

	// windowListener에 대한 이벤트를 만들고 그것에 대한 처리 
	// 리턴이 없는 windowListener
	// 만약 return이 있다면 aa = im.event(); 라는 식으로 메소드를 불렀을 것 
	public void event(){
		// 밑에서 여기까지 왔다가 끝나면 다시 돌아감 
		this.addWindowListener(this); // 내 자신에게 있는 windowListener(this) // 누가 WindowListener Override 했니? (this 나)
		
		// 버튼들 실행 
		newBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);

		//키보드 이벤트 처리 
		this.addKeyListener(this);


	} // event()

	public void paint(Graphics g){
		// setVisible 때 콜백메소드로 paint 불린다. 
		// 이후 repaint() 때 다시 부를 수 있음 
		//Toolkit t = Toolkit.getDefaultToolkit(); 
		//Image img = t.getImage("D:/java_se/workspace/08_interface/bird.png");
		Image img = Toolkit.getDefaultToolkit().getImage("bird.png");
		g.drawImage(img, x, y, this);


	}
	
	// ActionListenr Override
	public void actionPerformed(ActionEvent e){
		System.out.println("x= " +x+ "y = " + y);
		if(e.getSource() == newBtn){
			x = 100;
			y = 100;
		}else if(e.getSource() == leftBtn){
			x -= 10;
			if(x < -120){
				x = 460;
			}
		}else if(e.getSource() == rightBtn){
			x += 10;
			if(x == 520) {
				x = -60;
			}
		}else if(e.getSource() == upBtn){
			y -= 10;
			if(y == -60) {
				y = 500;
			}
		}else if(e.getSource() == downBtn){
			y += 10;
			if(y == 500) {
				y = -60;
			}
		}
		repaint();
	}

	//KeyListener Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 27){ // VK_ESCAPE : 27 // 각 버튼의 포커스를 버려 적용시킴 
			System.exit(0); // 종료 
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			x = 100; 
			y = 100;
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			y -= 10;
			if(y == -60) {
				y = 500;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			y += 10;
			if(y == 500) {
				y = -60;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			x -= 10;
			if(x < -120){
				x = 460;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			x += 10;
			if(x == 520) {
				x = -60;
			}
		}
		repaint();
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	// WindowListener Override
	// Implements 만 한 상태는 WindowListener에 대한 틀만 있으므로 그 내용은 내가 채워야한다. 
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
		ImageMoveAgain im = new ImageMoveAgain();
		// 클래스 생성 + 생성자 메소드
		im.init();
		im.event();
	}
}
