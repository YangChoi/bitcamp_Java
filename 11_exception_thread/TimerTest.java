import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerTest extends JFrame implements Runnable{
	private JButton startBtn, stopBtn;
	private static int count = 0; // 1부터 50까지 
	private boolean bb = true;

	public TimerTest(){
		
		// 카운트 패널
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// 버튼 패널 
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		// 카운트 라벨 
		JLabel lb = new JLabel("0");
		lb.setFont(new Font("Serif", Font.BOLD, 25));

		startBtn = new JButton("시작");
		stopBtn = new JButton("멈춤");
		
		p.add(lb);
		p2.add(startBtn);
		p2.add(stopBtn);

		add("Center", p);
		add("South", p2);
		
		

		setBounds(500, 500, 300, 200);
		setVisible(true);




		// 이벤트 
		// 시작 버튼 누를 시 
		startBtn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				bb = true; 
				// 스레드 생성 및 시작
				new Thread(TimerTest.this).start(); // this : 익명 이너 클래스  
				// 클래스 파일을 직접 스레드로 지정한다
			}
		});
		
		// 멈춤 버튼 누를시 
		stopBtn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				bb = false; /

		});
		
		lb.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				// count값을 어떻게 label에 올리지? 
				
 			}
			
		});
	}

	@Override
	public void run(){
		int i = count; // i 초기화 

		while(true){
			i++;
			if(!bb) break;

			try{
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			count = i;
			if(i >= 50) i = 0;
		}
	}
	public static void main(String[] args) {
		new TimerTest();
	}
}
