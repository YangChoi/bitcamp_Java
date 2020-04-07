import java.util.Random;

class MethodTest3 {
	public static void main(String[] args) {
		System.out.println("큰 값 :: " + Math.max(25, 36));

		// 2의 5승 계산 : 32
		double power = Math.pow(2, 5);
		System.out.println("제곱 :: " + (int)power);

		// 난수 > 컴퓨터가 불규칙하게 발생하는 수, 0 < 난수 <= 1
		int a;
		a = (int)(Math.random() * 100); // 0 ~ 99.xxx 
		// 만약 +1 하면 1부터 100까지 나온다. 
		System.out.println(a);
		// 형변환은 왼쪽에 불가 : a에 불가 
		// 형변환은 오른쪽에 

		Random random = new Random();
		double b; 
		b = random.nextDouble();
		System.out.println(b);
				
	}
}