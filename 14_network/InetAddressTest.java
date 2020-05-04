import java.net.InetAddress;
import java.net.UnknownHostException;

class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException{
		// new하면 접근제어자가 public이 아니라는 에러 뜬다. 
		InetAddress naver = InetAddress.getByName("www.naver.com"); 
		System.out.println("NAVER IP :" +naver.getHostAddress());
		System.out.println();

		// 내자신의 ip 얻기 
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("localhost IP : " + local.getHostAddress());
		System.out.println();

		InetAddress[] ar = InetAddress.getAllByName("www.daum.net");
		for(InetAddress data : ar){
			System.out.println("Daum IP : " + data.getHostAddress());
		}
	}
}
