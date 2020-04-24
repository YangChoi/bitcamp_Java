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

		newBtn = new JButton("새로만들기");
		exitBtn = new JButton(new ImageIcon("exit.jpg"));

		p.add(newBtn);
		p.add(exitBtn);

		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		
		Container c = this.getContentPane(); // 제일 위쪽의 contentpane을 얻어낸다. 
		// 포장이사의 상자같은 역할 
		c.add("North", p);
		c.add("Center", scroll); // area가 scroll 안에 올려줬기 때문에 scroll을 넣어야한다. 
		// 요소들을 ContentPane에다가 올린다. 
		// JFrame이 좀 더 안정성이 생긴다 

		// 이벤트 
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		setBounds(700, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 종료시켜주는 메소드
		// 지금은 내 자신이 JFrame이기 때문에 JFrame. 이나 this 안적어줘도 된다. 

		this.addWindowListener(new WindowAdapter(){
		@Override 
			public void windowClosing(WindowEvent e){
														// 이너클래스 부르는 방법을 생각해보자 
														// 여기는 익명클래스로, Swing 클래스 안에 있는 익명클래스다 
														// 따라서 Swing.this
				int result = JOptionPane.showConfirmDialog(Swing.this,
															"종료하시겠습니까?", "종료",
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
			area.setText(""); // 초기화 됨 

		}else if(e.getSource() == exitBtn){
			// System.exit(0);
			
			// exitbtn 누를 시 뜰 메시지 
			int result = JOptionPane.showConfirmDialog(this, 
										"종료하시겠습니까?", // 메시지
										"종료", // title
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
			// showConfirm 가 int값 return 
			if(result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new Swing();
		// swing은 x버튼 눌러도 꺼지는게 아니고 hidden으로 들어간다. 
		// 종료를 따로 해줘야한다. (위의 EXIT_ON_CLOSE);
	}
}
