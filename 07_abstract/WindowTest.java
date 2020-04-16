import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class WindowTest extends Frame{
	public void init(){
		setBounds(700, 100, 850, 600); // x��, y��, ����, ����
		setVisible(true);

	}

	@Override
	public void paint(Graphics g){
		// setVisible�� �ݹ� �޼ҵ� paint
		// setVisible�� ������ �ڵ����� �θ� �� �ִ� �޼ҵ� 

		// �����ӿ� �̹��� �ֱ� 
		// 1. �̹��� �ҷ����� 
		// 2. �̹��� �׸��� 
		Toolkit t = Toolkit.getDefaultToolkit();
		// ���� new �ڽ� Ŭ�����ε� Toolkit�� �ڽ��� ��� 
		// �� ��� getDefaultToolkit() �޼ҵ带 ������
		//Image img = t.getImage("rabbit.png");
		// �̹����� ���� �ٸ� ������ �ִٸ�? 
		// �ڹٿ��� ����̺� ��θ� ǥ���Ҷ� �������� �ϳ��� ������ �ȵȴ�. (\n, \t�� �ֱ� ����)
		// �������� �ΰ� ����. (C�� java�� �׷���)
		// �׷��� �ΰ� ��ſ� ������ �Ѱ� / �ᵵ �ȴ�(Java��)
		Image img = t.getImage("D:/java_se/workspace/07_abstract/rabbit.png");
		// ������, ����� ������ ���� 
		// �׸� �׸���
		//g.drawImage(img, 30, 100, this); // x��ǥ, y��ǥ, �׸��� ������(this)�׷���! : frame�� �� windowTest �װ��� this
		// �׷� windowTest�� �� �ȵ�? windowTest�� �޴����̴�. 
		// ������ ���� �ƴϴ�. 
		// ������ ���� Ŭ���� ������ ���� this�� ������ �ִ�. 
		// new�� �߱� ���� this�� �ּҰ��� ������ �ִ�. 

		//g.drawImage(img, 
		//			30, 300, 500, 300, // ȭ����ġ
		//			10, 10, 806 , 501, // �̹�����ġ
		//			this);

		// �Ųٷ� �ϱ� 
		//g.drawImage(img, 
		//			30, 100, 250, 300, // ȭ����ġ
		//			805, 601, 0 , 0, // �̹�����ġ
		//			this);

		// �¿� �ٲٱ� 
		g.drawImage(img, 
					30, 100, 700, 450, // ȭ����ġ
					805, 0, 0, 601, // �̹�����ġ
					this);

	}
	public static void main(String[] args) {
		new WindowTest().init();
	}
}
