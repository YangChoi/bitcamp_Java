import java.awt.Panel;
import java.awt.Frame;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;

class Calculator extends Frame {
	private Label dispL, inputL; // 식이 보이는 라벨, 결과 라벨 
	private Button[] button; // 버튼 18개 
	
public void init(){
	String[] input = {"←", "C", 
					"7", "8", "9", "/",
					"4", "5", "6", "*",
					"1", "2", "3", "-",
					".", "0", "=", "+"}; // 버튼 text 값 배열로 저장 
	
	// 버튼 생성 
	Button[] button = new Button[input.length];
	

		
		// 프레임 만들기
		Frame f = new Frame();
		//프레임 셋팅
		f.setTitle("미니 계산기");
		f.setBounds(900, 200, 300, 400); // x, y좌표 추가
		f.setVisible(true);
	
		
		// 두 입출력 라벨
		// dispL
		Label label = new Label();
		label.setText(" "); // 라벨의 텍스트값
		label.setAlignment(Label.RIGHT); // 정렬
		label.setBackground(Color.cyan); //Label 객체의 배경색을 설정
		add(label);

		// inputL
		Label label2 = new Label();
		label2.setText("0");
		label2.setAlignment(Label.RIGHT); // 정렬
		label2.setBackground(Color.cyan);//Label 객체의 배경색을 설정
		add(label2);
		

		// 패널 만들어 각 줄 정렬 (7개의 panel과 전체 panel 한개 )
		Panel p = new Panel(); // 전체패널 
		p.setLayout(null);	

		
		// 계산 내용 패널 
		Panel p1 = new Panel(); // 첫번째
		p1.setLayout(new GridLayout(1, 1, 5, 0)); 
		p1.add(dispL);
		
		// 계산 결과 패널
		Panel p2 = new Panel(); // 두번째
		p2.setLayout(new GridLayout(1, 0, 5, 0)); 
		p2.add(inputL);

		// 뒤로, c 패널
		Panel p3 = new Panel(); // 세번째 
		p3.setLayout(new GridLayout(1, 2, 5, 10)); 
		p3.add(button[0]);
		p3.add(button[1]);
		add("Center", p3);

		Panel p4 = new Panel(); // 네번째 
		p4.setLayout(new GridLayout(1, 4, 5, 10));
		p4.add(button[2]);
		p4.add(button[3]);
		p4.add(button[4]);
		p4.add(button[5]);
		add("South", p4);

		Panel p5 = new Panel(); // 다섯번째 
		p5.setLayout(new GridLayout(1, 4, 5, 10)); 
		p5.add(button[6]);
		p5.add(button[7]);
		p5.add(button[8]);
		p5.add(button[9]);
		add("South", p5);

		Panel p6 = new Panel(); // 여섯번째 
		p6.setLayout(new GridLayout(1, 4, 5, 10));
		p6.add(button[10]);
		p6.add(button[11]);
		p6.add(button[12]);
		p6.add(button[13]);
		add("South", p6);


		Panel p7 = new Panel(); // 일곱번째 
		p7.setLayout(new GridLayout(1, 4, 5, 10));
		p7.add(button[14]);
		p7.add(button[15]);
		p7.add(button[16]);
		p7.add(button[17]);
		add("South", p7);
		
		// p에 모든 패널 추가
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p7);
		
		f.add(p); // frame에 p 추가 
			
		setVisible(true);
	}


	public static void main(String[] args) {
		Calculator c = new Calculator(); 
		c.init();
	}
}
