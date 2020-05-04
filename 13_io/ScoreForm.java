import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*; 
import java.math.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ScoreForm extends JFrame implements ActionListener{
	private ArrayList<ScoreDTO> list; 
	//private Vector<String> vector; 벡터도 전역 잡을 필요없다. 
	private JTable table;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton addBtn, printBtn, searchBtn, rankBtn, saveBtn, openBtn;
	private Score score; //impl을 score로 잡는다. (부모의 것으로 잡는다 )

	private DefaultTableModel model;
	// 모델이 벡터를 받고 테이블이 모델을 받는다. 
	// 벡터가 데이터를 한 번에 담아준다. 
	// 모델은 데이터를 관리해준다. (모델에서 데이터를 넣고 빼고)
	// 테이블은 단순히 view 보여주기만 한다 

	// 메소드를 추상으로 한 것은 자체적 new 안되고 implements로 가져오기 위함인가?

	public ScoreForm(){
		
		super("학점 관리 프로그램");
	
		// 왼쪽 ScoreForm
		JPanel leftP = new JPanel();
		leftP.setLayout(new GridLayout(5, 1, 5, 5));

		// 입력 라벨
		// 라벨은 그때그때 쓰고 마는 거라서 전역 넣을 필요 없다. 
		JLabel hakL = new JLabel("학번");
		JLabel nameL = new JLabel("이름");
		JLabel korL = new JLabel("국어");
		JLabel engL = new JLabel("영어");
		JLabel mathL = new JLabel("수학");
		
		// 입력 필드 
		hakT = new JTextField(20);
		nameT = new JTextField(20);
		korT = new JTextField(20);
		engT = new JTextField(20);
		mathT = new JTextField(20);
		
		// 입력 panel 
		JPanel hakP = new JPanel();
		hakP.add(hakL);
		hakP.add(hakT);
		JPanel nameP = new JPanel();
		nameP.add(nameL);
		nameP.add(nameT);
		JPanel korP = new JPanel();
		korP.add(korL);
		korP.add(korT);
		JPanel engP = new JPanel();
		engP.add(engL);
		engP.add(engT);
		JPanel mathP = new JPanel();
		mathP.add(mathL);
		mathP.add(mathT);
		
		
		leftP.add(hakP);
		leftP.add(nameP);
		leftP.add(korP);
		leftP.add(engP);
		leftP.add(mathP);


		// 오른쪽 테이블
		// 타이틀

		// 벡터 > 모델 > 뷰 
		Vector<String> vector = new Vector<String>();
		vector.add("학번");
		vector.add("이름");
		vector.add("국어");
		vector.add("영어");
		vector.add("수학");
		vector.add("총점");
		vector.add("평균");
		model = new DefaultTableModel(vector, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		JPanel rightP = new JPanel();
		rightP.setLayout(new GridLayout(1, 1));
		rightP.add(scroll);
		


		// 왼쪽 오른쪽 패널 합침
		JPanel centerP = new JPanel();
		centerP.setLayout(new GridLayout(1, 2));
		centerP.add(leftP);
		centerP.add(rightP);
		
		score = new ScoreImpl();
		// 생성은 자식으로 잡는다. 
		// 부모는 자식에 있는 것들을 참조할 수 있다(다형성)
		

		// 버튼 생성 
		addBtn = new JButton("입력");
		printBtn = new JButton("출력");
		searchBtn = new JButton("학번검색");
		rankBtn = new JButton("순위");
		saveBtn = new JButton("파일저장");
		openBtn = new JButton("파일열기");
		
		JPanel p = new JPanel();
		p.add(addBtn);
		p.add(printBtn);
		p.add(searchBtn);
		p.add(rankBtn);
		p.add(saveBtn);
		p.add(openBtn);
		

		Container c = getContentPane();
		c.add("Center", centerP);
		c.add("South", p);

		// 프레임 
		setBounds(700, 500, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	} // ScoreForm() 
	

	public void event(){
		// 버튼 이벤트 호출 
		addBtn.addActionListener(this);
		printBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
	}// event()

	// 버튼 이벤트 
	// 여기서 값을 받아서 impl로 보낸다. 
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == addBtn){
				//impl에 있는 input() 메서드로 간다.
				// 데이터를 받아가야하는데 데이터를 받는 것은 ScoreForm이다
				// impl의 input에서는 직접 데이터를 받을 수 없으므로 여기서 데이터를 잡는다. 
				ScoreDTO dto = new ScoreDTO();
				
				dto.setHak(hakT.getText());
				dto.setName(nameT.getText());
				dto.setKor(Integer.parseInt(korT.getText()));
				dto.setEng(Integer.parseInt(engT.getText()));
				dto.setMath(Integer.parseInt(mathT.getText()));
				
				dto.calc(); // 총점 평균 계산 
				
				score.input(dto); // 받은 dto 데이터를 가지고 impl로 간다 (impl은 score를 implements함) 
				
				/*if(hakT.getText().equals(dto.getHak()){
				} 중복 아이디면 중복된 아이디라는 에러 메세지 띄우기 */

				JOptionPane.showMessageDialog(this, " 등록 완료 "); // impl에다 잡으면 frame과 별도로 떨어지게 된다(this가 아닌 null)
				// form 에다 띄우면 form 위에 뜨게 된다. 
				/*
				String hak = hakT.getText();
				String name = nameT.getText();
				int kor = korT.getText();
				int eng = engT.getText();
				int math = mathT.getText();*/

				// 초기화 
				hakT.setText("");
				nameT.setText("");
				korT.setText("");
				engT.setText("");
				mathT.setText("");

			}else if(e.getSource() == printBtn){
				score.print(model);
				// table에 데이터를 넣으려면 model에다 데이터를 넣어주면 된다. 
			}else if(e.getSource() == searchBtn){
				// impl에서 물어보면 위와 같이 또 dialog가 frame 밖에서 생성되기 때문에 여기서 물어본다. (frame위에 dialog 띄우기 위해)
				String hak = JOptionPane.showInputDialog(this, "학번을 입력하세요" );
				if(hak == null || hak.equals("")) return; // 없으면 나간다. 

				int sw = score.search(model, hak); // 찾고자 하는 hak을 model과 함께 넘겨준다. 
				// 결과를 테이블에 뿌려줄것이기 때문에 model 값을 가지고 간다. 
				// score.search로 model, hak을 보내고 
				// score.search에서 return 값이 온다 
				// return 값이 올 시 return 값을 받을 변수를 설정해주어야한다 (int sw) 
				if(sw == 0) JOptionPane.showMessageDialog(this, "찾는 정보가 없습니다");

			}else if(e.getSource() == rankBtn){
				// 총점으로 내림차순 
				score.to_desc();
				score.print(model); // 정렬된 데이터 출력 
			}else if(e.getSource() == saveBtn){
				score.save();
			}else if(e.getSource() == openBtn){
				score.load();
				score.print(model); // 불러온 파일 내용을 print 뿌려줘야한다. 
				}
			}

}
