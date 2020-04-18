package hw03;

import java.awt.Button;
import java.awt.Color;
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

class ImageMove extends Frame implements ActionListener, WindowListener, KeyListener{
	private Button newBtn, leftBtn, upBtn, downBtn, rightBtn; 
	int img_x = 100;
	int img_y = 100;
	
	public void init(){
		// frame
		setBounds(500, 300, 500, 500);
		setVisible(true);
		setTitle("�̹����̵�");
		setResizable(false);
		
		// ��ư
		newBtn = new Button("NEW");
		leftBtn = new Button("��");
		upBtn = new Button("��");
		downBtn = new Button("��");
		rightBtn = new Button("��");
		
		
		// BTN ������ �г� 
		Panel btnP = new Panel();
		btnP.setBackground(new Color(200, 191, 231)); // �г� �� ����
		btnP.add(newBtn);
		btnP.add(leftBtn);
		btnP.add(upBtn);
		btnP.add(downBtn);
		btnP.add(rightBtn);
		
		add("North", btnP); // �г� ���ʿ� ��ġ 
	
		 
		
		// �������� �� �����ٰ� ���� ��ġ�����ϸ� �ٽ� �����ʿ��� ��������....
		
		

		// â�ݱ� Ȱ��ȭ 
		this.addWindowListener(this);
		// ��ư Ȱ��ȭ 
		newBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		
		// Ű���� Ȱ��ȭ 
		newBtn.addKeyListener(this);
		leftBtn.addKeyListener(this);
		upBtn.addKeyListener(this);
		downBtn.addKeyListener(this);
		rightBtn.addKeyListener(this);
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		// �����ӿ� �̹��� ���� 
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("D:/Again/Review/bird.png");
		g.drawImage(img, img_x, img_y, this);
		
	}
	
	//ActionListener Override 
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == newBtn) {
			img_x = 100;
			img_y = 100;
			repaint();
		}
		if(e.getSource() == leftBtn) {
			img_x -= 10;
			if(img_x == -80){
				img_x = 520;
			}
			repaint();
		}
		if(e.getSource() == upBtn) {
			img_y -= 10;
			if(img_y == -60) {
				img_y = 500;
			}
			repaint();
		}
		if(e.getSource() == downBtn) {
			img_y += 10;
			if(img_y == 500) {
				img_y = -60;
			}
			repaint();
		}
		if(e.getSource() == rightBtn) {
			img_x += 10;
			if(img_x == 520) {
				img_x = -60;
			}
			repaint();
		}
		
	}
		
	// KeyListener Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			img_x -= 10;
			if(img_x == -80){
				img_x = 520;
			}
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			img_x += 10;
			if(img_x == 520) {
				img_x = -60;
			}
			repaint();
			break;
		case KeyEvent.VK_UP:
			img_y -= 10;
			if(img_y == -60) {
				img_y = 500;
			}
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			img_y += 10;
			if(img_y == 500) {
				img_y = -60;
			}
			repaint();
			break;
		case KeyEvent.VK_SPACE:
			img_x = 100;
			img_y = 100;
			repaint();
			break;
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
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	
	public static void main(String[] args) {
		new ImageMove().init();
		
	}
}
