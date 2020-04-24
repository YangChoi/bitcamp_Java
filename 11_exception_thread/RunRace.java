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
		// 밑에서 입력받은 args 값을 여기서 받는다. 

		super("말 경주"); // 부모생성자(frame의) 부름 
		btn = new Button(" 출발 ");
		setBounds(700, 200, 600, 400);
		setVisible(true);
		setResizable(false);

		// 말 갯수 세기 
		// String 값을 int 값으로 바꿈 
		count = Integer.parseInt(args[0]);

	
		// 말 갯수만큼 Panel 생성 
		// 그리드로 잡아 들어오는 말 수 대로 칸을 나눈다. (행, 열)
		Panel p = new Panel(new GridLayout(count, 1));
		// panel에 말이 한마리씩 들어간다. 
		// args[i]를 통해 입력받은 이름의 값을 넘겨준다.
		racer = new Racer[count];
		for(int i = 0; i < racer.length; i++){
			racer[i] = new Racer(args[i+1]);
			// 배열은 0부터 시작하지만, p.add(p)는 1부터 시작하므로 
			p.add(racer[i]);
			//racer[i].setBackground(new Color((int)(Math.random()*200), 200, 255)); 
		}// for
		
		
		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT)); // 버튼 들어갈 패널 
		// 패널에서는 정렬이 안되므로 LAYOUT 설정해서 오른 정렬 해줘야한다. 
		p2.add(btn);
		
		add("Center", p); // panel을 센터로 넣는다.
		add("South", p2); // 버튼 패널은 밑으로 넣는다. 

		


		// 윈도우 닫기 
		this.addWindowListener(new WindowAdapter(){
		@Override 
		public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});

		// 버튼 이벤트
		btn.addActionListener(this);
		
	} // RunRace()
	
	@Override
	public void actionPerformed(ActionEvent e){
		btn.setEnabled(false); // 버튼이 딱 한번만 눌리도록 

		// 들어오는 말따라 쓰레드 생성해야하므로 배열로 
		Thread[] t = new Thread[count];
		
		// racer가 thread가 되고 싶은 상태 
		for(int i =0; i < count; i++){
			// 스레드 생성 
			t[i] = new Thread(racer[i]);
			t[i].setPriority((int)(Math.random()*10)+1); // 랜덤하게 우선순위 부여 
			// 스레드 시작 - 실행 run()
			t[i].start();
			
		}

	}



		
	public static void main(String[] args){
		if(args.length < 2){
			System.out.println("Usage : java RunRce count name1, .. ");
			System.exit(0); // 2개 이하면 실행 못함 
		}

		if(Integer.parseInt(args[0]) != args.length-1){
			System.out.println("말 마리수와 이름의 개수가 맞지 않습니다.");
			System.exit(0); // 말의 갯수와 들어온 데이터 맞는지 확인 
		}

		new RunRace(args);
	}
}
