//import static java.lang.Math.random;
// 여기서 import를 해주면 밑에 Math.random()에서 Math를 써줘도 된다. 
// 근데 자칫 random을 ImportStatic 클래스의 것이라고 착각할 수 있으므로 주의하도록. 
//import static java.lang.Math.pow;
// 위의 것들을 아래로 줄여 쓸 수 있음
import static java.lang.Math.*;
import static java.lang.String.format;
import static java.lang.System.out;

class ImportStatic {
	public static void main(String[] args){
		System.out.println("난수 = " + Math.random()); // 0 <=난수 < 1
		// 만약 Math.random()이 static이 아니었다면 
		// new Math().random() 이렇게 객체를 생성해야했을 것. 

		System.out.println("제곱 = " + pow(2, 5)); // 2의 5승 계산 
		// Math.pow도 위와 마찬가지. 

		System.out.println("소수 이하 2째 자리 = " + format("%.2f", 43.56789));
		// String.format
		out.println();
	}
}