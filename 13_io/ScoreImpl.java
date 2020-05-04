import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*; 

	
class ScoreImpl implements Score{
	private List<ScoreDTO> list = new ArrayList<ScoreDTO>();
	// List라는 부모 밑에 자식 중 하나 ArrayList를 참조하겠다 
	// 1:1보다는 부모가 ArrayList 말고 다른 것도 참조할 수 있기 때문에 1:다 로 선언(결합도를 끊어준다)

	// 여기에 dto의 값을 받는 것으로 바꿔주면 부모인 Score에도 똑같이 바꿔줘야한다. 
	public void input(ScoreDTO dto){
		// 매개변수 dto : dto의 값을 받겠다. 
		// 데이터 모아서 처리 : ArrayList에다가 
		list.add(dto); //list에 dto 값을 받는다. 
		// 등록완료 메세지 

	}
	public void print(DefaultTableModel model){
		// model이 들어온다 
		
		model.setRowCount(0); // 테이블 clear (누적되면 안되니까, 새로운 테이블이 떠야하니까)

		for(ScoreDTO dto : list){
			// list값 하나씩 전달 (list 안에 몇개 있는지 아무도 모르기 때문에 확장형 for문)
			// 벡터는 학목수대로 만들어야함 
			Vector<String> v = new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor() + "");
			v.add(dto.getEng() + "");
			v.add(dto.getMath()+ "");
			v.add(dto.getTot() + "");
			v.add(dto.getAvg());

			model.addRow(v);
		}
	}
	public int search(DefaultTableModel model, String hak){
		model.setRowCount(0); 
		int sw = 0;
		// 만약 한번이라도 조건에 걸려서 찾고자 하는 값이 발견됐다면 sw = 1;

		// 찾고자하는 학점 hak이 form에서 입력받는 상황 
		// model과 함께 받는다. 
		for(ScoreDTO dto : list){
			if(hak.equals(dto.getHak())){
				// 찾은 내용은 vector > model에다 뿌려준다. 
				Vector<String> v = new Vector<String>();
				v.add(dto.getHak());
				v.add(dto.getName());
				v.add(dto.getKor() + "");
				v.add(dto.getEng() + "");
				v.add(dto.getMath()+ "");
				v.add(dto.getTot() + "");
				v.add(dto.getAvg());

				model.addRow(v);
			}
		}// for()
		// 찾고자하는 정보가 없다는 dialog는 form에다 찍어준다. 
		return sw; // sw값을 리턴해준다. 
	}
	
	public void to_desc(){
		// 객체끼리 내림차순 
		// Comparable
		// Comparator > 익명이너 쓰면 된다. 
		Collections.sort(list);
	}
	public void save(){
		// 저장 다이얼로그 
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}
		
		if(file == null) return; // 파일 선택 없을 시 나가기 
		// 객체가 나가므로 ObjectOutputStream
		// buffer에서 파일로 가는 것은 FileOutputStream
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			// 데이터는 리스트의 갯수만큼 보내줘야한다. 
			for(ScoreDTO dto : list){
				oos.writeObject(dto); 
			}
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void load(){
		// 열기 다이얼로그 
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}
		
		if(file == null) return; 

		list.clear(); 
		// 리스트를 비운 후에 불러온다
		
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			// 그런데 파일 안에 데이터가 몇개 들어 있는지 모른다. >> 에러 (end of file Exception)
			while(true){
				try{
					ScoreDTO dto = (ScoreDTO)ois.readObject(); // readObject로 읽으면 Object타입으로 읽어온다. 
					// 따라서 DTO로 형변환해서 넘겨준다. 
					// 다 읽으면 WHILE문 나가 
					list.add(dto); // list에 담아준다. 
				}catch(EOFException e){
					// 파일의 끝에 도달하면 나가라 
					// 애초에 파일의 크기를 측정할 수가 없는 이유는 파일은 byte 단위로 되어 있기 때문에 
					// 어디서 어디까지가 하나인지 알 수 없다. (byte 단위의 글자수를 읽어온다..) 
					break; 
				}
			}
			ois.close();
			// unreachable statement error : while문을 나갈 수가 없다. 
		}catch(IOException e){
			e.printStackTrace(); 
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}


	/*
	public void input(){
		list = new ArrayList<ScoreDTO>(); // 리스트 생성

		Vector<String> v = new Vector<String>();

		String hak = sf.getHakT().getText(); // 학번 값 가져옴
		String name = sf.getNameT().getText();
		String kor = sf.getKorT().getText();
		String eng = sf.getEngT().getText();
		String math = sf.getMathT().getText();
		
		dto.calcTot(); // 총점, 평균 계산하기
		dto.calcAvg(); 

		String tot = dto.getTot().getText();
		String avg = dto.getAvg().getText();

		v.add(hak);
		v.add(name);
		v.add(kor);
		v.add(eng);
		v.add(math);
		v.add(tot);
		v.add(avg);

		model.addRow(v);
	}

*/