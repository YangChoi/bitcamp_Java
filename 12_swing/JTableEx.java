import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class JTableModel extends AbstractTableModel { // javax.swing의 추상클래스 
	Obejct[][] data = {{"Nari", "양아무개", new Integer(1234), "옆집친구"},
						{"One", "김아무개", new Integer(1111), "예삐"} 
						{"Two", "박아무개", new Integer(2222), "겸디"},
						{"Three", "최아무개", new Integer(3333), "동아리 친구"}};
	
	String[] name = {"아이디", "이름", "비밀번호", "구분"}; // 필드명 들 

	public int getColumnCount(){ // 테이블의 열의 수[필수]
		return name.length; // return 4; 와 동일
	}

	public int getRowCount(){ // 테이블 행의 수 [필수]
		return data.length;
	}

	public Object getValueAt(int r, int c){ // 실제 데이터 추출[필수]
		return data[r][c]; 
	}
	
	public boolean isCellEditable(int r, int c){ // 편집가능하게 한다. 
		return (c!=0) ? true : false; // 어떤 인덱스의 값을 수정 못하게 막는다. 
	}

	public String getColumnName(int c){ // 테이블에 타이틀명 부여
		return name[c];
	}
	public void setValueAt(Object obj, int r, int c){ // 필드값 변경 
		data[r][c] = obj;
	}

}
public class JTableEx extends JFrame{
	JTable table;
	JTableModel model; // 사용자 모델정의 클래스 
	
	public JTableEx(){
		model = new JTableModel();
		table = new JTable(model);
		add(new JScrollPane(table)); // 스크롤바 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JTableEx();
		
	}
}
