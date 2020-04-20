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

//JDK11������ HTML5�� font �±� ���� >> HTML5�� span���� ����� ��   

// *�� Ŭ�����������̽����� ������. 
// ���� java.awt.event.*;������ ���־���Ѵ�.
// event���� ��Ű���� * �ȸԴ´�. 

//font tag�� �Ӽ� (attribute)
/**
<font style ="color:red; font-size : 30px">
	�̹����� �̵��ϴ� Ŭ���� 
</font>
*/
class ImageMoveAgain extends Frame implements ActionListener, KeyListener, WindowListener{
	private Button newBtn, leftBtn, upBtn, downBtn, rightBtn; 
	/**
	<font style ="color:red; font-size : 30px">
		x�� y�� �̹����� ���� ��ġ 
	</font>
	*/
	private int x = 100, y = 100;
	/**
	<font style ="color:red; font-size : 30px">
		��ư�����ϰ� Frame ũ�⸦ ���� 
	</font>
	*/
	public void init(){

		// frame ����
		setResizable(false); // â ũ�� ���� �Ұ� 
		setBounds(700, 100, 500, 500); // ��ġ, âũ�� 
		setVisible(true);

	

		
		// button
		newBtn = new Button("NEW");
		leftBtn = new Button("��");
		upBtn = new Button("��");
		downBtn = new Button("��");
		rightBtn = new Button("��"); 

				
		// �г� �߰� 
		Panel p = new Panel();
		
		p.add(newBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		add("North", p); // �г� ���ʿ� ��ġ 


		// �� ��ư�� ��Ŀ���� ���� 
		// �׷��� VK_ESCAPE�� ���� 
		newBtn.setFocusable(false);
		downBtn.setFocusable(false);
		upBtn.setFocusable(false);
		rightBtn.setFocusable(false);
		leftBtn.setFocusable(false);

	} // init()
	

	// windowListener�� ���� �̺�Ʈ�� ����� �װͿ� ���� ó�� 
	// ������ ���� windowListener
	// ���� return�� �ִٸ� aa = im.event(); ��� ������ �޼ҵ带 �ҷ��� �� 
	public void event(){
		// �ؿ��� ������� �Դٰ� ������ �ٽ� ���ư� 
		this.addWindowListener(this); // �� �ڽſ��� �ִ� windowListener(this) // ���� WindowListener Override �ߴ�? (this ��)
		
		// ��ư�� ���� 
		newBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);

		//Ű���� �̺�Ʈ ó�� 
		this.addKeyListener(this);


	} // event()

	public void paint(Graphics g){
		// setVisible �� �ݹ�޼ҵ�� paint �Ҹ���. 
		// ���� repaint() �� �ٽ� �θ� �� ���� 
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
		if(e.getKeyCode() == 27){ // VK_ESCAPE : 27 // �� ��ư�� ��Ŀ���� ���� �����Ŵ 
			System.exit(0); // ���� 
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
	// Implements �� �� ���´� WindowListener�� ���� Ʋ�� �����Ƿ� �� ������ ���� ä�����Ѵ�. 
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
		ImageMoveAgain im = new ImageMoveAgain();
		// Ŭ���� ���� + ������ �޼ҵ�
		im.init();
		im.event();
	}
}
