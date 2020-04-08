class InputTest {
	public static void main(String[] args) { 
	// JVM에 의한 main 메소드 (콜백 메소드)  : 실행할 때 jvm이나 운영체제에 의해서 불려지는 것 
	// 컴파일할 때는 main을 안 찾는다 
	// 단, 출력할 때 main을 찾는다.	

	// 현재 main 메소드는 주소만 가지고 있다. 
	System.out.println("배열명 args = " + args);
	for(int i = 0; i < args.length; i++){
		System.out.println("args["+i+"] = " + args[i]);

		// 배열의 글자수 
		// 배열값 하나에 (방 하나에) 요소의 글자수가 몇개 있는지 
		System.out.println("글자수 = " + args[i].length());

		// 배열 안 요소 안의 첫글자 빼기 
		System.out.println("첫 글자 = " + args[i].charAt(0));
	} // for 문 

	// 가독성 : 주석을 잘 달자 

	System.out.println("==== 확장형 for ====" ); 
	for(String data : args) {
		System.out.println(data);
	}
	
	//System.out.println("args[1] = " + args[1]);
	}
}

/*
** 변수			** 배열 
 자료형 변수형		자료형[] 배열명 = {값, 값, 값};
 
** 메소드()


*/