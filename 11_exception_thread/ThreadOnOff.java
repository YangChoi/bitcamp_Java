import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;



class ThreadOnOff extends JFrame implements Runnable{
	private JButton btn;
	private boolean bb = true;
	private static int ii = 0; // static : 값을 초기화 하지않겠다 

	public ThreadOnOff(){
		btn = new JButton("누르기");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);

		add("South", p);
		setSize(300, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트 
		btn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				// 마우스를 눌렀을 경우 
				bb = true; 
				// 스레드 생성 및 시작
				new Thread(ThreadOnOff.this).start(); // this : 익명 이너 클래스  
				// 클래스 파일을 직접 스레드로 지정한다
				

			}

			@Override
			public void mouseReleased(MouseEvent e){
				// 마우스를 놓았을 경우 
				bb = false; 
			}
		});
		
	} // ThreadOnOff
	
	// 스레드 run
	@Override
	public void run(){
	
		int i = ii; // i는 ii값부터 시작(0부터 시작)
		//if(ii == 50) ii = 0; // ii가 100이 되면 다시 처음부터 시작 
		
	
		while(true){
			i++; 
			if(!bb) break; // 조건이 맞으면 나간다 
			
			try{
			Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("i = "+ i);
			ii = i;
			if(i >= 50) i = 0;
			
		}// while()
	}

	public static void main(String[] args) {
		new ThreadOnOff();
	}
}
