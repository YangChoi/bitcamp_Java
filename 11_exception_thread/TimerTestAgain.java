import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// 멈춤눌러도 다시 0으로 안되는 경우 만들어볼 것 (응용..)

class TimerTestAgain extends JFrame implements ActionListener, Runnable{
	private JLabel label; 
	private JButton startBtn, stopBtn;
	private boolean bb = true;

	TimerTestAgain(){
		setLayout(null);
		
		label = new JLabel("0");
		label.setFont(new Font("Serif", Font.BOLD, 70));
		startBtn = new JButton("시작");
		stopBtn = new JButton("멈춤");
		
		label.setBounds(70, 30, 100, 100);
		startBtn.setBounds(200, 40, 60, 30);
		stopBtn.setBounds(200, 80, 60, 30);
		
		add(label);
		add(startBtn);
		add(stopBtn);

		setBounds(500, 500, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		// 이벤트 
		
			

	}// TimerTestAgain

	@Override 
	public void actionPerformed(ActionEvent e){
		// 스레드 생성 
		Thread t;
		if(e.getSource() == startBtn){
			t = new Thread(this); // 스레드가 되고자 하는 것은 TimerTestAgain이므로 this
			// 스레드 시작 
			t.start();

			bb = true;
			// 시작을 누르면 숫자가 움직이라는 것이므로 true
			startBtn.setEnabled(false);
			// 시작으로 움직이면 start버튼 비활성화
			stopBtn.setEnabled(true);
			// 멈춤은 활성화 
		}else if(e.getSource() == stopBtn){
			t = null; // 스레드를 없앤다 
			// stop시 스레드 없애기 
			bb = false;
			// 멈춤을 누르면 bb가 false
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
			
 	}
	// 무조건 run()에만 스레드를 생성하고 실행하는 줄 알았다. 

	@Override
	public void run(){
		for(int i = 1; i <= 20; i++){ 
			label.setText(new Integer(i).toString()); // label에 i값 올려준다. 
			// toString 안된다. int에는 toString 붙을 수 없다. Integer이면 가능 
			if(!bb) break; // 중간에 빠져나갈 수 있게 
			
			try{
				Thread.sleep(100); // 스레드 속도 늦춘다. 
			}catch(InterruptedException e){
				e.printStackTrace();
			}

		}// for
		
		// 다시 시작할 수 있도록 start 활성화 
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
	
	}


	public static void main(String[] args) {
		new TimerTestAgain();
	}
}
