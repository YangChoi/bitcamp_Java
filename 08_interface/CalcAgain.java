import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CalcAgain extends Frame implements ActionListener{
	private Label dispL, inputL; // 식이 보이는 라벨, 결과 라벨 
	private StringBuffer dispBuf, inputBuf; 
	private Button[] button; // 버튼 16개 
	private Button backBtn, clearBtn; // 위의 2개 
	
	public CalcAgain(){
	// 버튼 
	Button[] btn = new Button[16];

	
	String[] str = new String[]{"7", "8", "9", "/",
					"4", "5", "6", "*",
					"1", "2", "3", "-",
					".", "0", "=", "+"}; // 버튼 text 값 배열로 저장 
	
	
		
		// 버튼 생성 
		for(int i = 0; i < 16; i++){
			btn[i] = new Button(); 
		}
		
		for(int i = 0; i < str.length; i++){
			btn[i] = new Button(str[i]);
			btn[i].setFont(new Font("Serif", Font.BOLD, 25)); // 버튼 폰트 스타일 
		}
		
		backBtn = new Button("←");
		clearBtn = new Button("C");
		backBtn.setFont(new Font("Serif", Font.BOLD, 25));
		clearBtn.setFont(new Font("Serif", Font.BOLD, 25));

		// 화면 셋팅 
		setTitle("미니 계산기");
		setBounds(900, 200, 300, 400); // x, y좌표 추가
		setResizable(false);
		
		// 두 입출력 라벨
		// dispL
		dispL = new Label("", Label.RIGHT);
		dispL.setBackground(new Color(200, 191, 231)); // Label 객체의 배경색을 설정
		dispL.setFont(new Font("Serif", Font.BOLD, 25));
		

		// inputL
		inputL = new Label("0", Label.RIGHT); // 숫자 0 안됨. 컴퍼넌트는 다 문자열만 입력 가능 
		inputL.setBackground(new Color(200, 191, 231));//Label 객체의 배경색을 설정
		inputL.setFont(new Font("Serif", Font.BOLD, 25));

		// 패널 만들어 각 줄 정렬 (7개의 panel과 전체 panel 한개 )
	
		// setBounds(x y w h) 
		
		// 계산 내용 패널 
		Panel p1 = new Panel(); // 첫번째
		p1.setLayout(new GridLayout(1, 1, 5, 5)); 
		p1.add(dispL);
		dispBuf = new StringBuffer();
		
		// 계산 결과 패널
		Panel p2 = new Panel(); // 두번째
		p2.setLayout(new GridLayout(1, 0, 5, 5)); 
		p2.add(inputL);
		inputBuf = new StringBuffer("0");

		// 뒤로, c 패널
		Panel p3 = new Panel(); // 세번째 
		p3.setLayout(new GridLayout(1, 2, 5, 5)); 
		p3.add(backBtn);
		p3.add(clearBtn);
		//p3.add("Center", p3);

		Panel p4 = new Panel(); // 네번째 
		p4.setLayout(new GridLayout(1, 4, 5, 5));
		p4.add(btn[0]);
		p4.add(btn[1]);
		p4.add(btn[2]);
		p4.add(btn[3]);
		//p4.add("South", p4);

		Panel p5 = new Panel(); // 다섯번째 
		p5.setLayout(new GridLayout(1, 4, 5, 5)); 
		p5.add(btn[4]);
		p5.add(btn[5]);
		p5.add(btn[6]);
		p5.add(btn[7]);
		//p5.add("South", p5);

		Panel p6 = new Panel(); // 여섯번째 
		p6.setLayout(new GridLayout(1, 4, 5, 5));
		p6.add(btn[8]);
		p6.add(btn[9]);
		p6.add(btn[10]);
		p6.add(btn[11]);
		//p6.add("South", p6);


		Panel p7 = new Panel(); // 일곱번째 
		p7.setLayout(new GridLayout(1, 4, 5, 5));
		p7.add(btn[12]);
		p7.add(btn[13]);
		p7.add(btn[14]);
		p7.add(btn[15]);
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
		
		// 버튼 활성화 
		for(int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);
		}
		backBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		

		// 이벤트 발생 
		// windowListener implements 대신에 WindowAdapter를 불러온다 
		this.addWindowListener(new WindowAdapter(){
			//Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});
		
}
	
	// ActionListener Override
	public void actionPerformed(ActionEvent e) {
		String push = e.getActionCommand();
		if( push == "1" ||
			push == "2" ||
			push == "3" ||
			push == "4" ||
			push == "5" ||
			push == "6" ||
			push == "7" ||
			push == "8" ||
			push == "9" ||
			push == "0"){
			
			if(inputBuf.length() == 1 && inputBuf.toString().equals("0")){ // 0이 하나만 있을 때 0을 지우고 새로운 입력을 나타내야하므로 
				// 01 이런식으로 되면 안되고 1 이렇게 들어가야하니까. 
				inputBuf.delete(0,1);
				// 기본 설정 값 0을 지우고 들어간다. 
				// 0부터 1보다 작을 때까지 index 0번을 지워야하므로 (0,1)
				// 0은 지우고 또 넣고 지우고 또 넣는 형태가 되기 때문에 0은 2번은 안넣어진다. 
			}
			inputBuf.append(push); // 입력한 번호와 같은 것 추가 
			inputL.setText(inputBuf+""); // 덮어준다 	

		}else if(push == "←"){
			// 가장 먼저 입력한 것을 먼저 지워야한다. 
			//inputBuf.delete(2, 3);
			// 487 : 2번위치에서 3번 이전까지 지워진다. 
			inputBuf.delete(inputBuf.length()-1 ,inputBuf.length());
			// 라벨에게 알려줌 
			if(inputBuf.length() == 0){
				inputBuf.append("0"); // 아무것도 없을 때 0이 나오게 한다 
			}
			inputL.setText(inputBuf+"");

		}else if(push == "C"){
			dispBuf.delete(0, dispBuf.length()); // 갯수는 숫자로 나오기 때문에 (인덱스는 0부터지만)
			inputBuf.delete(0, inputBuf.length()); // 다 지워주기 All clear
			inputBuf.append("0"); // 버퍼에 0 넣고 시작 

			dispL.setText(""); //비워주고 
			inputL.setText("0"); // 기본값 0 넣기 
		}else if(push == "."){

			if(inputBuf.indexOf(".") == -1){
				// -1 : 점이 없다. 
				inputBuf.append(".");
			}
			inputL.setText(inputBuf + ""); //inputBuf의 내용을 보여주기 
			// 만약 .이 있다면 (-1) 이 아니면 if문을 나와서 바로 라벨에 보여준다. 
		}else if(push == "+"){
			if(inputBuf.length() == 0){
				// 아무것도 입력되지 않았다면	
				inputL.setText(inputBuf+""); // 아무것도 없음
			}else {
				dispBuf.append(inputBuf);

				dispL.append(inputBuf+""); //inputBuf 값을 받는다. 
				
			}
			 
		}else if(push == "-"){
		}else if(push == "*"){
		}else if(push == "/"){
		}else if(push == "="){
		}

	}
	

	


	public static void main(String[] args) {
		CalcAgain c = new CalcAgain(); 
		
	}
}

/*(라벨들은 보여주는 역할)
dispL > dispBuf
inputL > inputBuf : 데이터가 쌓임 "1111" 보이고 싶을 땐 inputL에 보내서 보임 >> "0" (지금상태)
*/