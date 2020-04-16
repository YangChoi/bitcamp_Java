import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class WindowTest extends Frame{
	public void init(){
		setBounds(700, 100, 850, 600); // x축, y축, 가로, 세로
		setVisible(true);

	}

	@Override
	public void paint(Graphics g){
		// setVisible의 콜백 메소드 paint
		// setVisible이 있으면 자동으로 부를 수 있는 메소드 

		// 프레임에 이미지 넣기 
		// 1. 이미지 불러오기 
		// 2. 이미지 그리기 
		Toolkit t = Toolkit.getDefaultToolkit();
		// 원래 new 자식 클래스인데 Toolkit은 자식이 없어서 
		// 그 대신 getDefaultToolkit() 메소드를 가져옴
		//Image img = t.getImage("rabbit.png");
		// 이미지가 만약 다른 폴더에 있다면? 
		// 자바에선 드라이브 경로를 표시할때 역슬래쉬 하나면 있으면 안된다. (\n, \t가 있기 때문)
		// 역슬래쉬 두개 쓴다. (C와 java가 그렇다)
		// 그런데 두개 대신에 슬래쉬 한개 / 써도 된다(Java만)
		Image img = t.getImage("D:/java_se/workspace/07_abstract/rabbit.png");
		// 절대경로, 상대경로 간단히 정리 
		// 그림 그리기
		//g.drawImage(img, 30, 100, this); // x좌표, y좌표, 그리고 나한테(this)그려라! : frame은 곧 windowTest 그것은 this
		// 그럼 windowTest는 왜 안돼? windowTest는 메뉴판이다. 
		// 생성된 값이 아니다. 
		// 생성된 값은 클래스 생성에 따라 this에 가지고 있다. 
		// new를 했기 땜에 this가 주소값을 가지고 있다. 

		//g.drawImage(img, 
		//			30, 300, 500, 300, // 화면위치
		//			10, 10, 806 , 501, // 이미지위치
		//			this);

		// 거꾸로 하기 
		//g.drawImage(img, 
		//			30, 100, 250, 300, // 화면위치
		//			805, 601, 0 , 0, // 이미지위치
		//			this);

		// 좌우 바꾸기 
		g.drawImage(img, 
					30, 100, 700, 450, // 화면위치
					805, 0, 0, 601, // 이미지위치
					this);

	}
	public static void main(String[] args) {
		new WindowTest().init();
	}
}
