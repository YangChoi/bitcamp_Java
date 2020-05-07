import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// ���㴭���� �ٽ� 0���� �ȵǴ� ��� ���� �� (����..)

class TimerTestAgain extends JFrame implements ActionListener, Runnable{
	private JLabel label; 
	private JButton startBtn, stopBtn;
	private boolean bb = true;

	TimerTestAgain(){
		setLayout(null);
		
		label = new JLabel("0");
		label.setFont(new Font("Serif", Font.BOLD, 70));
		startBtn = new JButton("����");
		stopBtn = new JButton("����");
		
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
		// �̺�Ʈ 
		
			

	}// TimerTestAgain

	@Override 
	public void actionPerformed(ActionEvent e){
		// ������ ���� 
		Thread t;
		if(e.getSource() == startBtn){
			t = new Thread(this); // �����尡 �ǰ��� �ϴ� ���� TimerTestAgain�̹Ƿ� this
			// ������ ���� 
			t.start();

			bb = true;
			// ������ ������ ���ڰ� �����̶�� ���̹Ƿ� true
			startBtn.setEnabled(false);
			// �������� �����̸� start��ư ��Ȱ��ȭ
			stopBtn.setEnabled(true);
			// ������ Ȱ��ȭ 
		}else if(e.getSource() == stopBtn){
			t = null; // �����带 ���ش� 
			// stop�� ������ ���ֱ� 
			bb = false;
			// ������ ������ bb�� false
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
			
 	}
	// ������ run()���� �����带 �����ϰ� �����ϴ� �� �˾Ҵ�. 

	@Override
	public void run(){
		for(int i = 1; i <= 20; i++){ 
			label.setText(new Integer(i).toString()); // label�� i�� �÷��ش�. 
			// toString �ȵȴ�. int���� toString ���� �� ����. Integer�̸� ���� 
			if(!bb) break; // �߰��� �������� �� �ְ� 
			
			try{
				Thread.sleep(100); // ������ �ӵ� �����. 
			}catch(InterruptedException e){
				e.printStackTrace();
			}

		}// for
		
		// �ٽ� ������ �� �ֵ��� start Ȱ��ȭ 
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
	
	}


	public static void main(String[] args) {
		new TimerTestAgain();
	}
}
