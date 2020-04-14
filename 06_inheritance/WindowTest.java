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
	
	// �⺻������ 
	public WindowTest(){
		// new Frame("���� ���� ������").setVisible(true); // new���ָ� ���ο� ��ü�� ����� ���� : â�� �ΰ� ��� 
		// �θ������ ȣ�� 
		//super("���� ���� ������"); // �θ�Ŭ���� ȣ��
		setTitle("���� ���� ������");

		System.out.println("����"); // �ܼ� ���
			
			
		setBackground(new Color(96, 132, 86));
		// ���� 32��Ʈ�� ǥ������(4����Ʈ) 
		// ���� 3��� - ��, ��, �� 
		// R, G, B 1byte(8bit) -128 ~ 127, 0~ 255
		// 
		// R			G			B
		// 1byte		1byte		1byte
		// 0			0			0	>> ������
		// 255			255			255 >> ���
		// 


		setForeground(new Color(255, 255, 0)); // ���ڻ� 
		//setBackground(Color.MAGENTA); // ������ ������ 
		setBounds(700 , 200, 300, 400); // x, y��ǥ �߰� 
		//setSize(300, 400); // width, height
		setVisible(true); // �����޶� 
	}
	@Override
	public void paint(Graphics g){ // ������ �ȿ� �׷��ش�
		g.drawString("�ȳ�!", 100, 80); 
		g.drawLine(250, 100, 80, 300); // ���߱� 
		g.drawRect(150, 150, 100, 100); // x��ǥ, y��ǥ, �ʺ�, ���� 
		g.drawOval(200, 200, 100, 100);
		
	} // Call back �޼ҵ� 
	// JVM�� �ҷ��� �޼ҵ� (�׷��� ���� �ҷ����� �ʾƵ� �����̵ȴ�)
	// setVisible�� ����Ǹ鼭 paint�� �θ���. 
	

	public static void main(String[] args){
		// new WindowTest() : ��ȸ�� 
		WindowTest wt = new WindowTest();
		
	}

}

/*
�ܼ� : System		������ â 
System.out.			paint
*/