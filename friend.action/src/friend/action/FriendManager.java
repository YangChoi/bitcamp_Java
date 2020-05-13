package friend.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

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

import friend.bean.FriendDTO;


public class FriendManager extends JFrame{
	private JButton insertBtn, updateBtn, deleteBtn, deleteBtn2;
	private JTextField nameTF, frontTel, backTel;
	private JTextArea textarea;
	private DefaultListModel<FriendDTO> model;
	private JComboBox<String> combo;
	private JRadioButton maleBtn, femaleBtn;
	private JCheckBox readBtn, movieBtn, musicBtn, gameBtn, shoppingBtn;

	private JList<FriendDTO> list;
	
	public FriendManager() {
		
		setBackground(new Color(128, 128, 192));
		// ���� �г� 
		JPanel leftP = new JPanel();
		leftP.setLayout(new GridLayout(7, 1, 3, 5));

		
		JLabel titleL = new JLabel("���������Է�");
		titleL.setHorizontalAlignment(JLabel.CENTER);
		titleL.setOpaque(true);
		

		leftP.add(titleL);
		
		JPanel numP = new JPanel();
		JLabel numL = new JLabel("��ȣ : ");
		numL.setOpaque(true);
		numL.setHorizontalAlignment(JLabel.CENTER);
		JLabel numL2 = new JLabel("    ");
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
		String telCombo[] = {"010", "011", "019"};
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
		genderL.setOpaque(true);
		ButtonGroup btnGroup = new ButtonGroup();
		maleBtn = new JRadioButton("����", true);
		femaleBtn = new JRadioButton("����");
		
		btnGroup.add(maleBtn);
		btnGroup.add(femaleBtn);
		
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
		deleteBtn2 = new JButton("�����");
		btnP.add(insertBtn);
		btnP.add(updateBtn);
		btnP.add(deleteBtn);
		btnP.add(deleteBtn2);
		
		// ��ư ��Ȱ��ȭ
		updateBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		deleteBtn2.setEnabled(false);
		
		leftP.add(btnP);
	
		
	
		
		// ������ 
		JPanel rightP = new JPanel();
		rightP.setLayout(new FlowLayout());
		JLabel titleL2 = new JLabel("��ü���");
		titleL2.setHorizontalAlignment(JLabel.CENTER);
		titleL2.setOpaque(true);
	
		model = new DefaultListModel<FriendDTO>();

		list = new JList<FriendDTO>(model);
		
		list.setFixedCellHeight(300);
		list.setFixedCellWidth(300);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		rightP.add(titleL2);
		rightP.add(scroll);
		
		// �Ʒ� �г� 
		JPanel bottomP = new JPanel();
		bottomP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel titleL3 = new JLabel("���������м�");
		titleL3.setHorizontalAlignment(JLabel.CENTER);
		titleL3.setOpaque(true);

		
		textarea = new JTextArea(10, 45);
		textarea.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		
		
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
		
		
		setBounds(400, 200, 600, 660);
		setVisible(true);
		setResizable(false);
		
	}
	
	
	
	public static void main(String[] args) {
		new FriendManager();
	}

}
