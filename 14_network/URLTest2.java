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

		while((line = br.readLine()) != null){ // 한줄씩 처리(null 될 때까지)
			line = line.toLowerCase(); // 소문자로 바꿔서 line에게 준다 
			idx = 0;
			while((idx = line.indexOf("14k", idx)) != -1){ // 찾는 str, 시작 위치 
				// -1 더이상 못찾을 때까지 찾아라 
				count++;
				idx = idx+("14k".length()); // 찾는 글자수 만큼 
			}
		}// while
		System.out.println("14k의 개수 = " + count);
		br.close();

		
		
	}
}
