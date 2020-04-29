import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class DataStream {
	public static void main(String[] args) throws IOException{
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		// DataOutputStream�� ���ͼ� FileOutputStream���� ������. 
		// FileOutputStream���� ������ ������ ������������ result.txt
		
		// ���� �ڵ带 ����� ������ ���� �ִ�. 
		FileOutputStream fos = new FileOutputStream("result.txt");
		DataOutputStream dos = new DataOutputStream(fos); // ������ ���� �����Ǿ�� �Ѵ�(result.txt)
		// ������ �ֱ� 
		dos.writeUTF("��ƹ���");
		dos.writeInt(25); 
		dos.writeDouble(185.3); 
		dos.close(); // dos �ݱ� 
		// result.txt�� ���� ���� ���� 
		// ��� ���� ������ �ڵ� ���������� 
		// �Է� �ÿ� ���� ������ error
		// ����� ����̱� ������ �ڵ����� �ȴ�. 
	
		// ������� byte ������ ���� ������ �ѱ��� �� �����ִ�. 

		// �������� 
		FileInputStream fis = new FileInputStream("result.txt");
		// ���� ���� �ҷ����� error
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println("�̸� = "+ dis.readUTF());
		System.out.println("���� = "+ dis.readInt());
		System.out.println("Ű = " + dis.readDouble());
		// ���� �� ������ �������� ����� ���´�. 


		// filenotfound�� ioexception�� ��Ӱ��� 
		// ioexception�� �θ��̹Ƿ� ioexception ���� ������ filenotfound ������ ���� ������. 
	}
}
