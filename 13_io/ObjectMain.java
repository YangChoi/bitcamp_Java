import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

class ObjectMain{
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		PersonDTO dto = new PersonDTO("양아무개", 25, 183.3);
		// 직렬화를 시키지 않으면 보낼 수 없다. (serializable)
		
		/*
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		// 이전에는 하나씩 보냈는데 이번에는 한꺼번에 보냈다. 
		oos.writeObject(dto); // dto를 통해서 한꺼번에 나간다. 
		oos.close();
		*/
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		PersonDTO dto2 = (PersonDTO)ois.readObject(); // 다시 dto에 넣는 것이므로..
		// 꺼내줄 땐 object로 꺼내진다. 하지만 받고자 하는 타입은 PersonDTO
		// 따라서 형변환을 해준다 
		System.out.println("이름 = " + dto2.getName());
		System.out.println("나이 = " + dto2.getAge());
		System.out.println("키 = " + dto2.getHeight());
		
	}
}
