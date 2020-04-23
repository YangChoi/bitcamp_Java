import java.awt.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RunRace extends Frame{
	private Button btn; 
	private DrCanvas can;
	private Image horse;
	private int height = 10;

	public RunRace(String[] args){
		super("말 경주"); // 부모생성자(frame의) 부름 
		setBounds(700, 200, 600, 400);
		setVisible(true);
		setResizable(false);

	
		
		// 말 갯수만큼 Panel 생성 
		// Panel에는 Racer 넣는다. 
		Panel p1 = new Panel();
		p1.add(new Racer());
		this.add(p1);

		Panel p2 = new Panel();
		p2.add(new Racer());
		this.add(p2);
		
		Panel p3 = new Panel();
		p3.add(new Racer());
		this.add(p3);


		// 이미지 추가 
		horse = Toolkit.getDefaultToolkit().getImage("horse.gif");
		// 캔버스 생성
		can = new DrCanvas();
		
		// 출발 버튼
		Panel btnP = new Panel();
		Button btn = new Button("출발");
		btn.setPreferredSize(new Dimension(30, 20));
		btnP.add(btn);
		this.add(btn);


		// 윈도우 닫기 
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
			System.exit(0); // 최소 3개는 있어야 레이스 시작 
		}

		if(Integer.parseInt(args[0]) != args.length-1){
			System.out.println("말 마리수와 이름의 개수가 맞지 않습니다.");
			System.exit(0); // 말의 갯수와 들어온 데이터 맞는지 확인 
		}

		new RunRace(args);
	}
}
