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
	private static int count = 0; // 1���� 50���� 
	private boolean bb = true;

	public TimerTest(){
		
		// ī��Ʈ �г�
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// ��ư �г� 
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		// ī��Ʈ �� 
		JLabel lb = new JLabel("0");
		lb.setFont(new Font("Serif", Font.BOLD, 25));

		startBtn = new JButton("����");
		stopBtn = new JButton("����");
		
		p.add(lb);
		p2.add(startBtn);
		p2.add(stopBtn);

		add("Center", p);
		add("South", p2);
		
		

		setBounds(500, 500, 300, 200);
		setVisible(true);




		// �̺�Ʈ 
		// ���� ��ư ���� �� 
		startBtn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				bb = true; 
				// ������ ���� �� ����
				new Thread(TimerTest.this).start(); // this : �͸� �̳� Ŭ����  
				// Ŭ���� ������ ���� ������� �����Ѵ�
			}
		});
		
		// ���� ��ư ������ 
		stopBtn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				bb = false; /

		});
		
		lb.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				// count���� ��� label�� �ø���? 
				
 			}
			
		});
	}

	@Override
	public void run(){
		int i = count; // i �ʱ�ȭ 

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
