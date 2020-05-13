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
		// ���� �г�
		JPanel leftP = new JPanel();

		JLabel titleL = new JLabel("���������Է�");
		leftP.setBounds(145, 15, 80, 25);
		titleL.setOpaque(true);

		leftP.add(titleL);

		JPanel numP = new JPanel();
		numL = new JLabel("��ȣ : ");
		numL.setOpaque(true);
		numL.setHorizontalAlignment(JLabel.CENTER);
		numL2 = new JLabel();
		numL2.setForeground(Color.WHITE);
		numL2.setOpaque(true);

		numP.add(numL);
		numP.add(numL2);
		leftP.add(numP);

		JPanel nameP = new JPanel();
		JLabel nameL = new JLabel("�̸�");
		nameTF = new JTextField(10);
		nameP.add(nameL);
		nameP.add(nameTF);
		leftP.add(nameP);
		nameL.setOpaque(true);

		JPanel telP = new JPanel();
		JLabel telL = new JLabel("��ȭ��ȣ : ");
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

		JLabel genderL = new JLabel("���� : ");

		ButtonGroup btnGroup = new ButtonGroup();

		maleBtn = new JRadioButton("����", true);

		femaleBtn = new JRadioButton("����");

		btnGroup.add(maleBtn);
		btnGroup.add(femaleBtn);

		genderP.add(genderL);
		genderP.add(maleBtn);
		genderP.add(femaleBtn);
		leftP.add(genderP);

		JPanel checkP = new JPanel();

		readBtn = new JCheckBox("����");
		movieBtn = new JCheckBox("��ȭ");
		musicBtn = new JCheckBox("����");
		gameBtn = new JCheckBox("����");
		shoppingBtn = new JCheckBox("����");

		checkP.add(readBtn);
		checkP.add(movieBtn);
		checkP.add(musicBtn);
		checkP.add(gameBtn);
		checkP.add(shoppingBtn);

		leftP.add(checkP);

		JPanel btnP = new JPanel();
		btnP.setOpaque(true);
		insertBtn = new JButton("���");
		updateBtn = new JButton("����");
		deleteBtn = new JButton("����");
		removeBtn = new JButton("�����");
		btnP.add(insertBtn);
		btnP.add(updateBtn);
		btnP.add(deleteBtn);
		btnP.add(removeBtn);

		// ��ư ��Ȱ��ȭ
		updateBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		removeBtn.setEnabled(false);

		leftP.add(btnP);

		// ������
		JPanel rightP = new JPanel();
		rightP.setLayout(new FlowLayout());
		JLabel titleL2 = new JLabel("��ü���");
		titleL2.setHorizontalAlignment(JLabel.CENTER);
		titleL2.setOpaque(true);

		// list �� �����͸� �����ְ�
		// �����͸� �־��� ���� �ϴ� ���� model
		list = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>) list.getModel();

		list.setBounds(450, 15, 70, 25);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		rightP.add(titleL2);
		rightP.add(scroll);

		// �Ʒ� �г�
		JPanel bottomP = new JPanel();
		// bottomP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel titleL3 = new JLabel("���������м�");
		titleL3.setBounds(250, 325, 80, 25);
		titleL3.setHorizontalAlignment(JLabel.CENTER);
		titleL3.setOpaque(true);

		textarea = new JTextArea(10, 45);
		textarea.setBounds(10, 360, 580, 180);

		bottomP.add(titleL3);
		bottomP.add(textarea);

		// ���� ���� �� ��ġ��
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

		// db �ε�, getConnection�� DAO�� ����

		// db ��� ���ڵ�(��)�� ������ JList�� �Ѹ���
		// ���ڵ� �� ���� FriendDTO�� �ִ´�. ... �ݺ�
		// ���� ���ڵ尡 5���� ���� �Ұ� (������ 1���� ����)
		// ���� �� FriendDTO ���� LIST�� ��� ����־���Ѵ�.
		// ����Ʈ �ȿ��� �ϳ��� ��´�!
		List<FriendDTO> arraylist = friendDAO.getFriendList(); // dao���� ����Ʈ�� ������ �´�.
		// ARRAYLIST�� �θ��� LIST�� ���ϰ��� �޴´�
		for (FriendDTO friendDTO : arraylist) {
			model.addElement(friendDTO);
		}

		// JList�� �̺�Ʈ �߻� : javax.swing.event
		// ���� list�� �۾��� ����ִ� ���� �ƴϴ�. dto�� ����ִ� ��
		// �� list ���� dto Ŭ���� dto ���� ������ ���� �Է�â�� �����͸� �ѷ��� �� �ְ�

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
			// DAO�� SEQ ���� ������ �ٽ� �ް� ���⼭ ����Ѵ�.
			int seq = friendDAO.getSeq();
			System.out.println(seq); // Ȯ�ο����� ����

			// ������ ����
			String name = nameTF.getText();
			String tel1 = (String) combo.getSelectedItem(); // combobox �ȿ� ���빰�� ���´�
			// combo�� obejct�� �´�. �װ� �޴� tel1 �� string�̴�
			// �θ�� �ڽ��� �ٷ� ������ �� ����.
			// �ٿ� ĳ������ ���ش� (�θ� �ڽ����� ����ȯ) �ڽ� = (�ڽ�)�θ�
			String tel2 = frontTel.getText();
			String tel3 = backTel.getText();

			// ���� ��Ʈ
			int gender = 0;
			if (maleBtn.isSelected())
				gender = 0;
			else if (femaleBtn.isSelected())
				gender = 1;

			// ��� ��Ʈ (���ǿ�����)
			int read = readBtn.isSelected() ? 1 : 0;
			int movie = movieBtn.isSelected() ? 1 : 0;
			int music = musicBtn.isSelected() ? 1 : 0;
			int game = gameBtn.isSelected() ? 1 : 0;
			int shopping = shoppingBtn.isSelected() ? 1 : 0;

			// ���� �����͵��� db �� �ִ´� >> DAO�� �Ѿ��.

			FriendDTO friendDTO = new FriendDTO(); // ���� �������� �׶��׶� ����� ����
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
			// ��� �޾Ҵ��� ���� �˷��ֱ� ���� su �ȿ� �ִ´�.

			// ���� ������ textarea�� �ѷ��ش�.
			// ����

			// �ʱ�ȭ
			remove();

			textarea.setText("\n\t" + su + "���� ����Ͽ����ϴ�");
			model.addElement(friendDTO); // list�� ����� �ߵ���
			// �𵨰� ����Ʈ�� ����� ����
			// �ּҰ��� �ƴ� ���� �ߵ��� �Ѵ�.

		} else if (e.getSource() == updateBtn) {
			// ����

			// Ŭ���� �Է� �ʵ忡 �߰�

			int index = model.indexOf(selectedDTO); // �� dto�� index�� ����
			System.out.println(index + "�� �ε��� ����");

			selectedDTO = list.getSelectedValue(); // ���ù��� dto

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
			textarea.setText("\n\t" + su + "�� �����Ͽ����ϴ�.");
			model.set(index, selectedDTO);

			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(true);
			removeBtn.setEnabled(true);

		} else if (e.getSource() == deleteBtn) {
			// ����
			int index = model.indexOf(selectedDTO);
			System.out.println(index + "�� �ε��� ����");

			selectedDTO = list.getSelectedValue();

			int su = friendDAO.friendDelete(selectedDTO);

			remove(); // �ʱ�ȭ
			textarea.setText("\n\t" + su + "�� �����Ͽ����ϴ�.");

			model.removeElement(selectedDTO);

			insertBtn.setEnabled(true);
			updateBtn.setEnabled(true);
			deleteBtn.setEnabled(false);
			removeBtn.setEnabled(true);

		} else if (e.getSource() == removeBtn) {
			remove();
		}

	}

	// ����Ʈ Ŭ�� �� ���� â�� �ߵ���

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("aaa");
		// ���콺 Ŭ���� �� �� ���, �� �� �� �� �� ��µǴ� ����.
		// ���� list���� ���ڿ��� �ƴ� 11���� �׸��� ������ �ִ� dto�� ���ִ� ����

		FriendDTO friendDTO = list.getSelectedValue();
		selectedDTO = list.getSelectedValue(); // ���õ� DTO

		// friendDTO�� �޴´�.
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

		// ��ư ��Ȱ��ȭ
		insertBtn.setEnabled(false);
		updateBtn.setEnabled(true);
		deleteBtn.setEnabled(true);
		removeBtn.setEnabled(true);

	}

	// ����Ʈ�� �� �Ѿ �� �ʵ尪 �ʱ�ȭ
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