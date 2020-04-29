import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

class ObjectMain{
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		PersonDTO dto = new PersonDTO("��ƹ���", 25, 183.3);
		// ����ȭ�� ��Ű�� ������ ���� �� ����. (serializable)
		
		/*
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		// �������� �ϳ��� ���´µ� �̹����� �Ѳ����� ���´�. 
		oos.writeObject(dto); // dto�� ���ؼ� �Ѳ����� ������. 
		oos.close();
		*/
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		PersonDTO dto2 = (PersonDTO)ois.readObject(); // �ٽ� dto�� �ִ� ���̹Ƿ�..
		// ������ �� object�� ��������. ������ �ް��� �ϴ� Ÿ���� PersonDTO
		// ���� ����ȯ�� ���ش� 
		System.out.println("�̸� = " + dto2.getName());
		System.out.println("���� = " + dto2.getAge());
		System.out.println("Ű = " + dto2.getHeight());
		
	}
}
