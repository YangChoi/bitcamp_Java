import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TryNotePad extends JFrame implements ActionListener{
	private JTextArea output;
	private MenuPane menu;
	private File file;
	
	// �߰����� x��ư�� �����ų� �����ư ���� �� 
	// TEXTAREA�� �ƹ��͵� �ԷµǾ� ���� �ʴٸ� ���� ���̾�α׸� ����� �ʰ� �ٷ� �����Ѵ�. 


	// title ���� string�� ���´�. 
	public TryNotePad(String title){
		// textarea
		output = new JTextArea();
		// ��ũ��
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		menu = new MenuPane();
		setJMenuBar(menu);

		getContentPane().add("Center", scroll);
		
		setBounds(300, 100, 700, 500);
		setTitle(title);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // �ƹ��͵� �������� �ʴ´�. 
		// ���� �ڵ带 ���ָ� FRAME�� �ݾƵ� JFrame ��ü�� JVM�� ����ְ� �ȴ�. 
		// ��, ����ڿ��� �������� VIEW�� ����Ǿ����� ���α׷��� ��� ���� ���� ���̴�. 
		// ���� DO_NOTHING_ON_CLOSE�� ���־� X�� ������ �� ���α׷��� ������ ����� �� �ְ� ���ش�. 

		// �ݾ��� ���� �׳� ������ �ȵȴ�. 
		// �����Ұ��� ������ ��������� WindowListener�� �θ���. 
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int result = JOptionPane.showConfirmDialog(TryNotePad.this, "������ �����Ͻðڽ��ϱ�?", "����",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION){
					// ��, Ȯ��	>> �����ϰ� ���� 
					saveDialog();
					fileWrite();
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION){
					// �ƴϿ� >> ���� ���ϰ� ���� 
					System.exit(0);
				} // cancel�� ����̹Ƿ� �� �ʿ� ���� 
			}
		});
		
				
	}
	
	public void event(){
		menu.getNewM().addActionListener(this); //menu�� ������ �ִ� newM
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
		menu.getCutM().addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == menu.getNewM()){
			output.setText("");
		}else if(e.getSource() == menu.getOpenM()){
			// ���� ���̾�α� 
			openDialog();
			// ���� �б� 
			fileRead();
		}else if(e.getSource() == menu.getSaveM()){
			saveDialog();
			fileWrite();

		}else if(e.getSource() == menu.getExitM()){
			// ���� result�� �޴´�. 
			int result = JOptionPane.showConfirmDialog(this, "������ �����Ͻðڽ��ϱ�?", "����",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION){
				// ��, Ȯ��	>> �����ϰ� ���� 
				saveDialog();
				fileWrite();
				System.exit(0);
			}else if(result == JOptionPane.NO_OPTION){
				// �ƴϿ� >> ���� ���ϰ� ���� 
				System.exit(0);
			} // cancel�� ����̹Ƿ� �� �ʿ� ���� 
	
		}else if(e.getSource() == menu.getCopyM()){
			output.copy();
		}else if(e.getSource() == menu.getPasteM()){
			output.paste();
		}else if(e.getSource() == menu.getCutM()){
			output.cut(); // �� 
		}
	}

	public void openDialog(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this); // ���� ���� ����� ��������Ѵ�  
		// ���ϰ����� ����/��� ��ư�� �Ѿ�´�. 
		
		if(result == JFileChooser.APPROVE_OPTION){
			// APPROVE_OPTION : ���������� ������ �� 
			// ������ �����´� 
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file); // ������ ������ ��ġ�� ���޶� 
	}

	public void fileRead(){
		// ���� openDialog���� �ƹ� ���ۼ������ ��Ҹ� ������ file nullpoint������ ����. 
		// �׷��� ������ ���� file�� null�̸� �ƹ��͵� �������� ���� ���´� 
		if(file == null) return;
		
		// ������ �б� ���� textarea�� ���� 
		output.setText(""); // ���� ���� 
		try{
		BufferedReader br = new BufferedReader(new FileReader(file));
		// file�� null�� �Ϳ� ���� nullpoint ������ ����. 

		// file�� �����´� 
		String line; // �Ʊ�� read��� �ؼ� �� ���ھ� �о�´�. 
		// �̰� �� �پ� �д� ���̴�. 
		// �Ʊ�� read�ؼ� �ѱ��ھ� �ƽ�Ű�ڵ�� ���� ������ ���� ��� -1 ������
		// �̹��� �� �� �� �б� ������ string Ÿ������ ���� ������ ���� ��� null
			while((line = br.readLine()) != null){
				 // ���� �ȿ� �ִ� �� ���� �д´� (���͸� ģ �������� �� ��) 
				 // �׷��� ������ ���� �ٷ� �������� �б� ������ �ҷ��� �۵��� ���� �ٹٲ��� ���� �ʴ´�. 
				// �����ٷ� �������� �ؾ��Ѵ� \n
				//output.setText(line); // output�� �о���� ������ text�� set
				// setText�� ���������. 
				output.append(line + "\n"); // �߰��� ���ִ� �Լ�  
				// ������ ���� �� ���� ������ ������ �ȴ�. 
				
			}// while
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void saveDialog(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);

		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file);
	}

	public void fileWrite(){
		if(file == null) return;

		try{
			// ����ó���ؾ��ϱ� ������ Writer 
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			// FileWriter : ���� ������ ���� 
			
			// ������ �������� ( �޸��忡 �Է��� �� �����´� - textarea) 
			String data = output.getText(); // getText�ϱ� stringŸ�� data�� �� ��´�. 
			// �������� �� �ѹ��� �� �������� �� (getText())
			bw.write(data); // bw�� ������������ file, �� file �ȿ� data�� �ִ´�. 
			bw.close();	
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// ��ü�� �ٷ� title�ο��� ���� �ֱ���.
		new TryNotePad("���� �޸���").event();
	}
}
