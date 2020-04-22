import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PacMan extends Frame implements Runnable, KeyListener{
		private	int	sel = 2;
		int x1 = 225;
		int y1 = 225;

		int x2 = 275;
		int y2 = 275; 
	
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = Toolkit.getDefaultToolkit().getImage("pacman.png");
		Image foodImg = Toolkit.getDefaultToolkit().getImage("foodImg.png");

	public PacMan(){
		setBounds(700, 200, 500, 500);
		setVisible(true);
		setResizable(false);

		// â �ݱ� 
		this.addWindowListener(new WindowAdapter(){
			@Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});

		// ������ ���� 
		Thread t = new Thread(this); // �� �ڽ��� ������� ����� �ʹ� : this
		// ������ ���� 
		t.start(); // ������ ����(run())

		//Ű���� �̺�Ʈ ó�� 
		this.addKeyListener(this);

	}// PacMan() 
		
		// �Ѹ� �׸� ���߾� ����
		@Override
		public void paint(Graphics g){
			g.drawImage(img, x1, y1, x2, y2, // ȭ����ġ  
						sel*50, 0, sel*50+50, 50,// �̹��� ��ġ 
						this);
			// �Ѹ��� ���� �Դٰ��� �Ϸ��� �����带 ����ؾ��Ѵ�. 
			
			// �Ѹ� ���� �׸� 
			int[] numX = new int[5];
			int[] numY = new int[5];
			int foodX; // ���� x��ǥ
			int foodY; // ���� y��ǥ
			
			for(int i = 0; i < numX.length; i++){
				foodX = (int)(Math.random()*501)+0;
				foodY = (int)(Math.random()*501)+0;

				numX[i] = foodX;
				numY[i] = foodY;
			}
			for(int i = 0; i < numX.length; i++){
			
				g.drawImage(foodImg, numX[i],numY[i], this);
			} 
		
		
			
		}
		

		@Override
		public void run(){  
			while(true){
				if(sel%2 == 0){
					sel++; // ¦���� sel �� ���ϱ� 
				}else {
					sel--; // Ȧ���� sel �� ���� 
				} // �̰� �Դٰ����ϸ鼭 ���� �� �̹���, ���� ���� �̹��� �Դٰ����Ѵ�. 
				repaint(); 
				try{ 
					Thread.sleep(100); // cpu�� ��� ���·� 
					// �ʹ� ���� ���ڰ� ������ �����Ƿ� 
					// �⺻ 1/1000��
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}

		//KeyListener Overide
		public void keyPressed(KeyEvent e){
		
				

				if(e.getKeyCode() == KeyEvent.VK_UP){
					y1 -= 10;
					y2 -= 10;
					sel = 5;
					if(y1 == 0 && y2 == 0){
						sel = 7; // �Ʒ��� ���ϰ� �ٲ�
						
					}
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					y1 += 10;
					y2 += 10;
					sel = 7;
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					x1 -= 10;
					x2 -= 10;
					sel = 1;
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					x1 += 10;
					x2 += 10;
					sel = 2;
				}
				repaint();
		
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}

	public static void main(String[] args) {
		PacMan pm = new PacMan();
	}

}