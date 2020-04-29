import java.awt.Event;
import java.awt.event.InputEvent;
import javax.swing.KeyStroke;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;



class MenuPane extends JMenuBar{ 
	private JMenu fileM, editM, viewM;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;

	public MenuPane(){
		fileM = new JMenu("����");
		
		newM = new JMenuItem("���θ����");
		openM = new JMenuItem("����");
		saveM = new JMenuItem("����");
		exitM = new JMenuItem("����");
		
		fileM.add(newM);
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);
		
		editM = new JMenu("����");
		
		cutM = new JMenuItem("�߶󳻱�");
		copyM = new JMenuItem("����");
		pasteM = new JMenuItem("�ٿ��ֱ�");
		
		editM.add(cutM);
		editM.add(cutM);
		editM.add(cutM);

		viewM = new JMenu("����");
		
		// �� menu���� menubar�� �ٿ��ش� 
		add(fileM);
		add(editM);
		add(viewM);

		// ����Ű 
		// ���ο� ���� �ο��ϴ� ���̹Ƿ� set
		cutM.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.ALT_DOWN_MASK));
		//cutM.setAccelerator(KeyStroke.getKeyStroke('X',Event.ALT_MASK));
		copyM.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.ALT_DOWN_MASK));
		pasteM.setAccelerator(KeyStroke.getKeyStroke('Y',InputEvent.ALT_DOWN_MASK));

	}
	public JMenuItem getNewM(){
		return newM;
	}
	public JMenuItem getExitM(){
		return exitM;
	}
	public JMenuItem getOpenM(){
		return openM;
	}
	public JMenuItem getSaveM(){
		return saveM;
	}
	public JMenuItem getCutM(){
		return cutM;
	}
	public JMenuItem getCopyM(){
		return copyM;
	}
	public JMenuItem getPasteM(){
		return pasteM;
	
	}
}
