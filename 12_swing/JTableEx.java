import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class JTableModel extends AbstractTableModel { // javax.swing�� �߻�Ŭ���� 
	Obejct[][] data = {{"Nari", "��ƹ���", new Integer(1234), "����ģ��"},
						{"One", "��ƹ���", new Integer(1111), "����"} 
						{"Two", "�ھƹ���", new Integer(2222), "���"},
						{"Three", "�־ƹ���", new Integer(3333), "���Ƹ� ģ��"}};
	
	String[] name = {"���̵�", "�̸�", "��й�ȣ", "����"}; // �ʵ�� �� 

	public int getColumnCount(){ // ���̺��� ���� ��[�ʼ�]
		return name.length; // return 4; �� ����
	}

	public int getRowCount(){ // ���̺� ���� �� [�ʼ�]
		return data.length;
	}

	public Object getValueAt(int r, int c){ // ���� ������ ����[�ʼ�]
		return data[r][c]; 
	}
	
	public boolean isCellEditable(int r, int c){ // ���������ϰ� �Ѵ�. 
		return (c!=0) ? true : false; // � �ε����� ���� ���� ���ϰ� ���´�. 
	}

	public String getColumnName(int c){ // ���̺� Ÿ��Ʋ�� �ο�
		return name[c];
	}
	public void setValueAt(Object obj, int r, int c){ // �ʵ尪 ���� 
		data[r][c] = obj;
	}

}
public class JTableEx extends JFrame{
	JTable table;
	JTableModel model; // ����� ������ Ŭ���� 
	
	public JTableEx(){
		model = new JTableModel();
		table = new JTable(model);
		add(new JScrollPane(table)); // ��ũ�ѹ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JTableEx();
		
	}
}
