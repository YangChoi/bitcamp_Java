import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*; 

	
class ScoreImpl implements Score{
	private List<ScoreDTO> list = new ArrayList<ScoreDTO>();
	// List��� �θ� �ؿ� �ڽ� �� �ϳ� ArrayList�� �����ϰڴ� 
	// 1:1���ٴ� �θ� ArrayList ���� �ٸ� �͵� ������ �� �ֱ� ������ 1:�� �� ����(���յ��� �����ش�)

	// ���⿡ dto�� ���� �޴� ������ �ٲ��ָ� �θ��� Score���� �Ȱ��� �ٲ�����Ѵ�. 
	public void input(ScoreDTO dto){
		// �Ű����� dto : dto�� ���� �ްڴ�. 
		// ������ ��Ƽ� ó�� : ArrayList���ٰ� 
		list.add(dto); //list�� dto ���� �޴´�. 
		// ��ϿϷ� �޼��� 

	}
	public void print(DefaultTableModel model){
		// model�� ���´� 
		
		model.setRowCount(0); // ���̺� clear (�����Ǹ� �ȵǴϱ�, ���ο� ���̺��� �����ϴϱ�)

		for(ScoreDTO dto : list){
			// list�� �ϳ��� ���� (list �ȿ� � �ִ��� �ƹ��� �𸣱� ������ Ȯ���� for��)
			// ���ʹ� �и����� �������� 
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
		// ���� �ѹ��̶� ���ǿ� �ɷ��� ã���� �ϴ� ���� �߰ߵƴٸ� sw = 1;

		// ã�����ϴ� ���� hak�� form���� �Է¹޴� ��Ȳ 
		// model�� �Բ� �޴´�. 
		for(ScoreDTO dto : list){
			if(hak.equals(dto.getHak())){
				// ã�� ������ vector > model���� �ѷ��ش�. 
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
		// ã�����ϴ� ������ ���ٴ� dialog�� form���� ����ش�. 
		return sw; // sw���� �������ش�. 
	}
	
	public void to_desc(){
		// ��ü���� �������� 
		// Comparable
		// Comparator > �͸��̳� ���� �ȴ�. 
		Collections.sort(list);
	}
	public void save(){
		// ���� ���̾�α� 
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}
		
		if(file == null) return; // ���� ���� ���� �� ������ 
		// ��ü�� �����Ƿ� ObjectOutputStream
		// buffer���� ���Ϸ� ���� ���� FileOutputStream
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			// �����ʹ� ����Ʈ�� ������ŭ ��������Ѵ�. 
			for(ScoreDTO dto : list){
				oos.writeObject(dto); 
			}
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void load(){
		// ���� ���̾�α� 
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}
		
		if(file == null) return; 

		list.clear(); 
		// ����Ʈ�� ��� �Ŀ� �ҷ��´�
		
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			// �׷��� ���� �ȿ� �����Ͱ� � ��� �ִ��� �𸥴�. >> ���� (end of file Exception)
			while(true){
				try{
					ScoreDTO dto = (ScoreDTO)ois.readObject(); // readObject�� ������ ObjectŸ������ �о�´�. 
					// ���� DTO�� ����ȯ�ؼ� �Ѱ��ش�. 
					// �� ������ WHILE�� ���� 
					list.add(dto); // list�� ����ش�. 
				}catch(EOFException e){
					// ������ ���� �����ϸ� ������ 
					// ���ʿ� ������ ũ�⸦ ������ ���� ���� ������ ������ byte ������ �Ǿ� �ֱ� ������ 
					// ��� �������� �ϳ����� �� �� ����. (byte ������ ���ڼ��� �о�´�..) 
					break; 
				}
			}
			ois.close();
			// unreachable statement error : while���� ���� ���� ����. 
		}catch(IOException e){
			e.printStackTrace(); 
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}


	/*
	public void input(){
		list = new ArrayList<ScoreDTO>(); // ����Ʈ ����

		Vector<String> v = new Vector<String>();

		String hak = sf.getHakT().getText(); // �й� �� ������
		String name = sf.getNameT().getText();
		String kor = sf.getKorT().getText();
		String eng = sf.getEngT().getText();
		String math = sf.getMathT().getText();
		
		dto.calcTot(); // ����, ��� ����ϱ�
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