import java.awt.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RunRace extends Frame{
	private Button btn; 
	private DrCanvas can;
	private Image horse;
	private int height = 10;

	public RunRace(String[] args){
		super("�� ����"); // �θ������(frame��) �θ� 
		setBounds(700, 200, 600, 400);
		setVisible(true);
		setResizable(false);

	
		
		// �� ������ŭ Panel ���� 
		// Panel���� Racer �ִ´�. 
		Panel p1 = new Panel();
		p1.add(new Racer());
		this.add(p1);

		Panel p2 = new Panel();
		p2.add(new Racer());
		this.add(p2);
		
		Panel p3 = new Panel();
		p3.add(new Racer());
		this.add(p3);


		// �̹��� �߰� 
		horse = Toolkit.getDefaultToolkit().getImage("horse.gif");
		// ĵ���� ����
		can = new DrCanvas();
		
		// ��� ��ư
		Panel btnP = new Panel();
		Button btn = new Button("���");
		btn.setPreferredSize(new Dimension(30, 20));
		btnP.add(btn);
		this.add(btn);


		// ������ �ݱ� 
		this.addWindowListener(new WindowAdapter(){
		@Override 
		public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});

	}

	
	@Override
	public void paint(Graphics g){
		g.drawImage(horse, 25, height, this);

			
	}


		
	public static void main(String[] args){
		if(args.length < 2){
			System.out.println("Usage : java RunRce count name1, .. ");
			System.exit(0); // �ּ� 3���� �־�� ���̽� ���� 
		}

		if(Integer.parseInt(args[0]) != args.length-1){
			System.out.println("�� �������� �̸��� ������ ���� �ʽ��ϴ�.");
			System.exit(0); // ���� ������ ���� ������ �´��� Ȯ�� 
		}

		new RunRace(args);
	}
}
