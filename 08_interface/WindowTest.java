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
	
	private int x, y; // paint�� mouseClicked �� �� �� �ִٷΰ� 

	//initial : �ʱ�ȭ 
	public void init(){
		setBounds(900, 100, 300, 400); // ��ġ, âũ�� 
		setVisible(true);
		

		// �̺�Ʈ
		// �����Լ� �Ͼ��(this)
		// ���� �����δ� �� ���� ������ �ִ�(this)
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addWindowListener(new WindowExit());
	}// init()

	// Graphics
	public void paint(Graphics g){
		// setVisitible ����� ���⵵ �ٷ� ȣ��� (0, 0 �������� �ʱ�ȭ���� �׷���)
		g.drawString("X : " + x + " Y : " + y, x, y);	
		//sysout�ϸ� �ֿܼ� �����Ƿ� g.draw ����ؼ� frame�� ������ 
		// ��������ϸ� Ŭ���� �ص� ��ǥ���� �ٲ��� �ʴ´�. 
		// �ٲ�� �Ϸ��� paint�� �ٽ� �ҷ����Ѵ�. 
		// ���� mouseClicked ���� ��ǥ���� �ٲ������ �ٽ� paint�� �ҷ��� ��ǥ���� �ٲ��ش�. 
	}


	// MouseListener Override
	public void mouseClicked(MouseEvent e){
		x = e.getX();
		y = e.getY();
		System.out.println("���콺 Ŭ��");
		System.out.println("X : " + x + "Y : " +y);
		// x, y��ǥ���� Ȯ��������... 
		repaint(); // update() - paint() //pain�� �ٽ� �ҷ��ش�. 
		// repaint �� ���� ������ ������ ������ �޸� ��Ⱑ ���´�.
		// �׷��� �ӵ��� �� ����. 
	

	}
	public void mouseEntered(MouseEvent e){
		System.out.println("���콺 In");
	}
	public void mouseExited(MouseEvent e){
		System.out.println("���콺 OUT");
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

	// MouseMotionListener Override
	public void mouseDragged(MouseEvent e){
		System.out.println("���콺 �巡��");
	}
	public void mouseMoved(MouseEvent e){}

	// KeyListener Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0); // ���α׷� ���� ���� 
			// ESCAPE�� �ƽ�Ű �ڵ�� 27�̹Ƿ� 27���� ���൵ �ȴ�. 
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	

	public static void main(String[] args){
		new WindowTest().init();
	}
	
}
