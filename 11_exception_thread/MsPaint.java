import java.awt.Container;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;



class MsPaint extends JFrame {
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvas can; 
	private JPanel p1,p2;

	public MsPaint(){	
		// 버튼
		draw = new JButton("그리기");

		// TextField
		x1T = new JTextField("0",4);
		y1T = new JTextField("0",4);
		x2T = new JTextField("0",4);
		y2T = new JTextField("0",4);
		z1T = new JTextField("50",4); // 각도이므로 50으로.. 
		z2T = new JTextField("50",4);

		// Label
		JLabel x1L = new JLabel("X1");
		JLabel y1L = new JLabel("Y1");
		JLabel x2L = new JLabel("X2");
		JLabel y2L = new JLabel("Y2");
		JLabel z1L = new JLabel("Z1");
		JLabel z2L = new JLabel("Z2");

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
	
		// checkBOX
		fill = new JCheckBox("채우기");		

		line = new JRadioButton("선", true);
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형");
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");

		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		
		String[] color = {"빨강", "초록", "파랑", "보라", "하늘"};
		combo = new JComboBox<String>(color);

		draw = new JButton("그리기");

		can = new DrCanvas(this);
		// DrCanvas에 값 넘기기 위해서 

		// Panel - top
		JPanel p = new JPanel();

		// panel add
		p.add(x1L);
		p.add(x1T);
	
		p.add(y1L);
		p.add(y1T);

		p.add(x2L);
		p.add(x2T);

		p.add(y2L);
		p.add(y2T);
		
		p.add(z1L);
		p.add(z1T);
	
		p.add(z2L);
		p.add(z2T);

		p.add(fill);

			
		// Panel - bottom
		JPanel p2 = new JPanel();
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(combo);
		p2.add(draw);

		Container c = this.getContentPane();
		c.add(p, "North");
		c.add(can, "Center");
		c.add(p2, "South");
		
		// 프레임 설정 
		setBounds(700, 200, 700, 500);
		setVisible(true);
		setTitle("미니 그림판");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
	}

	public JTextField getX1T(){
		return x1T;
	}
	public JTextField getX2T(){
		return x2T;
	}
	public JTextField getY1T(){
		return y1T;
	}
	public JTextField getY2T(){
		return y2T;
	}
	public JTextField getZ1T(){
		return z1T;
	}
	public JTextField getZ2T(){
		return z1T;
	}

	public JComboBox<String> getCombo(){
		return combo;
	}

	public static void main(String[] args) {
		new MsPaint();
	}

	// 버튼액션리스너 넣기 

}
