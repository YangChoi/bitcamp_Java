import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

// 여기 클래스로 파일 읽어오기 
class ByteStream{
	public static void main(String[] args) throws IOException{
		//FileInputStream fis = new FileInputStream("data.txt");
		//BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream (new FileInputStream("data.txt"));
		// 읽을 거리가 없으면 -1
		int data; 
		// read() : 아스키코드(정수형)로 출력된다. 
		while((data = bis.read()) != -1){
			// 읽을 거리가 없다면 -1 
			// -1 이면 false가 되므로 while문 빠져나온다 
			System.out.print((char)data);
			// char : 문자로 형변환 
		}// while()
		bis.close();
	}
}
