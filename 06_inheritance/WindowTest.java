import java.awt.Frame;
import java.awt.Color;
import java.awt.Graphics;

class WindowTest extends Frame {
	// WindowTest is a Frame
	/*
		java.lang.Object
		java.awt.Component`
		java.awt.Container
		java.awt.Window
		java.awt.Frame
		WindowTest
	
	*/
	
	// 기본생성자 
	public WindowTest(){
		// new Frame("내가 만든 윈도우").setVisible(true); // new해주면 새로운 객체가 만들어 진것 : 창이 두개 뜬다 
		// 부모생성자 호출 
		//super("내가 만든 윈도우"); // 부모클래스 호출
		setTitle("내가 만든 윈도우");

		System.out.println("도형"); // 콘솔 출력
			
			
		setBackground(new Color(96, 132, 86));
		// 색은 32비트로 표현가능(4바이트) 
		// 빛의 3요소 - 빨, 초, 파 
		// R, G, B 1byte(8bit) -128 ~ 127, 0~ 255
		// 
		// R			G			B
		// 1byte		1byte		1byte
		// 0			0			0	>> 검정색
		// 255			255			255 >> 흰색
		// 


		setForeground(new Color(255, 255, 0)); // 글자색 
		//setBackground(Color.MAGENTA); // 윈도우 바탕색 
		setBounds(700 , 200, 300, 400); // x, y좌표 추가 
		//setSize(300, 400); // width, height
		setVisible(true); // 보여달라 
	}
	@Override
	public void paint(Graphics g){ // 프레임 안에 그려준다
		g.drawString("안녕!", 100, 80); 
		g.drawLine(250, 100, 80, 300); // 선긋기 
		g.drawRect(150, 150, 100, 100); // x좌표, y좌표, 너비, 높이 
		g.drawOval(200, 200, 100, 100);
		
	} // Call back 메소드 
	// JVM이 불러준 메소드 (그래서 따로 불러주지 않아도 구현이된다)
	// setVisible이 실행되면서 paint를 부른다. 
	

	public static void main(String[] args){
		// new WindowTest() : 일회성 
		WindowTest wt = new WindowTest();
		
	}

}

/*
콘솔 : System		윈도우 창 
System.out.			paint
*/