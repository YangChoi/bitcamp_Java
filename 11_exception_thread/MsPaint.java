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
	private ArrayList<ShapeDTO> list; // 도형에 관한 정보들을 넣을 ArrayList
	// 좌표, 채우기, 색, 도형 의 정보 들어 있음 
	

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
		// 선은 x1, y1의 값이 바뀌지 않는다. (x2, y2만 바뀐다)
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형");
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");
		// 연필은 끝좌표가 시작좌표가 된다. 
		// 좌표 4개가 계속 같이 움직이게 된다. 
		eraser = new JRadioButton("지우개");

		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		group.add(erase);
		
		String[] color = {"빨강", "초록", "파랑", "보라", "하늘"};
		combo = new JComboBox<String>(color);

		draw = new JButton("그리기");

		can = new DrCanvas(this);
		// DrCanvas에 값 넘기기 위해서 

		list = new ArrayList<ShapeDTO>(); //list 선언 

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
		
		// 프레임 설정 
		setBounds(700, 200, 700, 500);
		setVisible(true);
		setTitle("미니 그림판");
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
		
		
		// 버튼 이벤트 
		// interface라 new할 수 없다. >> 따라서 익명 클래스 (new는 익명 클래스를 생성해 주는 것) 
		draw.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				// 그림이 다시 그려지게 
				
				//list.add(new ShapeDTO(getX1()));
				can.repaint();
				// paint는 canvas가 가지고 있음 
 			}
		});
		/*
		// 색깔을 바꾸더라도 repaint되게 (그리기 버튼 안눌러도 됨)
		combo.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				
				can.repaint();	
 			}
		});*/


		// 마우스 이벤트 
		// 마우스가 눌리는 것은 캔버스
		can.addMouseListener(new MouseAdapter(){
			@Override
				// 도형의 시작좌표
			public void mousePressed(MouseEvent e){
				x1T.setText(e.getX()+""); // 좌표값 x 가져와서 x1T에 넣어주기 
				// setText에는 문자형만 들어가야하는데 getX는 int형이므로 문자형으로 바꿔준다 
				y1T.setText(e.getY()+""); 
				
				can.repaint(); // 캔버스에 가서 update() 를 찾는다 >> paint() 순으로 호출 
				// 여태 update를 무시했었다. 
				// 캔버스 깜빡이 개선한다. 

	
			}
			
			// 그림이 완성되는 시점 (마우스에서 손이 떼지는 시점)
			// 이때 그림을 저장한다. 
			@Override
			public void mouseReleased(MouseEvent e){
				x2T.setText(e.getX() + ""); //  x2T 좌표값을 받아온다 
				y2T.setText(e.getY() + ""); //  y2T 좌표값을 받아온다 
				// 드래그 했을 때 생기는 값이 x2, y2
				// press 했을 때 생기는 값이 x1, x2 
				if(x1T.getText().equals(x2T.getText()) && y1T.getText().equals(y2T.getText())) return;
				// x1, y1의 값을 x2, y2에 줌으로서 drag를 했는지 안했는지 확인 	
				// 둘이 같다면 press만 했다는 것 (drag 하지 않았다는 것)			

				ShapeDTO dto = new ShapeDTO();
				// 좌표
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));

				// 채우기 (fill이 선택이 되었는지 안되었는지 )
				dto.setFill(fill.isSelected());
				
				// 도형
				if(line.isSelected()) dto.setShape(Figure.LINE);
				else if(circle.isSelected()) dto.setShape(Figure.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Figure.RECT);
				else if(roundRect.isSelected())dto.setShape(Figure.ROUNDRECT);
				else if(pen.isSelected())dto.setShape(Figure.PEN);
				// 색 (콤보박스 색 저장)
				dto.setCombo(combo.getSelectedIndex());
	

				// list에 ShapeDTO 저장
				list.add(dto);
				System.out.println(list); // list 안의 항목을 보여준다(주소값 x)
				// 그런데 도형을 그리지도 않고 단순히 마우스 액션을 취한것만으로도 list에 값들이 저장된다. 
				// 이걸 막아줘야한다. 
			}
		});


		can.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				x2T.setText(e.getX()+"");
				y2T.setText(e.getY()+""); 
				
				can.repaint();
				
				// 일반도형과 다르게 연필은 손을 땠을 때 저장되는 것이 아니다. 
				// 드래그할 때마다 그 동작 하나하나가 바로 list에 저장되는 것 
				// 연필
				if(pen.isSelected()){
					ShapeDTO dto = new ShapeDTO(); // 계속 저장한다. 
					// 좌표를 저장한다. 
					dto.setX1(Integer.parseInt(x1T.getText()));
					dto.setX2(Integer.parseInt(x2T.getText()));
					dto.setY1(Integer.parseInt(y1T.getText()));
					dto.setY2(Integer.parseInt(y2T.getText()));
					dto.setZ1(Integer.parseInt(z1T.getText()));
					dto.setZ2(Integer.parseInt(z2T.getText()));

					// 연필은 채우기 옵션 필요 없다 
					dto.setShape(Figure.PEN);
					// 색깔 옵션 
					dto.setCombo(combo.getSelectedIndex());
					// 리스트에 담는다 
					list.add(dto);

					// 꼬리물기 
					x1T.setText(x2T.getText()); //x2의 값이 x1으로 바뀐다.  
					y1T.setText(y2T.getText());
				}

			}
		
		});
		
			
	}

	public static void main(String[] args) {
		new MsPaint().event();
	}

	
}
