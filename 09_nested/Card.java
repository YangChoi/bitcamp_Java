import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.CardLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



class Card {
	private Frame frame;
	private CardLayout card; 

	public void init(){
		frame = new Frame();
		card = new CardLayout();
		frame.setLayout(card);
		
		// panel 7���� �迭�� �����Ͻÿ� 
		Panel[] p = new Panel[7];
		Color[] color = {new Color(255, 0, 0), 
						new Color(223, 108, 15), 
						new Color(255, 255, 0),
						new Color(0, 255, 0),
						new Color(0, 0, 255),
						new Color(23, 2, 173),
						new Color(255, 0, 255)};

		String[] title = {"����", "��Ȳ", "���", "�ʷ�", "�Ķ�", "��", "����"}; // ���� �迭�� �̸� �ο� 
	
		for(int i = 0; i < p.length; i++){
			p[i] = new Panel(); // ���� 
			p[i].setBackground(color[i]); // �гο� ���� �ο� 
			
			frame.add(p[i], title[i]); // �г�, �̸� �ֱ� 
			
			// �̺�Ʈ (MouseListener)
			p[i].addMouseListener(new MouseAdapter(){
				// �߻�޼ҵ尡 ���� 
				public void mouseClicked(MouseEvent e){
					//card.show(frame, "�Ķ�");
					card.next(frame); // �ϳ��ϳ� �н��� �� �ֵ��� 
				}
			});
		
		}// for


		frame.setBounds(700,100,200,200);
		frame.setVisible(true);


		// �̺�Ʈ �߻� 
		// windowListener implements ��ſ� WindowAdapter�� �ҷ��´� 
		frame.addWindowListener(new WindowAdapter(){
			//Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});

}
	public static void main(String[] args) {
		new Card().init();
	}
}

/*
Layout ��ġ 
1. BorderLayout - ��������, Frame, JFrame
2. FlowLayout - ������� ��ġ(�߾��� �߽�����), Panel
3. GridLayout - ��, ����ġ 
4. CardLayout - 

*/