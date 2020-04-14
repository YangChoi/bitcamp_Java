
import java.awt.Panel;
import java.awt.Frame;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Color;


class Calculator extends Frame {
	private Label dispL, inputL; // 식이 보이는 라벨, 결과 라벨 
	private Button[] button; // 버튼 18개 
	
	public Calculator(){
	// 버튼 
	Button[] btn = new Button[18];
	
	String[] str = new String[]{"←", "C", 
					"7", "8", "9", "/",
					"4", "5", "6", "*",
					"1", "2", "3", "-",
					".", "0", "=", "+"}; // 버튼 text 값 배열로 저장 
	
		// 버튼 생성 
		for(int i = 0; i < 18; i++){
			btn[i] = new Button(); 
		}

		for(int i = 0; i < str.length; i ++){
			btn[i] = new Button(str[i]);
		}
		

		
		// 화면 셋팅 
		setTitle("미니 계산기");
		setBounds(900, 200, 300, 400); // x, y좌표 추가
		
		
		// 두 입출력 라벨
		// dispL
		dispL = new Label("계산식");
		dispL.setBackground(Color.PINK); //Label 객체의 배경색을 설정
	

		// inputL
		inputL = new Label("결과값");
		inputL.setBackground(Color.PINK);//Label 객체의 배경색을 설정
		
		

		// 패널 만들어 각 줄 정렬 (7개의 panel과 전체 panel 한개 )
	
		
		
		// 계산 내용 패널 
		Panel p1 = new Panel(); // 첫번째
		p1.setLayout(new GridLayout(1, 1, 5, 5)); 
		p1.add(dispL);
		
		// 계산 결과 패널
		Panel p2 = new Panel(); // 두번째
		p2.setLayout(new GridLayout(1, 0, 5, 5)); 
		p2.add(inputL);

		// 뒤로, c 패널
		Panel p3 = new Panel(); // 세번째 
		p3.setLayout(new GridLayout(1, 2, 5, 5)); 
		p3.add(btn[0]);
		p3.add(btn[1]);
		//p3.add("Center", p3);

		Panel p4 = new Panel(); // 네번째 
		p4.setLayout(new GridLayout(1, 4, 5, 5));
		p4.add(btn[2]);
		p4.add(btn[3]);
		p4.add(btn[4]);
		p4.add(btn[5]);
		//p4.add("South", p4);

		Panel p5 = new Panel(); // 다섯번째 
		p5.setLayout(new GridLayout(1, 4, 5, 5)); 
		p5.add(btn[6]);
		p5.add(btn[7]);
		p5.add(btn[8]);
		p5.add(btn[9]);
		//p5.add("South", p5);

		Panel p6 = new Panel(); // 여섯번째 
		p6.setLayout(new GridLayout(1, 4, 5, 5));
		p6.add(btn[10]);
		p6.add(btn[11]);
		p6.add(btn[12]);
		p6.add(btn[13]);
		//p6.add("South", p6);


		Panel p7 = new Panel(); // 일곱번째 
		p7.setLayout(new GridLayout(1, 4, 5, 5));
		p7.add(btn[14]);
		p7.add(btn[15]);
		p7.add(btn[16]);
		p7.add(btn[17]);
		//p7.add("South", p7);
		
		// p에 모든 패널 추가
		Panel p = new Panel(); // 전체패널 
		p.setLayout(new GridLayout(7, 4, 2, 5)); 
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p7);
		
		add("Center", p); // frame에 p 추가 
		setVisible(true);	
	
			
	}

	public static void main(String[] args) {
		Calculator c = new Calculator(); 
		
	}
}
