import java.awt.*;
import javax.swing.*;

class MsPaint extends JFrame {
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox combo;
	private JButton draw;
	private DrCanvas can; 
	private JPanel top, center, bottom;
	
	String[] colors = {"����", "�ʷ�", "�Ķ�", "����", "�ϴ�"};
	
	public MsPaint(){
		// ������ ���� 
		setBounds(700, 200, 800, 500);
		setVisible(true);
		setTitle("�̴� �׸���");
		setBackground(new Color(255, 255, 255));
		
		this.setLayout(new BorderLayout());
		
		// Panel - top
		JPanel top = new JPanel();
		// Label
		JLabel x1L = new JLabel("X1");
		JLabel y1L = new JLabel("Y1");
		JLabel x2L = new JLabel("X2");
		JLabel y2L = new JLabel("Y2");
		JLabel z1L = new JLabel("Z1");
		JLabel z2L = new JLabel("Z2");

		
		// TextField
		JTextField x1T = new JTextField(4);
		JTextField y1T = new JTextField(4);
		JTextField x2T = new JTextField(4);
		JTextField y2T = new JTextField(4);
		JTextField z1T = new JTextField(4);
		JTextField z2T = new JTextField(4);

		this.add(x1L);
		this.add(x1T);
	
		this.add(y1L);
		this.add(y1T);

		this.add(x2L);
		this.add(x2T);

		this.add(y2L);
		this.add(y2T);
		
		this.add(z1L);
		this.add(z1T);
	
		this.add(z2L);
		this.add(z2T);

		// panel add
		top.add(x1L);
		top.add(x1T);
	
		top.add(y1L);
		top.add(y1T);

		top.add(x2L);
		top.add(x2T);

		top.add(y2L);
		top.add(y2T);
		
		top.add(z1L);
		top.add(z1T);
	
		top.add(z2L);
		top.add(z2T);
		

		
		// checkBOX
		JCheckBox fill = new JCheckBox("ä���");
		this.add(fill);	
		top.add(fill);

		// ���ʿ� ��ġ 
		add("North", top);

		// ĵ���� 
		JPanel center = new JPanel();
		can = new DrCanvas();
		can.setSize(750, 400);
		can.setLocation(20, 30);
		add(can);
		can.setBackground(new Color(200, 191, 231));
		add("Center", center);
		
		
		JPanel bottom = new JPanel();
		// RadioButton
		JRadioButton line = new JRadioButton("��");
		JRadioButton circle = new JRadioButton("��");
		JRadioButton rect = new JRadioButton("�簢��");
		JRadioButton roundRect = new JRadioButton("�ձٻ簢��");
		
		// ������ư �׷�ȭ ���� ��ü 
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(line);
		radioGroup.add(circle);
		radioGroup.add(rect);
		radioGroup.add(roundRect);

		this.add(line);
		this.add(circle);
		this.add(rect);
		this.add(roundRect);

		bottom.add(line);
		bottom.add(circle);
		bottom.add(rect);
		bottom.add(roundRect);
		
		// combobox
		
		JComboBox combo = new JComboBox(colors);
		this.add(combo);
		bottom.add(combo);

		// ��ư
		JButton draw = new JButton("�׸���");
		this.add(draw);
		bottom.add(draw);

		add("South", bottom);

	}


	public static void main(String[] args) {
		new MsPaint();
	}
}
