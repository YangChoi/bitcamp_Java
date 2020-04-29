import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class DataStream {
	public static void main(String[] args) throws IOException{
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		// DataOutputStream로 들어와서 FileOutputStream으로 나가라. 
		// FileOutputStream으로 나가서 도달할 최종목적지는 result.txt
		
		// 위의 코드를 나누어서 적어줄 수도 있다. 
		FileOutputStream fos = new FileOutputStream("result.txt");
		DataOutputStream dos = new DataOutputStream(fos); // 안쪽이 먼저 생성되어야 한다(result.txt)
		// 데이터 넣기 
		dos.writeUTF("양아무개");
		dos.writeInt(25); 
		dos.writeDouble(185.3); 
		dos.close(); // dos 닫기 
		// result.txt는 현재 없는 파일 
		// 출력 때는 없으면 자동 생성이지만 
		// 입력 시엔 파일 없으면 error
		// 현재는 출력이기 때문에 자동생성 된다. 
	
		// 결과보면 byte 단위로 들어가기 때문에 한글이 다 깨져있다. 

		// 꺼내오기 
		FileInputStream fis = new FileInputStream("result.txt");
		// 없는 파일 불러오면 error
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println("이름 = "+ dis.readUTF());
		System.out.println("나이 = "+ dis.readInt());
		System.out.println("키 = " + dis.readDouble());
		// 파일 안 내용은 깨졌지만 제대로 들어온다. 


		// filenotfound와 ioexception은 상속관계 
		// ioexception이 부모이므로 ioexception 에러 잡으면 filenotfound 에러도 같이 잡힌다. 
	}
}
