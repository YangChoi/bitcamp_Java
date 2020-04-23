import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PacMan extends Frame implements Runnable, KeyListener{
		// 팩맨 방향, 좌표
		private	int	sel = 2;
		int x1 = 225;
		int y1 = 225;

		int x2 = 275;
		int y2 = 275; 
		
		// 팩맨 음식
		int[] numX = new int[5];
		int[] numY = new int[5];
		
		// 팩맨 전진 
		private int go;
			
		
	
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = Toolkit.getDefaultToolkit().getImage("pacman.png");
		Image foodImg = Toolkit.getDefaultToolkit().getImage("foodImg.png");

	public PacMan(){

		// 팩맨 음식
		for(int i = 0; i < numX.length; i++){
			numX[i] = (int)(Math.random()*(400-0+1))+0;
			numY[i] = (int)(Math.random()*(400-30+1))+0;
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

		// 스레드 생성 
		Thread t = new Thread(this); // 나 자신을 스레드로 만들고 싶다 : this
		// 스레드 시작 
		t.start(); // 스레드 실행(run())

		//키보드 이벤트 처리 
		this.addKeyListener(this);

	}// PacMan() 
		
		// 팩맨 그림 정중앙 정렬
		@Override
		public void paint(Graphics g){
			g.drawImage(img, x1, y1, x2, y2, // 화면위치  
						sel*50, 0, sel*50+50, 50,// 이미지 위치 
						this);
			// 팩맨의 입을 왔다갔다 하려면 스레드를 사용해야한다. 
			
			// 팩맨 음식 
			for(int i =0; i <= numX.length; i++){
				g.drawImage(foodImg, numX[i], numY[i], this);
			}
		}
		
		// 먹이를 적용시키려면 paint 메소드 안으로 들어가야하는데, 그렇게 되면 스레드 적용되어서 반짝반짝 됨 

		@Override
		public void run(){  
			while(true){
				if(sel%2 == 0){
					sel++; // 짝수면 sel 값 더하기 
				}else {
					sel--; // 홀수면 sel 값 빼기  
				} // 이걸 왔다갔다하면서 입을 연 이미지, 입을 닫은 이미지 왔다가다한다. 

				// 방향에 따른 자동 움직임
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

				// 벽에 터치
				if(x1 < 0 ){ // left로 가는 중 > right로 방향 전환 
					sel = 2;
					x1 += 10;
					x2 += 10;
				}else if(y1 < 0){ // up으로 가는 중 > down으로 방향 전환
					sel = 7;
					y1 += 10;
					y2 += 10;
				}else if(y1 >= 480){ // down으로 가는 중 > up으로 방향 전환
					sel = 5;
					y1 -= 10;
					y2 -= 10;
				}else if(x1 >= 490){ //right로 가는 중 > left로 방향 전환
					sel = 1;
					x1 -= 10;
					x2 -= 10;

				}

				repaint(); 
				try{ 
					Thread.sleep(100); // cpu를 대기 상태로 
					// 너무 빨라서 글자가 보이지 않으므로 
					// 기본 1/1000초
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