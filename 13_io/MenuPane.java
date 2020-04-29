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
		fileM = new JMenu("파일");
		
		newM = new JMenuItem("새로만들기");
		openM = new JMenuItem("열기");
		saveM = new JMenuItem("저장");
		exitM = new JMenuItem("종료");
		
		fileM.add(newM);
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);
		
		editM = new JMenu("편집");
		
		cutM = new JMenuItem("잘라내기");
		copyM = new JMenuItem("복사");
		pasteM = new JMenuItem("붙여넣기");
		
		editM.add(cutM);
		editM.add(cutM);
		editM.add(cutM);

		viewM = new JMenu("보기");
		
		// 각 menu들을 menubar에 붙여준다 
		add(fileM);
		add(editM);
		add(viewM);

		// 단축키 
		// 새로운 값을 부여하는 것이므로 set
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
