import java.awt.Container;
import java.awt.Color;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JRadioButton line, circle, rect, roundRect, pen, eraser;
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvas can; 
	private JPanel p1,p2;
	private ArrayList<ShapeDTO> list; // ������ ���� �������� ���� ArrayList
	// ��ǥ, ä���, ��, ���� �� ���� ��� ���� 
	

	public MsPaint(){	
		// ��ư
		draw = new JButton("�׸���");

		// TextField
		x1T = new JTextField("0",4);
		y1T = new JTextField("0",4);
		x2T = new JTextField("0",4);
		y2T = new JTextField("0",4);
		z1T = new JTextField("50",4); // �����̹Ƿ� 50����.. 
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
		fill = new JCheckBox("ä���");		

		line = new JRadioButton("��", true);
		// ���� x1, y1�� ���� �ٲ��� �ʴ´�. (x2, y2�� �ٲ��)
		circle = new JRadioButton("��");
		rect = new JRadioButton("�簢��");
		roundRect = new JRadioButton("�ձٻ簢��");
		pen = new JRadioButton("����");
		// ������ ����ǥ�� ������ǥ�� �ȴ�. 
		// ��ǥ 4���� ��� ���� �����̰� �ȴ�. 
		eraser = new JRadioButton("���찳");

		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		group.add(erase);
		
		String[] color = {"����", "�ʷ�", "�Ķ�", "����", "�ϴ�"};
		combo = new JComboBox<String>(color);

		draw = new JButton("�׸���");

		can = new DrCanvas(this);
		// DrCanvas�� �� �ѱ�� ���ؼ� 

		list = new ArrayList<ShapeDTO>(); //list ���� 

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
		p.add(pen);

			
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
		
		// ������ ���� 
		setBounds(700, 200, 700, 500);
		setVisible(true);
		setTitle("�̴� �׸���");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
	
	} //  msPaint();


	// getter 
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
	public JCheckBox getFill(){
		return fill;
	}

	public JRadioButton getLine() {
		return line;
	}
	public JRadioButton getCircle() {
		return circle;
	}
	public JRadioButton getRect() {
		return rect;
	}
	public JRadioButton getRoundRect() {
		return roundRect;
	}

	public JRadioButton getPen() {
		return pen;
	}
	public JRadioButton getErase() {
		return erase;
	}
	
	
	public JComboBox<String> getCombo(){
		return combo;
	}
	
	public ArrayList<ShapeDTO> getList(){
		return list; 
	}
	
	public void event(){
		
		
		// ��ư �̺�Ʈ 
		// interface�� new�� �� ����. >> ���� �͸� Ŭ���� (new�� �͸� Ŭ������ ������ �ִ� ��) 
		draw.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				// �׸��� �ٽ� �׷����� 
				
				//list.add(new ShapeDTO(getX1()));
				can.repaint();
				// paint�� canvas�� ������ ���� 
 			}
		});
		/*
		// ������ �ٲٴ��� repaint�ǰ� (�׸��� ��ư �ȴ����� ��)
		combo.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				
				can.repaint();	
 			}
		});*/


		// ���콺 �̺�Ʈ 
		// ���콺�� ������ ���� ĵ����
		can.addMouseListener(new MouseAdapter(){
			@Override
				// ������ ������ǥ
			public void mousePressed(MouseEvent e){
				x1T.setText(e.getX()+""); // ��ǥ�� x �����ͼ� x1T�� �־��ֱ� 
				// setText���� �������� �����ϴµ� getX�� int���̹Ƿ� ���������� �ٲ��ش� 
				y1T.setText(e.getY()+""); 
				
				can.repaint(); // ĵ������ ���� update() �� ã�´� >> paint() ������ ȣ�� 
				// ���� update�� �����߾���. 
				// ĵ���� ������ �����Ѵ�. 

	
			}
			
			// �׸��� �ϼ��Ǵ� ���� (���콺���� ���� ������ ����)
			// �̶� �׸��� �����Ѵ�. 
			@Override
			public void mouseReleased(MouseEvent e){
				x2T.setText(e.getX() + ""); //  x2T ��ǥ���� �޾ƿ´� 
				y2T.setText(e.getY() + ""); //  y2T ��ǥ���� �޾ƿ´� 
				// �巡�� ���� �� ����� ���� x2, y2
				// press ���� �� ����� ���� x1, x2 
				if(x1T.getText().equals(x2T.getText()) && y1T.getText().equals(y2T.getText())) return;
				// x1, y1�� ���� x2, y2�� �����μ� drag�� �ߴ��� ���ߴ��� Ȯ�� 	
				// ���� ���ٸ� press�� �ߴٴ� �� (drag ���� �ʾҴٴ� ��)			

				ShapeDTO dto = new ShapeDTO();
				// ��ǥ
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));

				// ä��� (fill�� ������ �Ǿ����� �ȵǾ����� )
				dto.setFill(fill.isSelected());
				
				// ����
				if(line.isSelected()) dto.setShape(Figure.LINE);
				else if(circle.isSelected()) dto.setShape(Figure.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Figure.RECT);
				else if(roundRect.isSelected())dto.setShape(Figure.ROUNDRECT);
				else if(pen.isSelected())dto.setShape(Figure.PEN);
				// �� (�޺��ڽ� �� ����)
				dto.setCombo(combo.getSelectedIndex());
	

				// list�� ShapeDTO ����
				list.add(dto);
				System.out.println(list); // list ���� �׸��� �����ش�(�ּҰ� x)
				// �׷��� ������ �׸����� �ʰ� �ܼ��� ���콺 �׼��� ���Ѱ͸����ε� list�� ������ ����ȴ�. 
				// �̰� ��������Ѵ�. 
			}
		});


		can.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				x2T.setText(e.getX()+"");
				y2T.setText(e.getY()+""); 
				
				can.repaint();
				
				// �Ϲݵ����� �ٸ��� ������ ���� ���� �� ����Ǵ� ���� �ƴϴ�. 
				// �巡���� ������ �� ���� �ϳ��ϳ��� �ٷ� list�� ����Ǵ� �� 
				// ����
				if(pen.isSelected()){
					ShapeDTO dto = new ShapeDTO(); // ��� �����Ѵ�. 
					// ��ǥ�� �����Ѵ�. 
					dto.setX1(Integer.parseInt(x1T.getText()));
					dto.setX2(Integer.parseInt(x2T.getText()));
					dto.setY1(Integer.parseInt(y1T.getText()));
					dto.setY2(Integer.parseInt(y2T.getText()));
					dto.setZ1(Integer.parseInt(z1T.getText()));
					dto.setZ2(Integer.parseInt(z2T.getText()));

					// ������ ä��� �ɼ� �ʿ� ���� 
					dto.setShape(Figure.PEN);
					// ���� �ɼ� 
					dto.setCombo(combo.getSelectedIndex());
					// ����Ʈ�� ��´� 
					list.add(dto);

					// �������� 
					x1T.setText(x2T.getText()); //x2�� ���� x1���� �ٲ��.  
					y1T.setText(y2T.getText());
				}

			}
		
		});
		
			
	}

	public static void main(String[] args) {
		new MsPaint().event();
	}

	
}
