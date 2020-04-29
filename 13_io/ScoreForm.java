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
	
	// �޼ҵ带 �߻����� �� ���� ��ü�� new �ȵǰ� implements�� �������� �����ΰ�?

	public ScoreForm(){
		
		super("���� ���� ���α׷�");
	
		// ���� 
		JPanel leftP = new JPanel();
		leftP.setLayout(new GridLayout(5, 1, 5, 10));

		// �Է� ��
		hakL = new JLabel("�й�");
		nameL = new JLabel("�̸�");
		korL = new JLabel("����");
		engL = new JLabel("����");
		mathL = new JLabel("����");
		
		// �Է� �ʵ� 
		hakT = new JTextField(18);
		nameT = new JTextField(18);
		korT = new JTextField(18);
		engT = new JTextField(18);
		mathT = new JTextField(18);
		
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


		// ������ 
		// Ÿ��Ʋ
		vector = new Vector<String>();
		vector.addElement("�й�");
		vector.addElement("�̸�");
		vector.addElement("����");
		vector.addElement("����");
		vector.addElement("����");
		vector.addElement("����");
		vector.addElement("���");

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
	


		// ���� ������ �г� ��ħ
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 2, 5, 5));
		center.add(leftP);
		center.add(rightP);
	

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
		
		
		add(p);
		
		this.getContentPane().add("North", new JPanel());
		this.getContentPane().add("Center", center);
		this.getContentPane().add("South", p);

		// ������ 
		setBounds(700, 500, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// ��ư �̺�Ʈ ȣ�� 
		addBtn.addActionListener(this);
		printBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);

		

	} // ������ 

	// ��ư �̺�Ʈ 
	// ���⼭ ���� �޾Ƽ� impl�� ������. 
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == addBtn){
			new ScoreDTO(dto.getHak(), dto.getName(), dto.getKor(), dto.getEng(), dto.getMath());
			// �� �־��ֱ� 
			dto.calcTot();
			dto.calcAvg();
			
			list.add(dto);
			System.out.println("�Է� �Ϸ�");
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
