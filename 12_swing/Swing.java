import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;


class Swing extends JFrame implements ActionListener{
	private JButton newBtn, exitBtn;
	private JTextArea area;

	public Swing() {
		JPanel p = new JPanel();

		newBtn = new JButton("���θ����");
		exitBtn = new JButton(new ImageIcon("exit.jpg"));

		p.add(newBtn);
		p.add(exitBtn);

		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		
		Container c = this.getContentPane(); // ���� ������ contentpane�� ����. 
		// �����̻��� ���ڰ��� ���� 
		c.add("North", p);
		c.add("Center", scroll); // area�� scroll �ȿ� �÷���� ������ scroll�� �־���Ѵ�. 
		// ��ҵ��� ContentPane���ٰ� �ø���. 
		// JFrame�� �� �� �������� ����� 

		// �̺�Ʈ 
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		setBounds(700, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // ��������ִ� �޼ҵ�
		// ������ �� �ڽ��� JFrame�̱� ������ JFrame. �̳� this �������൵ �ȴ�. 

		this.addWindowListener(new WindowAdapter(){
		@Override 
			public void windowClosing(WindowEvent e){
														// �̳�Ŭ���� �θ��� ����� �����غ��� 
														// ����� �͸�Ŭ������, Swing Ŭ���� �ȿ� �ִ� �͸�Ŭ������ 
														// ���� Swing.this
				int result = JOptionPane.showConfirmDialog(Swing.this,
															"�����Ͻðڽ��ϱ�?", "����",
															JOptionPane.YES_NO_OPTION,
															JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
						System.exit(0);	
					}
				}
			});
			
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == newBtn){
			area.setText(""); // �ʱ�ȭ �� 

		}else if(e.getSource() == exitBtn){
			// System.exit(0);
			
			// exitbtn ���� �� �� �޽��� 
			int result = JOptionPane.showConfirmDialog(this, 
										"�����Ͻðڽ��ϱ�?", // �޽���
										"����", // title
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
			// showConfirm �� int�� return 
			if(result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new Swing();
		// swing�� x��ư ������ �����°� �ƴϰ� hidden���� ����. 
		// ���Ḧ ���� ������Ѵ�. (���� EXIT_ON_CLOSE);
	}
}
