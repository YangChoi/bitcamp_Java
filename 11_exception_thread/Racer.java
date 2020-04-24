import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

// �� ������ ������ ���ص� �ȴ�. 
// RunRace�ϸ� �˾Ƽ� ������ �ȴ�. 
class Racer extends Canvas implements Runnable { // �� 1���� 
	// ĵ������ ���̾ƿ��� ���� �ƹ��͵� ���� ���� 
	private String name; 
	private Image img;
	private int pos;
	private static int rank;

	public Racer(String name){
		this.name = name;
		//img = new Toolkit(); // �߻�Ŭ�����̹Ƿ� new �ȵ� 
		img = Toolkit.getDefaultToolkit().getImage("horse.gif"); 
	}

	@Override
	public void paint(Graphics g){
		g.drawImage(img, pos, 0, 25, this.getSize().height, this); // 0, 0 ��ġ���� �׸���. (x��ǥ, y��ǥ, �ʺ�, ����)
		// getSize()�� ĵ������ �ʺ� ���̸� �����´�.
		// �ʺ�� ���� �پ���ϹǷ� 25�� �����Ѵ�. 
		// pos ���� �����Ǹ� �ȵȴ�. ���� �����ؾ��ϱ� ����
	}

	@Override
	public void run(){
		// �ԷµǴ� ���鿡�� ���� for���� ����. 
		for(int i = 0; i <= 600; i+=(int)(Math.random()*10)+1){
			// ���� â ũ�� ��ŭ �ڴ�. 
			// �׷��� i++�� �ϸ� �ʹ� ���ݾ� �����δ�. 
			// �׷��ٰ� i+10�� ���ָ� ���� �յ��ϰ� �����̹Ƿ� �ȵȴ� 
			// ���� �������� �ְ� �� ���� ���� �����ǰ� �Ѵ�. 
			pos = i; // i�� ���� pos���� �����Ѵ�. 
			repaint();

			// �� �ӵ� ����
				try{ 
					Thread.sleep(100); // cpu�� ��� ���·� 
					// �ʹ� ���� ���ڰ� ������ �����Ƿ� 
					// �⺻ 1/1000��
				}catch(InterruptedException e){
					e.printStackTrace();
			}
		}// for ��
		
		// ��� 
		// ���� for���� ���������� �ٷ� ��� �ű�� �ȴ�. 
		rank++; // ���� ���Դ��� �𸣹Ƿ� �ϴ� rank�� ++
		System.out.println(rank + "��   " + name); 
		// �׷��� ������� ���� ���� racer�� �Է��� ��� ���� ������ �ȴ�. 
		// �׿� ���� rank�� ��������. 
		// �׷��� ���� 1������ ���´�. 
		// rank�� �� �ϳ� �������Ѵ�. ���� static�� ��´� 
		// static ������ �޸𸮿� �� �ѹ��� ������. 
	}


}
