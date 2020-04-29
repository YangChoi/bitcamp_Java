import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList; 

class ScoreImpl implements Score{
	private ArrayList<ScoreDTO> list;
	private ScoreDTO dto;
	private ScoreForm sf;
	private DefaultTableModel model;
	
	public void input(){
		list = new ArrayList<ScoreDTO>(); // 리스트 생성

		Vector<String> v = new Vector<String>();

		String hak = sf.getHakT().getText(); // 학번 값 가져옴
		String name = sf.getNameT().getText();
		int kor = sf.getKorT().getText();
		int eng = sf.getEngT().getText();
		int math = sf.getMathT().getText();
		
		v.add(hak);
		v.add(name);

		dto.calcTot(); // 총점, 평균 계산하기
		dto.calcAvg(); 

		int tot = sf.getTot().getText();
		int avg = sf.getAvg().getText();

		v.add(kor );
		v.add(eng);
		v.add(math);
		v.add(tot);
		v.add(avg;

		model.addRow(v);
	}

	public void print(){}
	public void search(){}
	public void to_desc(){}
	public void load(){}
	public void save(){}
	
}
