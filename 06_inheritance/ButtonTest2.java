import java.awt.Button;
import java.awt.Frame;

class ButtonTest2 extends Frame {
	private Button newB, exitB;


	public void init(){ // init 이니셜의 약자
		newB = new Button("새로만들기");
		exitB = new Button("종료");
		
		newB.setBounds(50, 100, 90, 50); // 가로위치, 세로위치, 가로크기, 세로크기
		this.add(newB);

		exitB.setBounds(200, 250, 90, 50); // 가로위치, 세로위치, 가로크기, 세로크기
		add(exitB);

		setLayout(null); // 레이아웃을 깨버림 그래서 아무곳에나 배치가능

		setBounds(700,200,300,400); // 가로위치, 세로위치, 가로크기, 세로크기		
		setVisible(true); // 윈도우 창을 보여줘라
	}

	public static void main(String[] args) {
		//ButtonTest2 bt = new ButtonTest2(); 
		//bt.init();
		// 위에꺼를 아래로 바꿀수 있음 그대신 일회성임!
		new ButtonTest2().init(); 
		// 1. 클래스 불러라
		// 2. 생성자 불러라
		// 3. init 불러라
	}
}


// 라벨은 흰색
// 패널 8개를써서 센터에 박음
// 계산기 크기는 마음대로