import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

// 이 파일은 컴파일 안해도 된다. 
// RunRace하면 알아서 컴파일 된다. 
class Racer extends Canvas implements Runnable { // 말 1마리 
	// 캔버스는 레이아웃이 없음 아무것도 없는 상태 
	private String name; 
	private Image img;
	private int pos;
	private static int rank;

	public Racer(String name){
		this.name = name;
		//img = new Toolkit(); // 추상클래스이므로 new 안됨 
		img = Toolkit.getDefaultToolkit().getImage("horse.gif"); 
	}

	@Override
	public void paint(Graphics g){
		g.drawImage(img, pos, 0, 25, this.getSize().height, this); // 0, 0 위치에다 그린다. (x좌표, y좌표, 너비, 높이)
		// getSize()로 캔버스의 너비 높이를 가져온다.
		// 너비는 말이 뛰어야하므로 25로 고정한다. 
		// pos 값이 고정되면 안된다. 말이 전진해야하기 때문
	}

	@Override
	public void run(){
		// 입력되는 말들에게 각자 for문이 돈다. 
		for(int i = 0; i <= 600; i+=(int)(Math.random()*10)+1){
			// 말이 창 크기 만큼 뛴다. 
			// 그런데 i++을 하면 너무 조금씩 움직인다. 
			// 그렇다고 i+10을 해주면 말이 균등하게 움직이므로 안된다 
			// 따라서 랜덤값을 주고 그 값에 따라 증가되게 한다. 
			pos = i; // i의 값을 pos에게 전달한다. 
			repaint();

			// 말 속도 늦춤
				try{ 
					Thread.sleep(100); // cpu를 대기 상태로 
					// 너무 빨라서 글자가 보이지 않으므로 
					// 기본 1/1000초
				}catch(InterruptedException e){
					e.printStackTrace();
			}
		}// for 문
		
		// 등수 
		// 위의 for문을 빠져나오면 바로 등수 매기기 된다. 
		rank++; // 누가 나왔는지 모르므로 일단 rank를 ++
		System.out.println(rank + "등   " + name); 
		// 그런세 스레드로 인해 각자 racer가 입력한 대로 각자 나오게 된다. 
		// 그에 따라 rank도 마찬가지. 
		// 그래서 전부 1등으로 나온다. 
		// rank는 딱 하나 잡혀야한다. 따라서 static을 잡는다 
		// static 잡으면 메모리에 딱 한번만 잡힌다. 
	}


}
