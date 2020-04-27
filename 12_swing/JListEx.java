import java.util.*;
import javax.swing.*;
import java.awt.FlowLayout;

class JListEx extends JFrame {

	public JListEx(){
		super("JList test");
		setLayout(new FlowLayout());
		String[] listData = {"Yang", "Choi", "Park", "Kim", "Kang"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1);
		
		//JList list2 = new JList(new DefaultListModel());
		//DefaultListModel model = (DefaultListModel)list2.getModel();

		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list2 = new JList<String>(model);
		model.addElement("사과");
		model.addElement("딸기");
		model.addElement("배");
		model.addElement("포도");
		list2.setSelectedIndex(1);

		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("축구");
		vListData.add("배구");
		vListData.add("야구");
		vListData.add("테니스");
		vListData.add("피겨 스케이트");
		vListData.add("농구");
		vListData.add("유도");
		vListData.add("태권도");
		vListData.add("수영");
		

		class Student{
			String id; 
			String name; 
			String department;

			public Student(String id, String name, String department){
				this.id = id; 
				this.name = name; 
				this.department = department;
			}

			public String toString(){
				return name;
			}
		} // student class
		
	JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
	list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
	model2.addElement(new Student("100", "양아무개", "경영과"));
	model2.addElement(new Student("200", "김아무개", "컴공과"));
	model2.addElement(new Student("300", "최아무개", "건축과"));
	model2.addElement(new Student("400", "박아무개", "디자인과"));
	list4.setSelectedIndex(1);

	add(list1);
	add(list2);
	add(scroll);
	add(list4);
	

	setBounds(300, 200, 300, 200);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}

	public static void main(String[] args) {
		new JListEx();
	}
}
