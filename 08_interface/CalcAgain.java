import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CalcAgain extends Frame implements ActionListener{
	private Label dispL, inputL; // ���� ���̴� ��, ��� �� 
	private StringBuffer dispBuf, inputBuf; 
	private Button[] button; // ��ư 16�� 
	private Button backBtn, clearBtn; // ���� 2�� 
	
	public CalcAgain(){
	// ��ư 
	Button[] btn = new Button[16];

	
	String[] str = new String[]{"7", "8", "9", "/",
					"4", "5", "6", "*",
					"1", "2", "3", "-",
					".", "0", "=", "+"}; // ��ư text �� �迭�� ���� 
	
	
		
		// ��ư ���� 
		for(int i = 0; i < 16; i++){
			btn[i] = new Button(); 
		}
		
		for(int i = 0; i < str.length; i++){
			btn[i] = new Button(str[i]);
			btn[i].setFont(new Font("Serif", Font.BOLD, 25)); // ��ư ��Ʈ ��Ÿ�� 
		}
		
		backBtn = new Button("��");
		clearBtn = new Button("C");
		backBtn.setFont(new Font("Serif", Font.BOLD, 25));
		clearBtn.setFont(new Font("Serif", Font.BOLD, 25));

		// ȭ�� ���� 
		setTitle("�̴� ����");
		setBounds(900, 200, 300, 400); // x, y��ǥ �߰�
		setResizable(false);
		
		// �� ����� ��
		// dispL
		dispL = new Label("", Label.RIGHT);
		dispL.setBackground(new Color(200, 191, 231)); // Label ��ü�� ������ ����
		dispL.setFont(new Font("Serif", Font.BOLD, 25));
		

		// inputL
		inputL = new Label("0", Label.RIGHT); // ���� 0 �ȵ�. ���۳�Ʈ�� �� ���ڿ��� �Է� ���� 
		inputL.setBackground(new Color(200, 191, 231));//Label ��ü�� ������ ����
		inputL.setFont(new Font("Serif", Font.BOLD, 25));

		// �г� ����� �� �� ���� (7���� panel�� ��ü panel �Ѱ� )
	
		// setBounds(x y w h) 
		
		// ��� ���� �г� 
		Panel p1 = new Panel(); // ù��°
		p1.setLayout(new GridLayout(1, 1, 5, 5)); 
		p1.add(dispL);
		dispBuf = new StringBuffer();
		
		// ��� ��� �г�
		Panel p2 = new Panel(); // �ι�°
		p2.setLayout(new GridLayout(1, 0, 5, 5)); 
		p2.add(inputL);
		inputBuf = new StringBuffer("0");

		// �ڷ�, c �г�
		Panel p3 = new Panel(); // ����° 
		p3.setLayout(new GridLayout(1, 2, 5, 5)); 
		p3.add(backBtn);
		p3.add(clearBtn);
		//p3.add("Center", p3);

		Panel p4 = new Panel(); // �׹�° 
		p4.setLayout(new GridLayout(1, 4, 5, 5));
		p4.add(btn[0]);
		p4.add(btn[1]);
		p4.add(btn[2]);
		p4.add(btn[3]);
		//p4.add("South", p4);

		Panel p5 = new Panel(); // �ټ���° 
		p5.setLayout(new GridLayout(1, 4, 5, 5)); 
		p5.add(btn[4]);
		p5.add(btn[5]);
		p5.add(btn[6]);
		p5.add(btn[7]);
		//p5.add("South", p5);

		Panel p6 = new Panel(); // ������° 
		p6.setLayout(new GridLayout(1, 4, 5, 5));
		p6.add(btn[8]);
		p6.add(btn[9]);
		p6.add(btn[10]);
		p6.add(btn[11]);
		//p6.add("South", p6);


		Panel p7 = new Panel(); // �ϰ���° 
		p7.setLayout(new GridLayout(1, 4, 5, 5));
		p7.add(btn[12]);
		p7.add(btn[13]);
		p7.add(btn[14]);
		p7.add(btn[15]);
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
		
		// ��ư Ȱ��ȭ 
		for(int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);
		}
		backBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		

		// �̺�Ʈ �߻� 
		// windowListener implements ��ſ� WindowAdapter�� �ҷ��´� 
		this.addWindowListener(new WindowAdapter(){
			//Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});
		
}
	
	// ActionListener Override
	public void actionPerformed(ActionEvent e) {
		String push = e.getActionCommand();
		if( push == "1" ||
			push == "2" ||
			push == "3" ||
			push == "4" ||
			push == "5" ||
			push == "6" ||
			push == "7" ||
			push == "8" ||
			push == "9" ||
			push == "0"){
			
			if(inputBuf.length() == 1 && inputBuf.toString().equals("0")){ // 0�� �ϳ��� ���� �� 0�� ����� ���ο� �Է��� ��Ÿ�����ϹǷ� 
				// 01 �̷������� �Ǹ� �ȵǰ� 1 �̷��� �����ϴϱ�. 
				inputBuf.delete(0,1);
				// �⺻ ���� �� 0�� ����� ����. 
				// 0���� 1���� ���� ������ index 0���� �������ϹǷ� (0,1)
				// 0�� ����� �� �ְ� ����� �� �ִ� ���°� �Ǳ� ������ 0�� 2���� �ȳ־�����. 
			}
			inputBuf.append(push); // �Է��� ��ȣ�� ���� �� �߰� 
			inputL.setText(inputBuf+""); // �����ش� 	

		}else if(push == "��"){
			// ���� ���� �Է��� ���� ���� �������Ѵ�. 
			//inputBuf.delete(2, 3);
			// 487 : 2����ġ���� 3�� �������� ��������. 
			inputBuf.delete(inputBuf.length()-1 ,inputBuf.length());
			// �󺧿��� �˷��� 
			if(inputBuf.length() == 0){
				inputBuf.append("0"); // �ƹ��͵� ���� �� 0�� ������ �Ѵ� 
			}
			inputL.setText(inputBuf+"");

		}else if(push == "C"){
			dispBuf.delete(0, dispBuf.length()); // ������ ���ڷ� ������ ������ (�ε����� 0��������)
			inputBuf.delete(0, inputBuf.length()); // �� �����ֱ� All clear
			inputBuf.append("0"); // ���ۿ� 0 �ְ� ���� 

			dispL.setText(""); //����ְ� 
			inputL.setText("0"); // �⺻�� 0 �ֱ� 
		}else if(push == "."){

			if(inputBuf.indexOf(".") == -1){
				// -1 : ���� ����. 
				inputBuf.append(".");
			}
			inputL.setText(inputBuf + ""); //inputBuf�� ������ �����ֱ� 
			// ���� .�� �ִٸ� (-1) �� �ƴϸ� if���� ���ͼ� �ٷ� �󺧿� �����ش�. 
		}else if(push == "+"){
			if(inputBuf.length() == 0){
				// �ƹ��͵� �Էµ��� �ʾҴٸ�	
				inputL.setText(inputBuf+""); // �ƹ��͵� ����
			}else {
				dispBuf.append(inputBuf);

				dispL.append(inputBuf+""); //inputBuf ���� �޴´�. 
				
			}
			 
		}else if(push == "-"){
		}else if(push == "*"){
		}else if(push == "/"){
		}else if(push == "="){
		}

	}
	

	


	public static void main(String[] args) {
		CalcAgain c = new CalcAgain(); 
		
	}
}

/*(�󺧵��� �����ִ� ����)
dispL > dispBuf
inputL > inputBuf : �����Ͱ� ���� "1111" ���̰� ���� �� inputL�� ������ ���� >> "0" (���ݻ���)
*/