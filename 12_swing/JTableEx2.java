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
	private DefaultTableModel model; // JTable���� �߰�, ���� ��� �������� DefaultTableModel Ŭ������ 
	// addRow, removeRow() �ִ�. 
	private JTable table;
	private JButton addBtn, delBtn; 
	private JPanel p;

	public JTableEx2(){
		list = new ArrayList<PersonDTO>(); // ����Ʈ ���� 
		list.add(new PersonDTO("Yang", "��ƹ���", "111", "010-123-1456"));
		list.add(new PersonDTO("Choi", "�־ƹ���", "333", "010-666-7777"));
		list.add(new PersonDTO("Park", "�־ƹ���", "444", "010-666-7777"));

		// Ÿ��Ʋ 
		vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("��ȭ��ȣ");
		// addElement�� add�� ����. 

		
		// Ÿ��Ʋ�� ���⿡ �ִ´� 
		// 0 : �̸� ���� ������ ���� ���� 
		// 0 : �� ���� Į���� ��ɷ� ����ڴ� 
		model = new DefaultTableModel(vector, 0){
			@Override
			public boolean isCellEditable(int r, int c){ // ���������ϰ� �Ѵ�. 
				return (c!=0) ? true : false; // � �ε����� ���� ���� ���ϰ� ���´�. 
			} // model�� �Ծ���� �޼��� �̱� ������ �͸�Ŭ���� ������ش�. 
				// �� Ŭ������ frame�̱� ������ model�� ã�Ƽ� �͸�Ŭ���� ����� �� �� 
		}; 
		// model�� ������ table�� ������ 
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		// ������ �ֱ� 
		// �̹� list.add�� �ΰ��� �����͸� �־���� 
		for(PersonDTO dto : list){
			Vector<String> v = new Vector<String>(); // �� ���� �׻� Vector�� ���� 
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			// ��������� �� ���� �� �� 

			model.addRow(v);
		}// for
		
		// ��ư �߰� 
	
		addBtn = new JButton("�߰�");
		delBtn = new JButton("����");
		
		p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // ��ư ���� ���� 
		p.add(addBtn);
		p.add(delBtn);

		add("South",p);

		Container c = getContentPane(); // container �ø��� 
		c.add("Center", scroll); // container�� table �ø��� 
		// ���� �ƹ��͵� �ȿø��� ��������� vector�� �ø� ���� (������ �ֱ� ��) 
		// table�� scroll�� �������Ƿ� scroll�� add�Ѵ�. 
		
		setBounds(700, 100, 500, 400); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// �̺�Ʈ 
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);

	}// JTableEx2()

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == addBtn){
			// addBtn Ŭ���� 
			// �׸��Է¹޾Ƽ� model�� �߰���� ������ insert �Լ��� ����.(�ʹ� ��ϱ�) 
			insert();
		}else if(e.getSource() == delBtn){
			// delBtn Ŭ���� 
			delete(); 
		}
	}

	// insert
	public void insert(){
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		// ���̵� ������ �׳� ������ 
		// ���̵� �ߺ��Ǹ� "������� ���̵� �Դϴ�." JOptionPane.showMessageDialog(this, "������� ���̵� �Դϴ�"); 
		// �� ���� ������
		// �׷��� ������ �̸�, ��й�ȣ, �ڵ��� �Է¹ް� 
		// ���̺� �߰� 
		
		// 1. ���̵� ���� �˻� 
		if(id == null || id.length() == 0) {
			// ���̵� ���� �� ���� ��, ���̵� ���̰� 0 �Ͻ� �޽���   
			// null�� �� ���� ������ �ؾ� NullPointException ���� 

			JOptionPane.showMessageDialog(this, "���̵�� �ʼ��Է��Դϴ�.");
			return;// insert() ���� 
		}
		// 2. ���̵� �ߺ� �˻� 
		for(int i = 0; i < model.getRowCount(); i++){ // ���� ���� ������ : getRowCount()
			if(id.equals(model.getValueAt(i,0))){ // ���̵��� �����;��ϹǷ� i�� 0��
				// ���̵� �ߺ��� 
				JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�");
				return; // insert ���� 
			}
		}// for 
			String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���.");
			String pwd = JOptionPane.showInputDialog(this, "��й�ȣ�� �Է��ϼ���.");
			String tel = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���.");
			
			// �� �� �ֱ� ���ؼ��� vector �����ؾ��Ѵ�. 
			Vector<String> v = new Vector<String>(); // �� ���� �׻� Vector�� ���� 
			v.add(id);
			v.add(name);
			v.add(pwd);
			v.add(tel);
			
			model.addRow(v);
			
	}// insert()

	public void delete(){
		int sw = 0;
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");

		for(int i = 0; i < model.getRowCount(); i++){
			if(name.equals(model.getValueAt(i, 1))){
				// �ߺ��Ǵ� name�� ã�´�. 
				// �ε��� ������ ��쿡�� �ε����� �������� �Ǿ� ������. 
				// ITERATOR ���� �ٸ��� 
				model.removeRow(i); // i row�� �����. 
				// �ֳ��ϸ� �ߺ��Ǵ� �̸��� �� �����Ұ��̱� ������
				// � �ε����� ���ŵǸ� �ε������� �з������ϱ�. (+
				// i���� --���༭ �ε������� �ٽ� ���󺹱� �ǵ��� (�ߺ��Ǵ� �� �� �������ϱ� ������)
				i--; 
				sw = 1;
			}
		}// for 

		if(sw == 0){
			JOptionPane.showMessageDialog(this, "������ �̸��� �����ϴ�.");
		}
	}// delete()


	public static void main(String[] args) {
		new JTableEx2();
	}
}

/*

�� && ��  �� && ����  ���� && ��  ����&&���� 
                   �̹� �����̸�, �ڿ� ���� ������ ���� �ʴ´�
�� || ��  �� || ����   ���� || ��   ���� || ���� 

id == null || id.length() == 0
id�� �̹� null�̸� �ڿ� ���� ������ �ʴ´�. 

*/
