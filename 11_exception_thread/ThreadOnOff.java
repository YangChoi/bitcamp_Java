import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;



class ThreadOnOff extends JFrame implements Runnable{
	private JButton btn;
	private boolean bb = true;
	private static int ii = 0; // static : ���� �ʱ�ȭ �����ʰڴ� 

	public ThreadOnOff(){
		btn = new JButton("������");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);

		add("South", p);
		setSize(300, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// �̺�Ʈ 
		btn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				// ���콺�� ������ ��� 
				bb = true; 
				// ������ ���� �� ����
				new Thread(ThreadOnOff.this).start(); // this : �͸� �̳� Ŭ����  
				// Ŭ���� ������ ���� ������� �����Ѵ�
				

			}

			@Override
			public void mouseReleased(MouseEvent e){
				// ���콺�� ������ ��� 
				bb = false; 
			}
		});
		
	} // ThreadOnOff
	
	// ������ run
	@Override
	public void run(){
	
		int i = ii; // i�� ii������ ����(0���� ����)
		//if(ii == 50) ii = 0; // ii�� 100�� �Ǹ� �ٽ� ó������ ���� 
		
	
		while(true){
			i++; 
			if(!bb) break; // ������ ������ ������ 
			
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
