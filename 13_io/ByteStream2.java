import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// ���� Ŭ������ ���� �о���� 
class ByteStream2{
	public static void main(String[] args) throws IOException{
		// ������ ��ü�� �����Ѵ�. 	
		File file = new File("data.txt");
		BufferedInputStream bis = new BufferedInputStream (new FileInputStream(file));
		// �Ʊ�� �ѱ��� �ѱ��� �о��µ� 
		// �̹��� �ѱ��� �ѱ��ڸ� �����ؼ� �Ѳ����� �д´�. >> �� ������ ���� ������ �����. 
		// data.txt ������ ũ�⸸ŭ �迭�� ����ش�. 
		// ������ ũ�⸦ ���ϵ��� �Ѵ�. ������ ��ü�� �����ؼ� ���̸� ���ϰ� ũ�⸦ ���Ѵ� 
		int size = (int)file.length(); // ������ ũ�� 
		// file.length()�� long Ÿ�� ������ �����ְ� ����. 
		// long�� 8����Ʈ, int�� 4����Ʈ 
		// ����ȯ���ش� 

		byte[] b = new byte[size]; // �迭�� ����ũ�⸸ŭ ����� 
		
		bis.read(b, 0, size); // �迭b�� 0��° ����� �����͸� �迭 ũ�⸸ŭ �޴´�. 
		// �Ѳ����� �д´�. 
		//System.out.println(b); // �迭 �̸��� ������ �迭�� �ּҰ��� �о���δ�. 
		// ���� byte[] �迭�� String���� ��ȯ�Ѵ�. 
		System.out.println(new String(b));


		bis.close();
	}
}
