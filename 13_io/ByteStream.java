import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

// ���� Ŭ������ ���� �о���� 
class ByteStream{
	public static void main(String[] args) throws IOException{
		//FileInputStream fis = new FileInputStream("data.txt");
		//BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream (new FileInputStream("data.txt"));
		// ���� �Ÿ��� ������ -1
		int data; 
		// read() : �ƽ�Ű�ڵ�(������)�� ��µȴ�. 
		while((data = bis.read()) != -1){
			// ���� �Ÿ��� ���ٸ� -1 
			// -1 �̸� false�� �ǹǷ� while�� �������´� 
			System.out.print((char)data);
			// char : ���ڷ� ����ȯ 
		}// while()
		bis.close();
	}
}
