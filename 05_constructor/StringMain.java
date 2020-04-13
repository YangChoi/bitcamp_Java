class StringMain {
	public static void main(String[] args) {

		// 클래스는 new로 생성하는데 
		// 클래스인 String은 왜 new 안쓸까?
		// String cc = new String(); 도 가능
		// >> 리터럴literal 생성 

		// 상수 Constant 
		// : 변하지 않는 값 
		// literal 
		// 정수 literal - 2
		// 실수 literal 
		// 문자 literal -'A' , '2'
		// 문자열 literal - "A" , "2"(아스키코드가 없는 문자열)

		String aa = "apple";
		String bb = "apple";
	
		if(aa == bb){
		// 두 주소가 같은지 
			System.out.println("a와 b의 참조값은 같다 ");
		}else {
			System.out.println("a와 b의 참조값은 다르다  ");
		}

		if(aa.equals(bb)){
			System.out.println("a와 b의 문자열은 같다 ");
		}else {
			System.out.println("a와 b의 문자열은 같다 ");
		}


		

		String cc = new String();
		String dd = new String();
		

		if(cc == dd){
		// 두 주소가 같은지 
			System.out.println("c와 d의 참조값은 같다 "); // new를 써서 각자 객체를 생성해줬기 때문에 주소가 다르다
		}else {
			System.out.println("c와 c의 참조값은 다르다  ");
		}

		if(cc.equals(dd)){
			System.out.println("c와 d의 문자열은 같다 "); 
		}else {
			System.out.println("c와 d의 문자열은 같다 ");
		}
	
		String ee = "오늘 날짜는 " + 2020 + 4 + 13;

		System.out.println(ee);

		/*  ee가 결합되는 과정...
			"오늘 날짜는 "
			"오늘 날짜는 2020"
			"오늘 날짜는 20204"

                    012345 ... 인덱스가 잡힘
			ee ->> "오늘 날짜는 2020413"
			3번이나 만들었기 때문에 메모리 낭비가 심하다. 
			
			문자열은 편집이 안되므로 메모리 4번 생성된다. 
			JVM에 의해서 삭제 시 Garbage Collector로 보낸다 
			Garbage Collector가 실행되면 컴퓨터는 멈춘다. 
		*/

		System.out.println("문자열의 크기 = " + ee.length()); // 띄어쓰기 포함됨 
		System.out.println("문자 추출 = " + ee.charAt(4)); // 짜 추출
		System.out.println("문자열 추출 = " + ee.substring(7)); // 인덱스 7번부터 쭉 출력
		System.out.println("문자열 추출 = " + ee.substring(7, 11)); // 2020만 뽑아옴. 10아니고 11이다..
		System.out.println("대문자 변경  = " + "Hello".toUpperCase());
		System.out.println("소문자 변경  = " + "Hello".toLowerCase());

		System.out.println("문자열 검색 = " + ee.indexOf("짜")); // 4
		System.out.println("문자열 검색 = " + ee.indexOf("날짜")); // 3
		System.out.println("문자열 검색 = " + ee.indexOf("안녕")); // 없는 경우 -1 출력

		System.out.println("문자열 치환 = " + ee.replace("오늘", "현재")); 
		System.out.println("문자열 치환 = " + ee.replaceAll("오늘", "현재")); 
		
	}
}