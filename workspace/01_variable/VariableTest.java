class VariableTest {
	public static void main(String[] args) {
		boolean a = true; 
		// true를 a에 넣어라 (대입) 
		// 항상 오른쪽에 있는 것이 왼쪽으로 들어가는 것 
		System.out.println("a =	" + a); 

		char b = 'A';
		System.out.println("b =	" + b); 
		
		char c = 65;
		System.out.println("c =	" + c); 
		// 65를 넣었지만 데이터 타입을 char로 했기 때문에 65에 대해 해당되는 문자가 나온다. 
		// A 역시도 컴퓨터가 읽기엔 2진수로 읽는다. 
		// 65 도 마찬가지

		// char가 담을 수 있는 최대 
		char d = 65535;
		System.out.println("d =	" + d); 
		// char의 범위의 숫자 : 결과가 ?로 나온다. 
		
		// char의 범위를 넘은 숫자 
		// char e = 65536;
		// System.out.println("e =	" + e); 
		// imcompatiable 에러 
		// char가 제공할 수 있는 범위는 65535까지이기 때문

		int e = 65; 
		System.out.println("e =	" + e);
		
		int f = 'A';
		System.out.println("f =	" + f);
		// int형이기 때문에 A도 아스키코드인 65로 나온다. 

		//float g = 43.8; 
		double g = 43.8;
		System.out.println("g =	" + g); 
		// error 
		// double형인 숫자를 float에 줌 

		float f = (float)43.8; // 잠깐 형변환
		// float f = 43.8f; // 자체적으로 바꾼 것 
		System.out.println("f =	" + f); 

		// 25 : int형
		// 25L : long형
	}
}