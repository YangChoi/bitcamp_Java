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
	
	// 추가사행 x버튼을 누르거나 종료버튼 누를 때 
	// TEXTAREA에 아무것도 입력되어 있지 않다면 종료 다이얼로그를 띄우지 않고 바로 종료한다. 


	// title 값인 string이 들어온다. 
	public TryNotePad(String title){
		// textarea
		output = new JTextArea();
		// 스크롤
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		menu = new MenuPane();
		setJMenuBar(menu);

		getContentPane().add("Center", scroll);
		
		setBounds(300, 100, 700, 500);
		setTitle(title);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 아무것도 실행하지 않는다. 
		// 위의 코드를 해주면 FRAME을 닫아도 JFrame 객체가 JVM에 살아있게 된다. 
		// 즉, 사용자에게 보여지는 VIEW는 종료되었지만 프로그램은 계속 실행 중인 것이다. 
		// 따라서 DO_NOTHING_ON_CLOSE를 해주어 X를 눌렀을 때 프로그램이 완전히 종료될 수 있게 해준다. 

		// 닫아줄 때도 그냥 닫으면 안된다. 
		// 저장할건지 말건지 물어보기위해 WindowListener를 부른다. 
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int result = JOptionPane.showConfirmDialog(TryNotePad.this, "파일을 저장하시겠습니까?", "종료",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION){
					// 예, 확인	>> 저장하고 종료 
					saveDialog();
					fileWrite();
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION){
					// 아니오 >> 저장 안하고 종료 
					System.exit(0);
				} // cancel은 취소이므로 할 필요 없다 
			}
		});
		
				
	}
	
	public void event(){
		menu.getNewM().addActionListener(this); //menu가 가지고 있는 newM
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
			// 열기 다이얼로그 
			openDialog();
			// 파일 읽기 
			fileRead();
		}else if(e.getSource() == menu.getSaveM()){
			saveDialog();
			fileWrite();

		}else if(e.getSource() == menu.getExitM()){
			// 값을 result로 받는다. 
			int result = JOptionPane.showConfirmDialog(this, "파일을 저장하시겠습니까?", "종료",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION){
				// 예, 확인	>> 저장하고 종료 
				saveDialog();
				fileWrite();
				System.exit(0);
			}else if(result == JOptionPane.NO_OPTION){
				// 아니오 >> 저장 안하고 종료 
				System.exit(0);
			} // cancel은 취소이므로 할 필요 없다 
	
		}else if(e.getSource() == menu.getCopyM()){
			output.copy();
		}else if(e.getSource() == menu.getPasteM()){
			output.paste();
		}else if(e.getSource() == menu.getCutM()){
			output.cut(); // 컷 
		}
	}

	public void openDialog(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this); // 누구 위에 뜰건지 적어줘야한다  
		// 리턴값으로 열기/취소 버튼이 넘어온다. 
		
		if(result == JFileChooser.APPROVE_OPTION){
			// APPROVE_OPTION : 정상적으로 열렸을 때 
			// 파일을 가져온다 
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file); // 나에게 파일의 위치를 찍어달라 
	}

	public void fileRead(){
		// 위의 openDialog에서 아무 동작수행없이 취소를 누르면 file nullpoint에러가 난다. 
		// 그렇기 때문에 만약 file이 null이면 아무것도 수행하지 말고 나온다 
		if(file == null) return;
		
		// 파일을 읽기 전에 textarea를 비운다 
		output.setText(""); // 누적 제거 
		try{
		BufferedReader br = new BufferedReader(new FileReader(file));
		// file이 null인 것에 대한 nullpoint 에러가 난다. 

		// file을 가져온다 
		String line; // 아까는 read라고 해서 한 글자씩 읽어냈다. 
		// 이건 한 줄씩 읽는 것이다. 
		// 아까는 read해서 한글자씩 아스키코드로 들어와 다음이 없는 경우 -1 이지만
		// 이번엔 한 줄 씩 읽기 때문에 string 타입으로 들어와 다음이 없는 경우 null
			while((line = br.readLine()) != null){
				 // 파일 안에 있는 한 줄을 읽는다 (엔터를 친 곳까지가 한 줄) 
				 // 그런데 문제가 엔터 바로 전까지만 읽기 때문에 불러온 글들이 전혀 줄바꿈이 되지 않는다. 
				// 다음줄로 내려가게 해야한다 \n
				//output.setText(line); // output에 읽어들인 값들을 text로 set
				// setText는 덮어버린다. 
				output.append(line + "\n"); // 추가를 해주는 함수  
				// 파일이 열고 또 열면 내용이 누적이 된다. 
				
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
			// 문자처리해야하기 때문에 Writer 
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			// FileWriter : 문자 단위로 저장 
			
			// 데이터 꺼내오기 ( 메모장에 입력한 값 꺼내온다 - textarea) 
			String data = output.getText(); // getText니까 string타입 data에 값 담는다. 
			// 꺼내오는 건 한번에 다 꺼내오는 것 (getText())
			bw.write(data); // bw의 최종목적지는 file, 그 file 안에 data를 넣는다. 
			bw.close();	
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 객체에 바로 title부여할 수도 있구나.
		new TryNotePad("간단 메모장").event();
	}
}
