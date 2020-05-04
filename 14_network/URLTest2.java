import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;

class URLTest2 {
	public static void main(String[] args) throws IOException, MalformedURLException{
		
		URL url = new URL("http://www.liebli.com/");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null; 
		int idx;
		int count = 0;

		while((line = br.readLine()) != null){ // ���پ� ó��(null �� ������)
			line = line.toLowerCase(); // �ҹ��ڷ� �ٲ㼭 line���� �ش� 
			idx = 0;
			while((idx = line.indexOf("14k", idx)) != -1){ // ã�� str, ���� ��ġ 
				// -1 ���̻� ��ã�� ������ ã�ƶ� 
				count++;
				idx = idx+("14k".length()); // ã�� ���ڼ� ��ŭ 
			}
		}// while
		System.out.println("14k�� ���� = " + count);
		br.close();

		
		
	}
}
