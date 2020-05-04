import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*; 
import java.math.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ScoreForm extends JFrame implements ActionListener{
	private ArrayList<ScoreDTO> list; 
	//private Vector<String> vector; ���͵� ���� ���� �ʿ����. 
	private JTable table;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton addBtn, printBtn, searchBtn, rankBtn, saveBtn, openBtn;
	private Score score; //impl�� score�� ��´�. (�θ��� ������ ��´� )

	private DefaultTableModel model;
	// ���� ���͸� �ް� ���̺��� ���� �޴´�. 
	// ���Ͱ� �����͸� �� ���� ����ش�. 
	// ���� �����͸� �������ش�. (�𵨿��� �����͸� �ְ� ����)
	// ���̺��� �ܼ��� view �����ֱ⸸ �Ѵ� 

	// �޼ҵ带 �߻����� �� ���� ��ü�� new �ȵǰ� implements�� �������� �����ΰ�?

	public ScoreForm(){
		
		super("���� ���� ���α׷�");
	
		// ���� ScoreForm
		JPanel leftP = new JPanel();
		leftP.setLayout(new GridLayout(5, 1, 5, 5));

		// �Է� ��
		// ���� �׶��׶� ���� ���� �Ŷ� ���� ���� �ʿ� ����. 
		JLabel hakL = new JLabel("�й�");
		JLabel nameL = new JLabel("�̸�");
		JLabel korL = new JLabel("����");
		JLabel engL = new JLabel("����");
		JLabel mathL = new JLabel("����");
		
		// �Է� �ʵ� 
		hakT = new JTextField(20);
		nameT = new JTextField(20);
		korT = new JTextField(20);
		engT = new JTextField(20);
		mathT = new JTextField(20);
		
		// �Է� panel 
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


		// ������ ���̺�
		// Ÿ��Ʋ

		// ���� > �� > �� 
		Vector<String> vector = new Vector<String>();
		vector.add("�й�");
		vector.add("�̸�");
		vector.add("����");
		vector.add("����");
		vector.add("����");
		vector.add("����");
		vector.add("���");
		model = new DefaultTableModel(vector, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		JPanel rightP = new JPanel();
		rightP.setLayout(new GridLayout(1, 1));
		rightP.add(scroll);
		


		// ���� ������ �г� ��ħ
		JPanel centerP = new JPanel();
		centerP.setLayout(new GridLayout(1, 2));
		centerP.add(leftP);
		centerP.add(rightP);
		
		score = new ScoreImpl();
		// ������ �ڽ����� ��´�. 
		// �θ�� �ڽĿ� �ִ� �͵��� ������ �� �ִ�(������)
		

		// ��ư ���� 
		addBtn = new JButton("�Է�");
		printBtn = new JButton("���");
		searchBtn = new JButton("�й��˻�");
		rankBtn = new JButton("����");
		saveBtn = new JButton("��������");
		openBtn = new JButton("���Ͽ���");
		
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

		// ������ 
		setBounds(700, 500, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	} // ScoreForm() 
	

	public void event(){
		// ��ư �̺�Ʈ ȣ�� 
		addBtn.addActionListener(this);
		printBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
	}// event()

	// ��ư �̺�Ʈ 
	// ���⼭ ���� �޾Ƽ� impl�� ������. 
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == addBtn){
				//impl�� �ִ� input() �޼���� ����.
				// �����͸� �޾ư����ϴµ� �����͸� �޴� ���� ScoreForm�̴�
				// impl�� input������ ���� �����͸� ���� �� �����Ƿ� ���⼭ �����͸� ��´�. 
				ScoreDTO dto = new ScoreDTO();
				
				dto.setHak(hakT.getText());
				dto.setName(nameT.getText());
				dto.setKor(Integer.parseInt(korT.getText()));
				dto.setEng(Integer.parseInt(engT.getText()));
				dto.setMath(Integer.parseInt(mathT.getText()));
				
				dto.calc(); // ���� ��� ��� 
				
				score.input(dto); // ���� dto �����͸� ������ impl�� ���� (impl�� score�� implements��) 
				
				/*if(hakT.getText().equals(dto.getHak()){
				} �ߺ� ���̵�� �ߺ��� ���̵��� ���� �޼��� ���� */

				JOptionPane.showMessageDialog(this, " ��� �Ϸ� "); // impl���� ������ frame�� ������ �������� �ȴ�(this�� �ƴ� null)
				// form ���� ���� form ���� �߰� �ȴ�. 
				/*
				String hak = hakT.getText();
				String name = nameT.getText();
				int kor = korT.getText();
				int eng = engT.getText();
				int math = mathT.getText();*/

				// �ʱ�ȭ 
				hakT.setText("");
				nameT.setText("");
				korT.setText("");
				engT.setText("");
				mathT.setText("");

			}else if(e.getSource() == printBtn){
				score.print(model);
				// table�� �����͸� �������� model���� �����͸� �־��ָ� �ȴ�. 
			}else if(e.getSource() == searchBtn){
				// impl���� ����� ���� ���� �� dialog�� frame �ۿ��� �����Ǳ� ������ ���⼭ �����. (frame���� dialog ���� ����)
				String hak = JOptionPane.showInputDialog(this, "�й��� �Է��ϼ���" );
				if(hak == null || hak.equals("")) return; // ������ ������. 

				int sw = score.search(model, hak); // ã���� �ϴ� hak�� model�� �Բ� �Ѱ��ش�. 
				// ����� ���̺� �ѷ��ٰ��̱� ������ model ���� ������ ����. 
				// score.search�� model, hak�� ������ 
				// score.search���� return ���� �´� 
				// return ���� �� �� return ���� ���� ������ �������־���Ѵ� (int sw) 
				if(sw == 0) JOptionPane.showMessageDialog(this, "ã�� ������ �����ϴ�");

			}else if(e.getSource() == rankBtn){
				// �������� �������� 
				score.to_desc();
				score.print(model); // ���ĵ� ������ ��� 
			}else if(e.getSource() == saveBtn){
				score.save();
			}else if(e.getSource() == openBtn){
				score.load();
				score.print(model); // �ҷ��� ���� ������ print �ѷ�����Ѵ�. 
				}
			}

}
