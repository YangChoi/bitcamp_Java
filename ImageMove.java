import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ImageMove extends Frame implements ActionListener, KeyListener, WindowListener {
	private Button setBtn, leftBtn, upBtn, downBtn, rightBtn;
	private int x=100, y=100;

	public void init(){
		setBtn = new Button("Set");
		leftBtn = new Button("Left");
		upBtn = new Button("Up");
		downBtn = new Button("Down");
		rightBtn = new Button("Right");

		Panel p = new Panel();
		p.add(setBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);

		add("North", p);

		setResizable(false);
		setBounds(700,100,500,500);
		setVisible(true);

		setBtn.setFocusable(false);
		leftBtn.setFocusable(false);
		upBtn.setFocusable(false);
		downBtn.setFocusable(false);
		rightBtn.setFocusable(false);
	}//init()

	public void event(){
		this.addWindowListener(this);

		setBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);

		this.addKeyListener(this);
	}//event()

	public void paint(Graphics g){
		Image img = Toolkit.getDefaultToolkit().getImage("duck.jpg");
		g.drawImage(img, x, y, this);
	}

	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		System.out.println("x="+x+"   y="+y);
		if(e.getSource() == setBtn){
			x=y=100;
		}else if(e.getSource() == leftBtn){
			x-=10;
			if(x <-120) x=460;
		}else if(e.getSource() == upBtn){
			y-=10;
			if(y<-90) y=460;
		}else if(e.getSource() == downBtn){
			y+=10;
			if(y>460) y=-90;
		}else if(e.getSource() == rightBtn){
			x+=10;
			if(x>460) x=-120;
		}

		repaint();
	}

	//KeyListener Override
	public void keyPressed(KeyEvent e){
		//if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
		if(e.getKeyCode() == 27){
			System.exit(0);   //프로그램 강제 종료
		}if(e.getKeyCode() == KeyEvent.VK_LEFT){
			x-=10;
			if(x <-120) x=460;
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			y-=10;
			if(y<-90) y=460;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			y+=10;
			if(y>460) y=-90;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			x+=10;
			if(x>460) x=-120;
		}
		repaint();
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}

	//WindowListener Override
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

	public static void main(String[] args) {
		ImageMove im = new ImageMove();
		im.init();
		im.event();
	}
}

