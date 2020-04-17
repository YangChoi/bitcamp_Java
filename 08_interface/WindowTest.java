import java.awt.Frame;
import java.awt.Graphics;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Label;
class WindowTest extends Frame implements MouseListener, MouseMotionListener, KeyListener{
	// WindowTest is a Frame 
	
	private int x, y; // paint와 mouseClicked 다 쓸 수 있다로고 

	//initial : 초기화 
	public void init(){
		setBounds(900, 100, 300, 400); // 위치, 창크기 
		setVisible(true);
		

		// 이벤트
		// 나에게서 일어난다(this)
		// 밑의 구현부는 다 내가 가지고 있다(this)
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addWindowListener(new WindowExit());
	}// init()

	// Graphics
	public void paint(Graphics g){
		// setVisitible 실행시 여기도 바로 호출됨 (0, 0 찍혀나옴 초기화값이 그렇다)
		g.drawString("X : " + x + " Y : " + y, x, y);	
		//sysout하면 콘솔에 찍히므로 g.draw 사용해서 frame에 찍히게 
		// 여기까지하면 클릭을 해도 좌표값이 바뀌지 않는다. 
		// 바뀌게 하려면 paint를 다시 불러야한다. 
		// 밑의 mouseClicked 에서 좌표값이 바뀌었으면 다시 paint를 불러서 좌표값을 바꿔준다. 
	}


	// MouseListener Override
	public void mouseClicked(MouseEvent e){
		x = e.getX();
		y = e.getY();
		System.out.println("마우스 클릭");
		System.out.println("X : " + x + "Y : " +y);
		// x, y좌표값을 확보했으면... 
		repaint(); // update() - paint() //pain를 다시 불러준다. 
		// repaint 시 앞의 값들을 버리기 때문에 메모리 찌꺼기가 남는다.
		// 그래서 속도가 좀 늦음. 
	

	}
	public void mouseEntered(MouseEvent e){
		System.out.println("마우스 In");
	}
	public void mouseExited(MouseEvent e){
		System.out.println("마우스 OUT");
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

	// MouseMotionListener Override
	public void mouseDragged(MouseEvent e){
		System.out.println("마우스 드래그");
	}
	public void mouseMoved(MouseEvent e){}

	// KeyListener Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0); // 프로그램 강제 종료 
			// ESCAPE의 아스키 코드는 27이므로 27으로 해줘도 된다. 
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	

	public static void main(String[] args){
		new WindowTest().init();
	}
	
}
