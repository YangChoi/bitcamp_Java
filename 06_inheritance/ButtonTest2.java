import java.awt.Button;
import java.awt.Frame;

class ButtonTest2 extends Frame {
	private Button newB, exitB;


	public void init(){ // init �̴ϼ��� ����
		newB = new Button("���θ����");
		exitB = new Button("����");
		
		newB.setBounds(50, 100, 90, 50); // ������ġ, ������ġ, ����ũ��, ����ũ��
		this.add(newB);

		exitB.setBounds(200, 250, 90, 50); // ������ġ, ������ġ, ����ũ��, ����ũ��
		add(exitB);

		setLayout(null); // ���̾ƿ��� ������ �׷��� �ƹ������� ��ġ����

		setBounds(700,200,300,400); // ������ġ, ������ġ, ����ũ��, ����ũ��		
		setVisible(true); // ������ â�� �������
	}

	public static void main(String[] args) {
		//ButtonTest2 bt = new ButtonTest2(); 
		//bt.init();
		// �������� �Ʒ��� �ٲܼ� ���� �״�� ��ȸ����!
		new ButtonTest2().init(); 
		// 1. Ŭ���� �ҷ���
		// 2. ������ �ҷ���
		// 3. init �ҷ���
	}
}


// ���� ���
// �г� 8�����Ἥ ���Ϳ� ����
// ���� ũ��� �������