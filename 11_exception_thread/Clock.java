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
	// Clock�� �����尡 �ƴ� Frame�̴�
	public Clock(){
		
		setForeground(Color.RED);
		setFont(new Font("Consolas", Font.BOLD, 25));
		setBounds(700, 200, 300, 200);
		setVisible(true);
		
		// â �ݱ� 
		this.addWindowListener(new WindowAdapter(){
			@Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});
		// ������ ���� 
		Thread t = new Thread(this); // �����尡 �ǰ� ���� ���� ��(this)
		// ������ ���� 
		t.start(); 

	} // Clock()

	@Override
	public void run(){ // �ڹ� ��ü������ ���� �޼ҵ�Ƿ� throws ����ó�� �Ұ� 
		while(true){ // 0.1�� �������� RUN�ߴ� ���������ٸ� �ݺ�
			repaint();
			try{ 
				Thread.sleep(1000); // cpu�� ��� ���·� 
				// �ʹ� ���� ���ڰ� ������ �����Ƿ� 
				// �⺻ 1/1000��
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}// while
	}

	// ��¥ ǥ���ϱ� 
	@Override
	public void paint(Graphics g){
		SimpleDateFormat sdf = new SimpleDateFormat("HH : mm : ss");
		// ����ð� 
		g.drawString(sdf.format(new Date()).toString(), 60, 120); 
		// drawString�� ���ڿ��� �׷��� 
		//date�� string�� �ƴϹǷ� toString()���� ���ڿ� ���� 
		// 50, 100 �� �׷����
		// ���� Ŭ���� ���� ���� 
		// sdf �����ϸ� toString ��� �ȴ�. 
		// SimpledateFormat�� ���ڿ��� �����͸� �̾ƿ��� ���� 

	}

	


	public static void main(String[] args){
		new Clock(); // �������� �����Ѱ�, �����带 ������ ���� �ƴ� 
	}
}
