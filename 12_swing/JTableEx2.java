import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList; 
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

class JTableEx2 extends JFrame implements ActionListener{
	private ArrayList<PersonDTO> list; 
	private Vector<String> vector;
	private DefaultTableModel model; // JTable에서 추가, 삭제 기능 못하지만 DefaultTableModel 클래스에 
	// addRow, removeRow() 있다. 
	private JTable table;
	private JButton addBtn, delBtn; 
	private JPanel p;

	public JTableEx2(){
		list = new ArrayList<PersonDTO>(); // 리스트 생성 
		list.add(new PersonDTO("Yang", "양아무개", "111", "010-123-1456"));
		list.add(new PersonDTO("Choi", "최아무개", "333", "010-666-7777"));
		list.add(new PersonDTO("Park", "최아무개", "444", "010-666-7777"));

		// 타이틀 
		vector = new Vector<String>();
		vector.addElement("아이디");
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("전화번호");
		// addElement와 add는 같다. 

		
		// 타이틀을 여기에 넣는다 
		// 0 : 미리 행을 설정해 놓지 말라 
		// 0 : 내 밑의 칼럼을 빈걸로 만들겠다 
		model = new DefaultTableModel(vector, 0){
			@Override
			public boolean isCellEditable(int r, int c){ // 편집가능하게 한다. 
				return (c!=0) ? true : false; // 어떤 인덱스의 값을 수정 못하게 막는다. 
			} // model이 먹어야할 메서드 이기 때문에 익명클래스 만들어준다. 
				// 본 클래스는 frame이기 때문에 model을 찾아서 익명클래스 만들어 준 것 
		}; 
		// model을 가지고 table을 만들어라 
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		// 데이터 넣기 
		// 이미 list.add로 두개의 데이터를 넣어놓음 
		for(PersonDTO dto : list){
			Vector<String> v = new Vector<String>(); // 들어갈 때는 항상 Vector로 들어가짐 
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			// 여기까지가 딱 벡터 한 줄 

			model.addRow(v);
		}// for
		
		// 버튼 추가 
	
		addBtn = new JButton("추가");
		delBtn = new JButton("삭제");
		
		p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 버튼 오른 정렬 
		p.add(addBtn);
		p.add(delBtn);

		add("South",p);

		Container c = getContentPane(); // container 올리기 
		c.add("Center", scroll); // container에 table 올리기 
		// 아직 아무것도 안올리고 제목라인인 vector만 올린 상태 (데이터 넣기 전) 
		// table을 scroll에 붙혔으므로 scroll을 add한다. 
		
		setBounds(700, 100, 500, 400); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트 
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);

	}// JTableEx2()

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == addBtn){
			// addBtn 클릭시 
			// 항목입력받아서 model에 추가라는 내용을 insert 함수로 뺀다.(너무 기니까) 
			insert();
		}else if(e.getSource() == delBtn){
			// delBtn 클릭시 
			delete(); 
		}
	}

	// insert
	public void insert(){
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
		// 아이디가 없으면 그냥 나가기 
		// 아이디 중복되면 "사용중인 아이디 입니다." JOptionPane.showMessageDialog(this, "사용중인 아이디 입니다"); 
		// 를 띄우고 나가기
		// 그렇지 않으면 이름, 비밀번호, 핸드폰 입력받고 
		// 테이블에 추가 
		
		// 1. 아이디 유무 검사 
		if(id == null || id.length() == 0) {
			// 아이디 값이 안 들어올 시, 아이디 길이가 0 일시 메시지   
			// null일 때 먼저 나가게 해야 NullPointException 방지 

			JOptionPane.showMessageDialog(this, "아이디는 필수입력입니다.");
			return;// insert() 나감 
		}
		// 2. 아이디 중복 검사 
		for(int i = 0; i < model.getRowCount(); i++){ // 행의 갯수 가져옴 : getRowCount()
			if(id.equals(model.getValueAt(i,0))){ // 아이디값을 가져와야하므로 i행 0열
				// 아이디 중복시 
				JOptionPane.showMessageDialog(this, "사용중인 아이디입니다");
				return; // insert 나감 
			}
		}// for 
			String name = JOptionPane.showInputDialog(this, "이름을 입력하세요.");
			String pwd = JOptionPane.showInputDialog(this, "비밀번호를 입력하세요.");
			String tel = JOptionPane.showInputDialog(this, "전화번호를 입력하세요.");
			
			// 한 줄 넣기 위해서는 vector 생성해야한다. 
			Vector<String> v = new Vector<String>(); // 들어갈 때는 항상 Vector로 들어가짐 
			v.add(id);
			v.add(name);
			v.add(pwd);
			v.add(tel);
			
			model.addRow(v);
			
	}// insert()

	public void delete(){
		int sw = 0;
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");

		for(int i = 0; i < model.getRowCount(); i++){
			if(name.equals(model.getValueAt(i, 1))){
				// 중복되는 name을 찾는다. 
				// 인덱스 날리는 경우에는 인덱스가 재정렬이 되어 버린다. 
				// ITERATOR 말고 다른거 
				model.removeRow(i); // i row를 지운다. 
				// 왜냐하면 중복되는 이름을 다 제거할것이기 때문에
				// 어떤 인덱스가 제거되면 인덱스들이 밀려버리니까. (+
				// i에게 --해줘서 인덱스들이 다시 원상복귀 되도록 (중복되는 건 다 지워야하기 때문에)
				i--; 
				sw = 1;
			}
		}// for 

		if(sw == 0){
			JOptionPane.showMessageDialog(this, "삭제할 이름이 없습니다.");
		}
	}// delete()


	public static void main(String[] args) {
		new JTableEx2();
	}
}

/*

참 && 참  참 && 거짓  거짓 && 참  거짓&&거짓 
                   이미 거짓이면, 뒤에 것을 수행을 하지 않는다
참 || 참  참 || 거짓   거짓 || 참   거짓 || 거짓 

id == null || id.length() == 0
id가 이미 null이면 뒤에 것은 보지도 않는다. 

*/
