
import java.awt.Panel;
import java.awt.Frame;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Color;


class Calculator extends Frame {
	private Label dispL, inputL; // ���� ���̴� ��, ��� �� 
	private Button[] button; // ��ư 18�� 
	
	public Calculator(){
	// ��ư 
	Button[] btn = new Button[18];
	
	String[] str = new String[]{"��", "C", 
					"7", "8", "9", "/",
					"4", "5", "6", "*",
					"1", "2", "3", "-",
					".", "0", "=", "+"}; // ��ư text �� �迭�� ���� 
	
		// ��ư ���� 
		for(int i = 0; i < 18; i++){
			btn[i] = new Button(); 
		}

		for(int i = 0; i < str.length; i ++){
			btn[i] = new Button(str[i]);
		}
		

		
		// ȭ�� ���� 
		setTitle("�̴� ����");
		setBounds(900, 200, 300, 400); // x, y��ǥ �߰�
		
		
		// �� ����� ��
		// dispL
		dispL = new Label("����");
		dispL.setBackground(Color.PINK); //Label ��ü�� ������ ����
	

		// inputL
		inputL = new Label("�����");
		inputL.setBackground(Color.PINK);//Label ��ü�� ������ ����
		
		

		// �г� ����� �� �� ���� (7���� panel�� ��ü panel �Ѱ� )
	
		
		
		// ��� ���� �г� 
		Panel p1 = new Panel(); // ù��°
		p1.setLayout(new GridLayout(1, 1, 5, 5)); 
		p1.add(dispL);
		
		// ��� ��� �г�
		Panel p2 = new Panel(); // �ι�°
		p2.setLayout(new GridLayout(1, 0, 5, 5)); 
		p2.add(inputL);

		// �ڷ�, c �г�
		Panel p3 = new Panel(); // ����° 
		p3.setLayout(new GridLayout(1, 2, 5, 5)); 
		p3.add(btn[0]);
		p3.add(btn[1]);
		//p3.add("Center", p3);

		Panel p4 = new Panel(); // �׹�° 
		p4.setLayout(new GridLayout(1, 4, 5, 5));
		p4.add(btn[2]);
		p4.add(btn[3]);
		p4.add(btn[4]);
		p4.add(btn[5]);
		//p4.add("South", p4);

		Panel p5 = new Panel(); // �ټ���° 
		p5.setLayout(new GridLayout(1, 4, 5, 5)); 
		p5.add(btn[6]);
		p5.add(btn[7]);
		p5.add(btn[8]);
		p5.add(btn[9]);
		//p5.add("South", p5);

		Panel p6 = new Panel(); // ������° 
		p6.setLayout(new GridLayout(1, 4, 5, 5));
		p6.add(btn[10]);
		p6.add(btn[11]);
		p6.add(btn[12]);
		p6.add(btn[13]);
		//p6.add("South", p6);


		Panel p7 = new Panel(); // �ϰ���° 
		p7.setLayout(new GridLayout(1, 4, 5, 5));
		p7.add(btn[14]);
		p7.add(btn[15]);
		p7.add(btn[16]);
		p7.add(btn[17]);
		//p7.add("South", p7);
		
		// p�� ��� �г� �߰�
		Panel p = new Panel(); // ��ü�г� 
		p.setLayout(new GridLayout(7, 4, 2, 5)); 
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p7);
		
		add("Center", p); // frame�� p �߰� 
		setVisible(true);	
	
			
	}

	public static void main(String[] args) {
		Calculator c = new Calculator(); 
		
	}
}
