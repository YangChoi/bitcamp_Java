import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PacManAgain extends Frame implements KeyListener, Runnable{
		// 팩맨 방향, 좌표
		private Image img, foodImg;
		private	int	sel = 2;
		private int x = 225, y = 225; 
		private int mx, my;
		private int[] foodX, foodY;
		// 팩맨 음식
		int[] numX = new int[5];
		int[] numY = new int[5];	

	public PacManAgain(){
		img = Toolkit.getDefaultToolkit().getImage("pacman.png");
		foodImg = Toolkit.getDefaultToolkit().getImage("foodImg.png");
		
		// 음식 이미지 좌표값 
		foodX = new int[5];
		foodY = new int[5];
		for(int i = 0; i < foodX.length; i++){
			foodX[i] = (int)(Math.random()*461)+20; // 벽에 걸치지 않게 20~480
			foodY[i] = (int)(Math.random()*461)+20;
		}

		setBounds(700, 200, 500, 500);
		setVisible(true);
		setResizable(false);

		// 창 닫기 
		this.addWindowListener(new WindowAdapter(){
			@Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});

		//키보드 이벤트 처리 
		this.addKeyListener(this);

		// 스레드 생성 
		Thread t = new Thread(this); // 나 자신을 스레드로 만들고 싶다 : this
		// 스레드 시작 
		t.start(); // 스레드 실행(run())

	}// PacMan() 


		
		// 팩맨 그림 정중앙 정렬
		@Override
		public void paint(Graphics g){
			// 팩맨 먹이 
			for(int i = 0; i < foodX.length; i++){
				g.drawImage(foodImg, foodX[i], foodY[i], this);
			}
	

			// 펙맨
			g.drawImage(img, x, y, x+50, y+50, // 화면위치  
						sel*50, 0, sel*50+50, 50,// 이미지 위치 
						this);

			
		}
		
		
		// if(x+25 >= 200 && y + 25 >= 150 && x+25 <= 220 && y + 25 <=170)
		// if(x+25 >= 80 && y + 25 >= 300 && x+25 <= 100 && y + 25 <= 320)
		// 먹이를 적용시키려면 paint 메소드 안으로 들어가야하는데, 그렇게 되면 스레드 적용되어서 반짝반짝 됨 

		@Override
		public void run(){  
			while(true){
				if(sel%2 == 0){
					sel++; // 짝수면 sel 값 더하기 
				}else {
					sel--; // 홀수면 sel 값 빼기  
				} // 이걸 왔다갔다하면서 입을 연 이미지, 입을 닫은 이미지 왔다가다한다. 
				
				// 스스로 계속 움직인다. 
				x += mx;
				y += my;
				// 벽에 부딪힐 때 
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
					Thread.sleep(100); // cpu를 대기 상태로 
					// 너무 빨라서 글자가 보이지 않으므로 
					// 기본 1/1000초
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				// 식사 
				for(int i = 0; i < foodX.length; i++){
					if(x+25 >= foodX[i]-5 && y + 25 >= foodY[i]-5 && x+25 <= foodX[i]+20+5 && y + 25 <= foodY[i] + 20+5){
						foodX[i] = foodY[i] = -10; // 먹은 음식은 프레임 밖으로 
					}
				}
			}
		}

		//KeyListener Overide
		public void keyPressed(KeyEvent e){
				// 여기에다 전진 입력하면 키보드를 누르지 않으면 전진을 하지 않아서 안된다. 
				// 우리는 자동으로 전진하는걸 원함 
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
					sel = 0; //( sel * 50되면 left 이미지의 좌표값이 만들어진다)
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