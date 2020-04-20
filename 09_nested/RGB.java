import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RGB extends Frame {
	private Button redBtn, greenBtn, blueBtn; 
	private DrCanvas canvas; 

	/*
	Panel - Component를 묶어주느 panel 
	TextArea
	Canvas - null
		   - 반드시 상속 받아서 써야한다 
	*/
	public RGB(){
		redBtn = new Button("빨강");
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		
		canvas = new DrCanvas(); // 캔버스 생성 

		Panel p = new Panel(); // 버튼 묶어줄 panel (Component를 묶어주는 Panel) - FlowLayout:가운데 정렬 
		p.add(redBtn); //button에 new 해주지 않을 때 : 컴파일시엔 문제없지만 실행시 nullpointException 걸린다. : new해줘라 
		p.add(greenBtn);
		p.add(blueBtn);

		add("North", p); // 패널 붙이기 
		add("Center", canvas); // 캔버스 붙이기 

		setBounds(700,100,300,400);
		setVisible(true);
	

		// 이벤트 발생 
		// windowListener implements 대신에 WindowAdapter를 불러온다 
		this.addWindowListener(new WindowAdapter(){
			//Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}); // windowAdapter는 추상 클래스이면서 추상메소드가 없다. 따라서 원하는 것을 골라서 구현한다. 
		// 익명 붙인다 : {} 
		
		//ActionListener (대신할 메소드 없으면 interface 직접 new 한다. 일회성)
		redBtn.addActionListener(new ActionListener(){
			// Override
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.RED); // 캔버스를 빨강으로  
			}
		});
		greenBtn.addActionListener(new ActionListener(){
			// Override
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.GREEN); // 캔버스를 빨강으로  
			}
		});
		blueBtn.addActionListener(new ActionListener(){
			// Override
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.BLUE); // 캔버스를 빨강으로  
			}
		});
	
} // RGB()

	class DrCanvas extends Canvas{
		public DrCanvas(){
			this.setBackground(new Color(200, 191, 231));
		}
	}

	public static void main(String[] args) {
		new RGB();
	}
}
