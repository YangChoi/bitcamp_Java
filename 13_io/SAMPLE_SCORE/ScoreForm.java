package studentManager;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScoreForm {
	private JButton inputBtn, outputBtn, searchBtn, rankBtn, saveBtn, loadBtn;
	private JTextField numT, nameT, korT, engT, mathT;
	private JLabel numL, nameL, korL, engL, mathL;
	
	
	public ScoreForm() {
		JFrame frame = new JFrame();
		
		
		//---------------------------센터 레프트 패널---------------------------
		JPanel[] ps = new JPanel[5];
		JTextField[] jts = {numT, nameT, korT, engT, mathT};
		JLabel[] jlb = {numL, nameL, korL, engL, mathL};
		String[] jlbNames = {"학번", "이름", "국어", "영어", "수학"};
		JPanel centerLeft = new JPanel();
		centerLeft.setLayout(new GridLayout(5,1,5,10));
		
		for (int i = 0; i < jts.length; i++) {
			ps[i] = new JPanel();
			jlb[i] = new JLabel(jlbNames[i]);
			ps[i].add(jlb[i]);
			jts[i] = new JTextField(20);
			ps[i].add(jts[i]);
			centerLeft.add(ps[i]);
		}
		//---------------------------센터 레프트 패널 끝---------------------------
		
		//---------------------------센터 라이트 패널---------------------------
		JPanel centerRight = new JPanel();
		centerRight.setLayout(new GridLayout(1,1,1,1));
		String[] header = {"학번", "이름", "국어", "영어", "수학", "총점", "평균"};
		String[][] content = {{"1","2","3","4","5","6","7"},{"1","2","3","4","5","6","7"},{"1","2","3","4","5","6","7"}};
		DefaultTableModel model = new DefaultTableModel(content, header);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		centerRight.add(scroll);
		scroll.setBounds(9,0,295,200);
		
		//---------------------------센터 라이트 패널 끝---------------------------
		
		
		
		//---------------------------센터 패널 ---------------------------
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,2,5,5));
		center.add(centerLeft);
		center.add(centerRight);
		
		//---------------------------센터 패널  끝---------------------------
		
		
		
		//---------------------------사우스 패널 ---------------------------
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1,6,5,5));
		JButton[] jbs = {inputBtn, outputBtn, searchBtn, rankBtn, saveBtn, loadBtn};
		String[] jbsNames = {"입력", "출력", "학번검색", "순위", "파일저장", "파일열기"};
		for (int i = 0; i < jbs.length; i++) {
			jbs[i] = new JButton(jbsNames[i]);
			south.add(jbs[i]);
		}
		
		//---------------------------사우스 패널 끝---------------------------

		
		//---------------------------ContentPane---------------------------
		frame.getContentPane().add("North", new JPanel());
		frame.getContentPane().add("Center", center);
		frame.getContentPane().add("South", south);
		//---------------------------ContentPane끝---------------------------
		
		//---------------------------frame----------------------------------
		frame.pack();
		frame.setTitle("성적관리 시스템");
		frame.setSize(600,400);
		frame.setLocation(1200,50);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//---------------------------End of frame----------------------------------
	}
	
	public static void main(String[] args) {
		new ScoreForm();
	}
}
