import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PacManAgain extends Frame implements KeyListener, Runnable{
		// �Ѹ� ����, ��ǥ
		private Image img, foodImg;
		private	int	sel = 2;
		private int x = 225, y = 225; 
		private int mx, my;
		private int[] foodX, foodY;
		// �Ѹ� ����
		int[] numX = new int[5];
		int[] numY = new int[5];	

	public PacManAgain(){
		img = Toolkit.getDefaultToolkit().getImage("pacman.png");
		foodImg = Toolkit.getDefaultToolkit().getImage("foodImg.png");
		
		// ���� �̹��� ��ǥ�� 
		foodX = new int[5];
		foodY = new int[5];
		for(int i = 0; i < foodX.length; i++){
			foodX[i] = (int)(Math.random()*461)+20; // ���� ��ġ�� �ʰ� 20~480
			foodY[i] = (int)(Math.random()*461)+20;
		}

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

		//Ű���� �̺�Ʈ ó�� 
		this.addKeyListener(this);

		// ������ ���� 
		Thread t = new Thread(this); // �� �ڽ��� ������� ����� �ʹ� : this
		// ������ ���� 
		t.start(); // ������ ����(run())

	}// PacMan() 


		
		// �Ѹ� �׸� ���߾� ����
		@Override
		public void paint(Graphics g){
			// �Ѹ� ���� 
			for(int i = 0; i < foodX.length; i++){
				g.drawImage(foodImg, foodX[i], foodY[i], this);
			}
	

			// ���
			g.drawImage(img, x, y, x+50, y+50, // ȭ����ġ  
						sel*50, 0, sel*50+50, 50,// �̹��� ��ġ 
						this);

			
		}
		
		
		// if(x+25 >= 200 && y + 25 >= 150 && x+25 <= 220 && y + 25 <=170)
		// if(x+25 >= 80 && y + 25 >= 300 && x+25 <= 100 && y + 25 <= 320)
		// ���̸� �����Ű���� paint �޼ҵ� ������ �����ϴµ�, �׷��� �Ǹ� ������ ����Ǿ ��¦��¦ �� 

		@Override
		public void run(){  
			while(true){
				if(sel%2 == 0){
					sel++; // ¦���� sel �� ���ϱ� 
				}else {
					sel--; // Ȧ���� sel �� ����  
				} // �̰� �Դٰ����ϸ鼭 ���� �� �̹���, ���� ���� �̹��� �Դٰ����Ѵ�. 
				
				// ������ ��� �����δ�. 
				x += mx;
				y += my;
				// ���� �ε��� �� 
				if( x > 500) {
					x = 0; 
				}else if(x < 0){
					x = 500; 
				}else if(y > 500){
					 y = 0;
				}else if(y < 0){
					y = 500;
				}
				repaint();
				


				try{ 
					Thread.sleep(100); // cpu�� ��� ���·� 
					// �ʹ� ���� ���ڰ� ������ �����Ƿ� 
					// �⺻ 1/1000��
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				// �Ļ� 
				for(int i = 0; i < foodX.length; i++){
					if(x+25 >= foodX[i]-5 && y + 25 >= foodY[i]-5 && x+25 <= foodX[i]+20+5 && y + 25 <= foodY[i] + 20+5){
						foodX[i] = foodY[i] = -10; // ���� ������ ������ ������ 
					}
				}
			}
		}

		//KeyListener Overide
		public void keyPressed(KeyEvent e){
				// ���⿡�� ���� �Է��ϸ� Ű���带 ������ ������ ������ ���� �ʾƼ� �ȵȴ�. 
				// �츮�� �ڵ����� �����ϴ°� ���� 
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}else if(e.getKeyCode() == KeyEvent.VK_UP){
					sel = 4;
					mx = 0;
					my = -10;
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					sel = 6;
					mx = 0; 
					my = 10;
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					sel = 0; //( sel * 50�Ǹ� left �̹����� ��ǥ���� ���������)
					mx = -10; 
					my = 0; 
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					sel = 2;
					mx = 10; 
					my = 0; 
					
					
				}
				repaint();
		
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}

	public static void main(String[] args) {
		new PacManAgain();
	}

}