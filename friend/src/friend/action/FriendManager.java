package friend.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

public class FriendManager extends JFrame implements ActionListener, ListSelectionListener {
	private JLabel numL, numL2;
	private JButton insertBtn, updateBtn, deleteBtn, removeBtn;
	private JTextField nameTF, frontTel, backTel;
	private JTextArea textarea;
	private JComboBox<String> combo;
	private JRadioButton maleBtn, femaleBtn;
	private JCheckBox readBtn, movieBtn, musicBtn, gameBtn, shoppingBtn;
	private JList<FriendDTO> list;
	private DefaultListModel<FriendDTO> model;
	private FriendDAO friendDAO = new FriendDAO();
	private FriendDTO selectedDTO;

	// GETTER SETTER
	public FriendDTO getSelectedDTO() {
		return selectedDTO;
	}

	public void setSelectedDTO(FriendDTO selectedDTO) {
		this.selectedDTO = selectedDTO;
	}

	public FriendManager() {

		setBackground(new Color(128, 128, 192));
		// 왼쪽 패널
		JPanel leftP = new JPanel();

		JLabel titleL = new JLabel("개인정보입력");
		leftP.setBounds(145, 15, 80, 25);
		titleL.setOpaque(true);

		leftP.add(titleL);

		JPanel numP = new JPanel();
		numL = new JLabel("번호 : ");
		numL.setOpaque(true);
		numL.setHorizontalAlignment(JLabel.CENTER);
		numL2 = new JLabel();
		numL2.setForeground(Color.WHITE);
		numL2.setOpaque(true);

		numP.add(numL);
		numP.add(numL2);
		leftP.add(numP);

		JPanel nameP = new JPanel();
		JLabel nameL = new JLabel("이름");
		nameTF = new JTextField(10);
		nameP.add(nameL);
		nameP.add(nameTF);
		leftP.add(nameP);
		nameL.setOpaque(true);

		JPanel telP = new JPanel();
		JLabel telL = new JLabel("전화번호 : ");
		String telCombo[] = { "010", "011", "019" };
		combo = new JComboBox<String>(telCombo);
		JLabel spaceL = new JLabel("-");
		frontTel = new JTextField(5);
		JLabel spaceL2 = new JLabel("-");
		backTel = new JTextField(5);
		telL.setOpaque(true);

		telP.add(telL);
		telP.add(combo);
		telP.add(spaceL);
		telP.add(frontTel);
		telP.add(spaceL2);
		telP.add(backTel);
		leftP.add(telP);

		JPanel genderP = new JPanel();

		JLabel genderL = new JLabel("성별 : ");

		ButtonGroup btnGroup = new ButtonGroup();

		maleBtn = new JRadioButton("남성", true);

		femaleBtn = new JRadioButton("여성");

		btnGroup.add(maleBtn);
		btnGroup.add(femaleBtn);

		genderP.add(genderL);
		genderP.add(maleBtn);
		genderP.add(femaleBtn);
		leftP.add(genderP);

		JPanel checkP = new JPanel();

		readBtn = new JCheckBox("독서");
		movieBtn = new JCheckBox("영화");
		musicBtn = new JCheckBox("음악");
		gameBtn = new JCheckBox("게임");
		shoppingBtn = new JCheckBox("쇼핑");

		checkP.add(readBtn);
		checkP.add(movieBtn);
		checkP.add(musicBtn);
		checkP.add(gameBtn);
		checkP.add(shoppingBtn);

		leftP.add(checkP);

		JPanel btnP = new JPanel();
		btnP.setOpaque(true);
		insertBtn = new JButton("등록");
		updateBtn = new JButton("수정");
		deleteBtn = new JButton("삭제");
		removeBtn = new JButton("지우기");
		btnP.add(insertBtn);
		btnP.add(updateBtn);
		btnP.add(deleteBtn);
		btnP.add(removeBtn);

		// 버튼 비활성화
		updateBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		removeBtn.setEnabled(false);

		leftP.add(btnP);

		// 오른쪽
		JPanel rightP = new JPanel();
		rightP.setLayout(new FlowLayout());
		JLabel titleL2 = new JLabel("전체목록");
		titleL2.setHorizontalAlignment(JLabel.CENTER);
		titleL2.setOpaque(true);

		// list 는 데이터를 보여주고
		// 데이터를 넣었다 뺐다 하는 곳은 model
		list = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>) list.getModel();

		list.setBounds(450, 15, 70, 25);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		rightP.add(titleL2);
		rightP.add(scroll);

		// 아래 패널
		JPanel bottomP = new JPanel();
		// bottomP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel titleL3 = new JLabel("개인정보분석");
		titleL3.setBounds(250, 325, 80, 25);
		titleL3.setHorizontalAlignment(JLabel.CENTER);
		titleL3.setOpaque(true);

		textarea = new JTextArea(10, 45);
		textarea.setBounds(10, 360, 580, 180);

		bottomP.add(titleL3);
		bottomP.add(textarea);

		// 왼쪽 오른 쪽 합치기
		JPanel centerP = new JPanel();
		centerP.setLayout(new GridLayout(1, 2, 5, 20));
		centerP.add(leftP);
		centerP.add(rightP);

		Container c = getContentPane();

		c.add("Center", centerP);
		c.add("South", bottomP);

		setSize(610, 580);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// db 로딩, getConnection은 DAO의 역할

		// db 모든 레코드(행)를 꺼내서 JList에 뿌리기
		// 레코드 한 줄을 FriendDTO에 넣는다. ... 반복
		// 만약 레코드가 5개면 리턴 불가 (리턴은 1개만 가능)
		// 따라서 이 FriendDTO 들을 LIST를 잡아 모아주어야한다.
		// 리스트 안에다 하나씩 담는다!
		List<FriendDTO> arraylist = friendDAO.getFriendList(); // dao에서 리스트를 가지고 온다.
		// ARRAYLIST의 부모인 LIST로 리턴값을 받는다
		for (FriendDTO friendDTO : arraylist) {
			model.addElement(friendDTO);
		}

		// JList가 이벤트 발생 : javax.swing.event
		// 현재 list에 글씨가 들어있는 것이 아니다. dto가 들어있는 것
		// 이 list 안의 dto 클릭시 dto 내용 꺼내서 왼쪽 입력창에 데이터를 뿌려줄 수 있게

	}// constructor

	public void event() {
		insertBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		removeBtn.addActionListener(this);

		list.addListSelectionListener(this);

	}// event()

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertBtn) {
			// DAO에 SEQ 값을 보내고 다시 받고 여기서 출력한다.
			int seq = friendDAO.getSeq();
			System.out.println(seq); // 확인용으로 찍음

			// 데이터 얻어옴
			String name = nameTF.getText();
			String tel1 = (String) combo.getSelectedItem(); // combobox 안에 내용물을 얻어온다
			// combo가 obejct로 온다. 그걸 받는 tel1 은 string이다
			// 부모는 자식을 바로 참조할 수 없다.
			// 다운 캐스팅을 해준다 (부모를 자식으로 형변환) 자식 = (자식)부모
			String tel2 = frontTel.getText();
			String tel3 = backTel.getText();

			// 성별 파트
			int gender = 0;
			if (maleBtn.isSelected())
				gender = 0;
			else if (femaleBtn.isSelected())
				gender = 1;

			// 취미 파트 (조건연산자)
			int read = readBtn.isSelected() ? 1 : 0;
			int movie = movieBtn.isSelected() ? 1 : 0;
			int music = musicBtn.isSelected() ? 1 : 0;
			int game = gameBtn.isSelected() ? 1 : 0;
			int shopping = shoppingBtn.isSelected() ? 1 : 0;

			// 받은 데이터들을 db 에 넣는다 >> DAO로 넘어간다.

			FriendDTO friendDTO = new FriendDTO(); // 전역 잡지말고 그때그때 만들어 쓰자
			friendDTO.setSeq(seq);
			friendDTO.setName(name);
			friendDTO.setTel1(tel1);
			friendDTO.setTel2(tel2);
			friendDTO.setTel3(tel3);
			friendDTO.setGender(gender);
			friendDTO.setRead(read);
			friendDTO.setMovie(movie);
			friendDTO.setMusic(music);
			friendDTO.setGame(game);
			friendDTO.setShopping(shopping);

			int su = friendDAO.friendWrite(friendDTO);
			// 몇개를 받았는지 갯수 알려주기 위해 su 안에 넣는다.

			// 받은 정보는 textarea에 뿌려준다.
			// 응답

			// 초기화
			remove();

			textarea.setText("\n\t" + su + "명을 등록하였습니다");
			model.addElement(friendDTO); // list에 명단이 뜨도록
			// 모델과 리스트는 연결된 상태
			// 주소값이 아닌 값이 뜨도록 한다.

		} else if (e.getSource() == updateBtn) {
			// 수정

			// 클릭스 입력 필드에 뜨게

			int index = model.indexOf(selectedDTO); // 고른 dto를 index에 저장
			System.out.println(index + "번 인덱스 저장");

			selectedDTO = list.getSelectedValue(); // 선택받은 dto

			selectedDTO.setName(nameTF.getText());
			selectedDTO.setTel1(combo.getSelectedItem() + "");
			selectedDTO.setTel2(frontTel.getText());
			selectedDTO.setTel3(backTel.getText());
			selectedDTO.setGender(femaleBtn.isSelected() ? 1 : 0);
			selectedDTO.setRead(readBtn.isSelected() ? 1 : 0);
			selectedDTO.setMovie(movieBtn.isSelected() ? 1 : 0);
			selectedDTO.setMusic(musicBtn.isSelected() ? 1 : 0);
			selectedDTO.setGame(gameBtn.isSelected() ? 1 : 0);
			selectedDTO.setShopping(shoppingBtn.isSelected() ? 1 : 0);

			int su = friendDAO.friendUpdate(selectedDTO);

			remove();
			textarea.setText("\n\t" + su + "명 수정하였습니다.");
			model.set(index, selectedDTO);

			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(true);
			removeBtn.setEnabled(true);

		} else if (e.getSource() == deleteBtn) {
			// 삭제
			int index = model.indexOf(selectedDTO);
			System.out.println(index + "번 인덱스 저장");

			selectedDTO = list.getSelectedValue();

			int su = friendDAO.friendDelete(selectedDTO);

			remove(); // 초기화
			textarea.setText("\n\t" + su + "명 삭제하였습니다.");

			model.removeElement(selectedDTO);

			insertBtn.setEnabled(true);
			updateBtn.setEnabled(true);
			deleteBtn.setEnabled(false);
			removeBtn.setEnabled(true);

		} else if (e.getSource() == removeBtn) {
			remove();
		}

	}

	// 리스트 클릭 시 왼쪽 창에 뜨도록

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("aaa");
		// 마우스 클릭시 한 번 출력, 뗼 때 한 번 더 출력되는 상태.
		// 현재 list에는 문자열이 아닌 11개의 항목을 가지고 있는 dto가 들어가있는 상태

		FriendDTO friendDTO = list.getSelectedValue();
		selectedDTO = list.getSelectedValue(); // 선택된 DTO

		// friendDTO로 받는다.
		if (friendDTO == null) {
			return;	
		}
		numL2.setText(friendDTO.getSeq() + "");
		nameTF.setText(friendDTO.getName());
		combo.setSelectedItem(friendDTO.getTel1());
		frontTel.setText(friendDTO.getTel2());
		backTel.setText(friendDTO.getTel3());

		if (friendDTO.getGender() == 0) {
			maleBtn.setSelected(true);
		} else {
			femaleBtn.setSelected(false);
		}

		readBtn.setSelected(friendDTO.getRead() == 1 ? true : false);
		movieBtn.setSelected(friendDTO.getMovie() == 1 ? true : false);
		musicBtn.setSelected(friendDTO.getMusic() == 1 ? true : false);
		gameBtn.setSelected(friendDTO.getGame() == 1 ? true : false);
		shoppingBtn.setSelected(friendDTO.getShopping() == 1 ? true : false);

		// 버튼 비활성화
		insertBtn.setEnabled(false);
		updateBtn.setEnabled(true);
		deleteBtn.setEnabled(true);
		removeBtn.setEnabled(true);

	}

	// 리스트로 값 넘어갈 시 필드값 초기화
	public void remove() {
		numL2.setText("");
		nameTF.setText("");

		combo.setSelectedItem("010");
		frontTel.setText("");
		backTel.setText("");

		maleBtn.setSelected(true);
		femaleBtn.setSelected(false);

		readBtn.setSelected(false);
		musicBtn.setSelected(false);
		movieBtn.setSelected(false);
		gameBtn.setSelected(false);
		shoppingBtn.setSelected(false);

		insertBtn.setEnabled(true);
		updateBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		removeBtn.setEnabled(false);

		textarea.setText("");
	}

	public static void main(String[] args) {
		new FriendManager().event();
	}

}