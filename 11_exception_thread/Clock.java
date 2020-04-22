import java.awt.Frame;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics;

import java.text.SimpleDateFormat;
import java.util.Date;

class Clock extends Frame implements Runnable{
	// Clock은 스레드가 아닌 Frame이다
	public Clock(){
		
		setForeground(Color.RED);
		setFont(new Font("Consolas", Font.BOLD, 25));
		setBounds(700, 200, 300, 200);
		setVisible(true);
		
		// 창 닫기 
		this.addWindowListener(new WindowAdapter(){
			@Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});
		// 스레드 생성 
		Thread t = new Thread(this); // 스레드가 되고 싶은 것은 나(this)
		// 스레드 시작 
		t.start(); 

	} // Clock()

	@Override
	public void run(){ // 자바 자체적으로 만든 메소드므로 throws 예외처리 불가 
		while(true){ // 0.1초 간격으로 RUN했다 빠져나갔다를 반복
			repaint();
			try{ 
				Thread.sleep(1000); // cpu를 대기 상태로 
				// 너무 빨라서 글자가 보이지 않으므로 
				// 기본 1/1000초
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}// while
	}

	// 날짜 표시하기 
	@Override
	public void paint(Graphics g){
		SimpleDateFormat sdf = new SimpleDateFormat("HH : mm : ss");
		// 현재시간 
		g.drawString(sdf.format(new Date()).toString(), 60, 120); 
		// drawString은 문자열을 그려줌 
		//date는 string이 아니므로 toString()으로 문자열 변경 
		// 50, 100 에 그려줘라
		// 현재 클래스 값을 찍어내고 
		// sdf 설정하면 toString 없어도 된다. 
		// SimpledateFormat이 문자열로 데이터를 뽑아오기 때문 

	}

	


	public static void main(String[] args){
		new Clock(); // 프레임을 생성한것, 스레드를 생성한 것이 아님 
	}
}
