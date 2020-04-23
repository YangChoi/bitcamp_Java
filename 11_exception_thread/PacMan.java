import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PacMan extends Frame implements Runnable, KeyListener{
		// �Ѹ� ����, ��ǥ
		private	int	sel = 2;
		int x1 = 225;
		int y1 = 225;

		int x2 = 275;
		int y2 = 275; 
		
		// �Ѹ� ����
		int[] numX = new int[5];
		int[] numY = new int[5];
		
		// �Ѹ� ���� 
		private int go;
			
		
	
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = Toolkit.getDefaultToolkit().getImage("pacman.png");
		Image foodImg = Toolkit.getDefaultToolkit().getImage("foodImg.png");

	public PacMan(){

		// �Ѹ� ����
		for(int i = 0; i < numX.length; i++){
			numX[i] = (int)(Math.random()*(400-0+1))+0;
			numY[i] = (int)(Math.random()*(400-30+1))+0;
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
			
			// �Ѹ� ���� 
			for(int i =0; i <= numX.length; i++){
				g.drawImage(foodImg, numX[i], numY[i], this);
			}
		}
		
		// ���̸� �����Ű���� paint �޼ҵ� ������ �����ϴµ�, �׷��� �Ǹ� ������ ����Ǿ ��¦��¦ �� 

		@Override
		public void run(){  
			while(true){
				if(sel%2 == 0){
					sel++; // ¦���� sel �� ���ϱ� 
				}else {
					sel--; // Ȧ���� sel �� ����  
				} // �̰� �Դٰ����ϸ鼭 ���� �� �̹���, ���� ���� �̹��� �Դٰ����Ѵ�. 

				// ���⿡ ���� �ڵ� ������
				if(sel == 2){ // right
					x1 += 10;
					x2 += 10;
				}else if(sel == 1){ // left
					x1 -= 10;
					x2 -= 10;
				}else if(sel == 5){ // up
					y1 -= 10;
					y2 -= 10;
				}else if(sel == 7){ // down 
					y1 += 10;
					y2 += 10;
				}

				// ���� ��ġ
				if(x1 < 0 ){ // left�� ���� �� > right�� ���� ��ȯ 
					sel = 2;
					x1 += 10;
					x2 += 10;
				}else if(y1 < 0){ // up���� ���� �� > down���� ���� ��ȯ
					sel = 7;
					y1 += 10;
					y2 += 10;
				}else if(y1 >= 480){ // down���� ���� �� > up���� ���� ��ȯ
					sel = 5;
					y1 -= 10;
					y2 -= 10;
				}else if(x1 >= 490){ //right�� ���� �� > left�� ���� ��ȯ
					sel = 1;
					x1 -= 10;
					x2 -= 10;

				}

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