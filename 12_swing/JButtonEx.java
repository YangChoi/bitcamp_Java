import java.awt.*;
import javax.swing.*;

class JButtonEx extends JFrame {
	private Icon icon1 = new ImageIcon("rickandmorty.jpg");
	private Icon icon2 = new ImageIcon("pickle_rick.jpg");
	private Icon icon3 = new ImageIcon("rick.jpg");
	private Icon icon4 = new ImageIcon("dad.jpg");

	// 4�� 
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();

	public JButtonEx(){
		super("Homework");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
		for(int i = 0; i < 4; i++){
			jb[i] = new JRadioButton(i + 1 + "�� ��ư", icon1);
			con.add(jb[1]);
			jb[i].setToolTipText(i + 1+ "��° ��ư�̴�. ����");
		
			jb[i].setMnemonic(i+49); // ����Ű ���� 
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3);
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]);

	}

	pack();
	setVisible(true);

}
	public static void main(String[] args) {
		new JButtonEx();
	}
}
