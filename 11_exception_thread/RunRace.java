import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RunRace extends Frame implements ActionListener{
	private Button btn; 
	private DrCanvas can;
	private int count; 
	private Racer[] racer; 
	public RunRace(String[] args){
		// �ؿ��� �Է¹��� args ���� ���⼭ �޴´�. 

		super("�� ����"); // �θ������(frame��) �θ� 
		btn = new Button(" ��� ");
		setBounds(700, 200, 600, 400);
		setVisible(true);
		setResizable(false);

		// �� ���� ���� 
		// String ���� int ������ �ٲ� 
		count = Integer.parseInt(args[0]);

	
		// �� ������ŭ Panel ���� 
		// �׸���� ��� ������ �� �� ��� ĭ�� ������. (��, ��)
		Panel p = new Panel(new GridLayout(count, 1));
		// panel�� ���� �Ѹ����� ����. 
		// args[i]�� ���� �Է¹��� �̸��� ���� �Ѱ��ش�.
		racer = new Racer[count];
		for(int i = 0; i < racer.length; i++){
			racer[i] = new Racer(args[i+1]);
			// �迭�� 0���� ����������, p.add(p)�� 1���� �����ϹǷ� 
			p.add(racer[i]);
			//racer[i].setBackground(new Color((int)(Math.random()*200), 200, 255)); 
		}// for
		
		
		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT)); // ��ư �� �г� 
		// �гο����� ������ �ȵǹǷ� LAYOUT �����ؼ� ���� ���� ������Ѵ�. 
		p2.add(btn);
		
		add("Center", p); // panel�� ���ͷ� �ִ´�.
		add("South", p2); // ��ư �г��� ������ �ִ´�. 

		


		// ������ �ݱ� 
		this.addWindowListener(new WindowAdapter(){
		@Override 
		public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});

		// ��ư �̺�Ʈ
		btn.addActionListener(this);
		
	} // RunRace()
	
	@Override
	public void actionPerformed(ActionEvent e){
		btn.setEnabled(false); // ��ư�� �� �ѹ��� �������� 

		// ������ ������ ������ �����ؾ��ϹǷ� �迭�� 
		Thread[] t = new Thread[count];
		
		// racer�� thread�� �ǰ� ���� ���� 
		for(int i =0; i < count; i++){
			// ������ ���� 
			t[i] = new Thread(racer[i]);
			t[i].setPriority((int)(Math.random()*10)+1); // �����ϰ� �켱���� �ο� 
			// ������ ���� - ���� run()
			t[i].start();
			
		}

	}



		
	public static void main(String[] args){
		if(args.length < 2){
			System.out.println("Usage : java RunRce count name1, .. ");
			System.exit(0); // 2�� ���ϸ� ���� ���� 
		}

		if(Integer.parseInt(args[0]) != args.length-1){
			System.out.println("�� �������� �̸��� ������ ���� �ʽ��ϴ�.");
			System.exit(0); // ���� ������ ���� ������ �´��� Ȯ�� 
		}

		new RunRace(args);
	}
}
