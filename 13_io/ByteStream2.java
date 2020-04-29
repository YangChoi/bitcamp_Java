import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// 여기 클래스로 파일 읽어오기 
class ByteStream2{
	public static void main(String[] args) throws IOException{
		// 파일을 객체로 생성한다. 	
		File file = new File("data.txt");
		BufferedInputStream bis = new BufferedInputStream (new FileInputStream(file));
		// 아까는 한글자 한글자 읽었는데 
		// 이번엔 한글자 한글자를 보관해서 한꺼번에 읽는다. >> 방 갯수에 대한 문제가 생긴다. 
		// data.txt 파일의 크기만큼 배열을 잡아준다. 
		// 파일의 크기를 구하도록 한다. 파일을 객체로 생성해서 길이를 구하고 크기를 구한다 
		int size = (int)file.length(); // 파일의 크기 
		// file.length()가 long 타입 데이터 보내주고 있음. 
		// long은 8바이트, int는 4바이트 
		// 형변환해준다 

		byte[] b = new byte[size]; // 배열을 파일크기만큼 만든다 
		
		bis.read(b, 0, size); // 배열b의 0번째 방부터 데이터를 배열 크기만큼 받는다. 
		// 한꺼번에 읽는다. 
		//System.out.println(b); // 배열 이름만 넣으면 배열의 주소값을 읽어들인다. 
		// 따라서 byte[] 배열을 String으로 변환한다. 
		System.out.println(new String(b));


		bis.close();
	}
}
