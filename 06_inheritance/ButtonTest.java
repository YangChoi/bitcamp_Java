import java.awt.Panel;
import java.awt.Frame;
import java.awt.Button;
import java.awt.GridLayout;


class ButtonTest extends Frame{
	private Button northB = null; 
	private Button newB, exitB; 
	
	public void init(){
		northB = new Button("북쪽");
		newB = new Button("새로만들기");
		exitB = new Button("종료");

		Panel p = new Panel(); // FlowLayout
		// 한번쓰고 버릴 것이기 때문에 필드말고 여기에다 선언
		// 순서대로 배치됨 : FlowLayout(중앙 위치)
		p.setLayout(new GridLayout(1, 2, 5, 0)); // new GridLayout(행, 열, 가로여백, 세로여백)

		p.add(newB);
		p.add(exitB);
		
		this.add("North", northB);
		// this는 buttonTest, 이는 곧 Frame(생략가능)
		add("South", p);
		// panel에다 버튼을 넣었기 때문에 여기는 해당하는 p를 넣음
		add("South", p);
		
		setBounds(900, 200, 300, 400); // x, y좌표 추가 
		setVisible(true); // 보여달라 
	}

	public static void main(String[] args) {
		ButtonTest bt = new ButtonTest();
		// 클래스 생성 > 생성자 콜
		bt.init();
		// init 실행 
	}
}

/*
*Layout
-Frame : BorderLayout(동, 서, 남, 북)
-Panel : FlowLayout(순서배치 - 중앙)
- GridLayout(행렬배치)
*/