import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;

class URLTest {
	public static void main(String[] args) throws IOException, MalformedURLException{
		
		URL url = new URL("https://www.naver.com");

		System.out.println("�������� = "+ url.getProtocol());
		System.out.println("ȣ��Ʈ = "+ url.getHost());
		System.out.println("��Ʈ = "+ url.getPort());
		System.out.println("�⺻��Ʈ = "+ url.getDefaultPort());
		System.out.println("���� = "+ url.getFile());
		System.out.println();
	
	// ==========
	// ������Ʈ�� ���� ���´� 
	/*
	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	// ��Ʈ��ũ ip�� ���� ������ �� . 
	String line = null;
	while((line = br.readLine()) != null){
		System.out.println(line);
	}
	br.close();
	*/
	}
}

/*
URL(���ּ�)
URI(������ ��ũ��) 

*/
