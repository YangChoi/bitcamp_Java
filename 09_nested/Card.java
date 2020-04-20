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
		
		// panel 7개를 배열로 생성하시오 
		Panel[] p = new Panel[7];
		Color[] color = {new Color(255, 0, 0), 
						new Color(223, 108, 15), 
						new Color(255, 255, 0),
						new Color(0, 255, 0),
						new Color(0, 0, 255),
						new Color(23, 2, 173),
						new Color(255, 0, 255)};

		String[] title = {"빨강", "주황", "노랑", "초록", "파랑", "남", "보라"}; // 색깔 배열에 이름 부여 
	
		for(int i = 0; i < p.length; i++){
			p[i] = new Panel(); // 생성 
			p[i].setBackground(color[i]); // 패널에 색깔 부여 
			
			frame.add(p[i], title[i]); // 패널, 이름 넣기 
			
			// 이벤트 (MouseListener)
			p[i].addMouseListener(new MouseAdapter(){
				// 추상메소드가 없음 
				public void mouseClicked(MouseEvent e){
					//card.show(frame, "파랑");
					card.next(frame); // 하나하나 패스할 수 있도록 
				}
			});
		
		}// for


		frame.setBounds(700,100,200,200);
		frame.setVisible(true);


		// 이벤트 발생 
		// windowListener implements 대신에 WindowAdapter를 불러온다 
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
Layout 배치 
1. BorderLayout - 동서남북, Frame, JFrame
2. FlowLayout - 순서대로 배치(중앙을 중심으로), Panel
3. GridLayout - 행, 열배치 
4. CardLayout - 

*/