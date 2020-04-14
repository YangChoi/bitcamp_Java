import java.awt.Panel;
import java.awt.Frame;
import java.awt.Button;
import java.awt.GridLayout;


class ButtonTest extends Frame{
	private Button northB = null; 
	private Button newB, exitB; 
	
	public void init(){
		northB = new Button("����");
		newB = new Button("���θ����");
		exitB = new Button("����");

		Panel p = new Panel(); // FlowLayout
		// �ѹ����� ���� ���̱� ������ �ʵ帻�� ���⿡�� ����
		// ������� ��ġ�� : FlowLayout(�߾� ��ġ)
		p.setLayout(new GridLayout(1, 2, 5, 0)); // new GridLayout(��, ��, ���ο���, ���ο���)

		p.add(newB);
		p.add(exitB);
		
		this.add("North", northB);
		// this�� buttonTest, �̴� �� Frame(��������)
		add("South", p);
		// panel���� ��ư�� �־��� ������ ����� �ش��ϴ� p�� ����
		add("South", p);
		
		setBounds(900, 200, 300, 400); // x, y��ǥ �߰� 
		setVisible(true); // �����޶� 
	}

	public static void main(String[] args) {
		ButtonTest bt = new ButtonTest();
		// Ŭ���� ���� > ������ ��
		bt.init();
		// init ���� 
	}
}

/*
*Layout
-Frame : BorderLayout(��, ��, ��, ��)
-Panel : FlowLayout(������ġ - �߾�)
- GridLayout(��Ĺ�ġ)
*/