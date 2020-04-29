import java.awt.*;
import java.util.ArrayList; 
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ScoreForm extends JFrame implements ActionListener{
	private ArrayList<ScoreDTO> list; 
	private ScoreImpl si;
	private Vector<String> vector;
	private JTable table;
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton addBtn, printBtn, searchBtn, rankBtn, saveBtn, openBtn;
	private DefaultTableModel model;
	
	// 메소드를 추상으로 한 것은 자체적 new 안되고 implements로 가져오기 위함인가?

	public ScoreForm(){
		
		super("학점 관리 프로그램");
	
		// 왼쪽 
		JPanel leftP = new JPanel();
		leftP.setLayout(new GridLayout(5, 1, 5, 10));

		// 입력 라벨
		hakL = new JLabel("학번");
		nameL = new JLabel("이름");
		korL = new JLabel("국어");
		engL = new JLabel("영어");
		mathL = new JLabel("수학");
		
		// 입력 필드 
		hakT = new JTextField(18);
		nameT = new JTextField(18);
		korT = new JTextField(18);
		engT = new JTextField(18);
		mathT = new JTextField(18);
		
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


		// 오른쪽 
		// 타이틀
		vector = new Vector<String>();
		vector.addElement("학번");
		vector.addElement("이름");
		vector.addElement("국어");
		vector.addElement("영어");
		vector.addElement("수학");
		vector.addElement("총점");
		vector.addElement("평균");

		JPanel rightP = new JPanel();
		rightP.setLayout(new GridLayout(1, 1, 1, 1));
		model = new DefaultTableModel(vector, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		rightP.add(scroll);
		scroll.setBounds(9, 0, 295, 200);
		

		for(ScoreDTO dto : list){
			Vector<String> v = new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor() + "");
			v.add(dto.getEng() + "");
			v.add(dto.getMath()+ "");
			v.add(dto.getTot() + "");
			v.add(dto.getAvg() + "");

			model.addRow(v);
		}// for
	


		// 왼쪽 오른쪽 패널 합침
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 2, 5, 5));
		center.add(leftP);
		center.add(rightP);
	

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
		
		
		add(p);
		
		this.getContentPane().add("North", new JPanel());
		this.getContentPane().add("Center", center);
		this.getContentPane().add("South", p);

		// 프레임 
		setBounds(700, 500, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 버튼 이벤트 호출 
		addBtn.addActionListener(this);
		printBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);

		

	} // 생성자 

	// 버튼 이벤트 
	// 여기서 값을 받아서 impl로 보낸다. 
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == addBtn){
			new ScoreDTO(dto.getHak(), dto.getName(), dto.getKor(), dto.getEng(), dto.getMath());
			// 값 넣어주기 
			dto.calcTot();
			dto.calcAvg();
			
			list.add(dto);
			System.out.println("입력 완료");
		}else if(e.getSource == printBtn){
			//print();
		}else if(e.getSource == searchBtn){
			//search();
		}else if(e.getSource == rankBtn){
			//to_desc();
		}else if(e.getSource == saveBtn){
			//load();
		}else if(e.getSource == openBtn){
			//save();
		}
		
	}


}
