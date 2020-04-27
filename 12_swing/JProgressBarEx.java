import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JProgressBarEx extends JFrame implements ActionListener, Runnable{
	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	private JButton jbt = new JButton("Ω√¿€");
	private JButton jbt1 = new JButton("∏ÿ√„");
	
	public JProgressBarEx(){
		super("Test");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("«¡∑Œ±◊∑πΩ∫ πŸ"));
		con.add("Center", jpb);
		jpb.setStringPainted(true);
		jpb.setString("0%");

		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(jbt);
		jp.add(jbt1);
		jbt.addActionListener(this);
		jbt1.addActionListener(this);
		con.add("South", jp);
		setSize(300, 150);
		setVisible(true);
	}

	private boolean bb = true; 
	private static int ii;
	public void run(){
		if(ii == 100){
			ii = 0;
		}

		for(int i = 0; i <= 100; i++){
			if(!bb) break;
			try{
				Thread.sleep(50);
			}catch(InterruptedException e){}
				jpb.setValue(i);
				ii = i;
				jpb.setString(ii+"%");
			
		}// for i

		jbt.setEnabled(true);
		jbt1.setEnabled(false);
	}// run()

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == jbt){
			bb = true;
			new Thread(this).start();
			jbt.setEnabled(false);
			jbt1.setEnabled(true);
		}else if(e.getSource() == jbt1){
			bb = false;
			jbt.setEnabled(true);
			jbt1.setEnabled(false);
		}
	}


	public static void main(String[] args) {
		new JProgressBarEx();
	}
}
