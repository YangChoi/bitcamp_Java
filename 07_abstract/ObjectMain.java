class Test {
	@Override
	public String toString(){
		return getClass() + "@안녕";
		// 오버라이드로 인해 주소값이 안녕으로 바뀜 
	}
}

class Sample{
	
}

class ObjectMain{
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("객체 t = " + t); // 객체 t = Test@15db9742
		//t는 클래스명@16진수 
		System.out.println("객체 t = " + t.toString()); // 아래의 메소드를 사용하면 위와 똑같이 나온다. 

		Sample s = new Sample();
		System.out.println("객체 s = " + s); // 객체 s = Sample@15db9742
		System.out.println("객체 s = " + s.toString()); 
		System.out.println("객체 s = " + s.hashCode()); // 객체 주소값 16진수가 10진수로 나옴  
		System.out.println();

		String str = "apple";
		System.out.println("객체 str = " + str);
		// 이건 왜 위에 처럼 객체의 주소값이 출력되지 않고 apple이 출력될까? 
		// 오버라이드 때문이다. 
		// Object의 주소값이 나오는 toString을 String 클래스에서 문자열로 나오게 오버라이드 했기 때문 
		System.out.println("객체 str = " + str.hashCode()); // 믿으면 안됨 
		System.out.println();

		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc == dd : " + (cc == dd) ); //f
		System.out.println("cc.equals(dd) : " + cc.equals(dd)); //f - 참조값 비교 
		System.out.println();

		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : " + (ee == ff)); // f
		System.out.println("ee.equals(ff) : " + ee.equals(ff)); // t - 문자열 비교 
		System.out.println();
		// 상속의 경우 오버라이드된 메소드들 중 발동의 우선권은 자식(자기자신)이 가지게 된다. 
		// 따라서 ee와 ff는 자기 자신(String)의 메소드를 발동한다. 

	}
}


/*
class Object {
	public String toString(){} >> 클래스명@16진수 값 보여주는 클래스 
	public int hashCode(){} // 10진수로 변경 
	public boolean equals(Object ){} // 참조값(주소값) 비교 
}

class String extends Object{
	public String toString(){} // 주소값이 아닌 문자열로 오버라이드 한 것 
	public int hashCode(){} // 문자열을 10진수로 바꾸는것 (위에 Object는 16진수를 10진수로 바꾼 것이라 신뢰가능) 
	// 그런데 위의 hashCode는 문자열을 10진수로 변환한 것, 
	// 문자열은 무한 갯수 >> 따라서 문자열을 10진수로 변환할 수 없음 (int 형은 21억개가 한계, 4바이트)
	// 그냥 있는거다.. String 클래스의 hashCode() 는 믿지 말 것.. 
	public boolean equals(Object ){} // 문자열 비교 (Object가 매개변수로 들어가는 것은 뭐가 들어와도 된다는 것)
}
*/