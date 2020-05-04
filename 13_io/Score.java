import javax.swing.table.*; 

interface Score {
// 추상 메서드를 가진 클래스는 반드시 추상 클래스여야한다. 
	// 추상메서드 
	// ScoreImpl 에서 구현 
	// 이런것들을 쓰겠다가 미리 알려줌 (INTERFACE)
	// 받는 값들을 매개변수에 적어준다. 
	// score가 직접 받지 않고 impl(자식)에서 받는 값들
	// 부모(interface)도 함께 받아줘야한다. 
	public void input(ScoreDTO dto);
	public void print(DefaultTableModel model);
	public int search(DefaultTableModel model, String hak);
	public void to_desc();
	public void load();
	public void save();
}
