import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;

class URLTest {
	public static void main(String[] args) throws IOException, MalformedURLException{
		
		URL url = new URL("https://www.naver.com");

		System.out.println("프로토콜 = "+ url.getProtocol());
		System.out.println("호스트 = "+ url.getHost());
		System.out.println("포트 = "+ url.getPort());
		System.out.println("기본포트 = "+ url.getDefaultPort());
		System.out.println("파일 = "+ url.getFile());
		System.out.println();
	
	// ==========
	// 웹사이트를 통해 얻어온다 
	/*
	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	// 네트워크 ip를 통해 들어오는 것 . 
	String line = null;
	while((line = br.readLine()) != null){
		System.out.println(line);
	}
	br.close();
	*/
	}
}

/*
URL(웹주소)
URI(범위가 더크다) 

*/
