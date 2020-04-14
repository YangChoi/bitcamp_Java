import java.awt.Panel;
import java.awt.Frame;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;

class Calculator extends Frame {
	private Label dispL, inputL; // ���� ���̴� ��, ��� �� 
	private Button[] button; // ��ư 18�� 
	
public void init(){
	String[] input = {"��", "C", 
					"7", "8", "9", "/",
					"4", "5", "6", "*",
					"1", "2", "3", "-",
					".", "0", "=", "+"}; // ��ư text �� �迭�� ���� 
	
	// ��ư ���� 
	Button[] button = new Button[input.length];
	

		
		// ������ �����
		Frame f = new Frame();
		//������ ����
		f.setTitle("�̴� ����");
		f.setBounds(900, 200, 300, 400); // x, y��ǥ �߰�
		f.setVisible(true);
	
		
		// �� ����� ��
		// dispL
		Label label = new Label();
		label.setText(" "); // ���� �ؽ�Ʈ��
		label.setAlignment(Label.RIGHT); // ����
		label.setBackground(Color.cyan); //Label ��ü�� ������ ����
		add(label);

		// inputL
		Label label2 = new Label();
		label2.setText("0");
		label2.setAlignment(Label.RIGHT); // ����
		label2.setBackground(Color.cyan);//Label ��ü�� ������ ����
		add(label2);
		

		// �г� ����� �� �� ���� (7���� panel�� ��ü panel �Ѱ� )
		Panel p = new Panel(); // ��ü�г� 
		p.setLayout(null);	

		
		// ��� ���� �г� 
		Panel p1 = new Panel(); // ù��°
		p1.setLayout(new GridLayout(1, 1, 5, 0)); 
		p1.add(dispL);
		
		// ��� ��� �г�
		Panel p2 = new Panel(); // �ι�°
		p2.setLayout(new GridLayout(1, 0, 5, 0)); 
		p2.add(inputL);

		// �ڷ�, c �г�
		Panel p3 = new Panel(); // ����° 
		p3.setLayout(new GridLayout(1, 2, 5, 10)); 
		p3.add(button[0]);
		p3.add(button[1]);
		add("Center", p3);

		Panel p4 = new Panel(); // �׹�° 
		p4.setLayout(new GridLayout(1, 4, 5, 10));
		p4.add(button[2]);
		p4.add(button[3]);
		p4.add(button[4]);
		p4.add(button[5]);
		add("South", p4);

		Panel p5 = new Panel(); // �ټ���° 
		p5.setLayout(new GridLayout(1, 4, 5, 10)); 
		p5.add(button[6]);
		p5.add(button[7]);
		p5.add(button[8]);
		p5.add(button[9]);
		add("South", p5);

		Panel p6 = new Panel(); // ������° 
		p6.setLayout(new GridLayout(1, 4, 5, 10));
		p6.add(button[10]);
		p6.add(button[11]);
		p6.add(button[12]);
		p6.add(button[13]);
		add("South", p6);


		Panel p7 = new Panel(); // �ϰ���° 
		p7.setLayout(new GridLayout(1, 4, 5, 10));
		p7.add(button[14]);
		p7.add(button[15]);
		p7.add(button[16]);
		p7.add(button[17]);
		add("South", p7);
		
		// p�� ��� �г� �߰�
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p7);
		
		f.add(p); // frame�� p �߰� 
			
		setVisible(true);
	}


	public static void main(String[] args) {
		Calculator c = new Calculator(); 
		c.init();
	}
}
