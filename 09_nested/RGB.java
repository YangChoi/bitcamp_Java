import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RGB extends Frame {
	private Button redBtn, greenBtn, blueBtn; 
	private DrCanvas canvas; 

	/*
	Panel - Component�� �����ִ� panel 
	TextArea
	Canvas - null
		   - �ݵ�� ��� �޾Ƽ� ����Ѵ� 
	*/
	public RGB(){
		redBtn = new Button("����");
		greenBtn = new Button("�ʷ�");
		blueBtn = new Button("�Ķ�");
		
		canvas = new DrCanvas(); // ĵ���� ���� 

		Panel p = new Panel(); // ��ư ������ panel (Component�� �����ִ� Panel) - FlowLayout:��� ���� 
		p.add(redBtn); //button�� new ������ ���� �� : �����Ͻÿ� ���������� ����� nullpointException �ɸ���. : new����� 
		p.add(greenBtn);
		p.add(blueBtn);

		add("North", p); // �г� ���̱� 
		add("Center", canvas); // ĵ���� ���̱� 

		setBounds(700,100,300,400);
		setVisible(true);
	

		// �̺�Ʈ �߻� 
		// windowListener implements ��ſ� WindowAdapter�� �ҷ��´� 
		this.addWindowListener(new WindowAdapter(){
			//Override 
			public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}); // windowAdapter�� �߻� Ŭ�����̸鼭 �߻�޼ҵ尡 ����. ���� ���ϴ� ���� ��� �����Ѵ�. 
		// �͸� ���δ� : {} 
		
		//ActionListener (����� �޼ҵ� ������ interface ���� new �Ѵ�. ��ȸ��)
		redBtn.addActionListener(new ActionListener(){
			// Override
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.RED); // ĵ������ ��������  
			}
		});
		greenBtn.addActionListener(new ActionListener(){
			// Override
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.GREEN); // ĵ������ ��������  
			}
		});
		blueBtn.addActionListener(new ActionListener(){
			// Override
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.BLUE); // ĵ������ ��������  
			}
		});
	
} // RGB()

	class DrCanvas extends Canvas{
		public DrCanvas(){
			this.setBackground(new Color(200, 191, 231));
		}
	}

	public static void main(String[] args) {
		new RGB();
	}
}