/*
class EnumColor {
	static final String RED = "빨강";
	static final String GREEN = "초록";
	static final String BLUE = "파랑";
	static final String MAGENTA = "보라";
}
*/

//enum : 클래스가 아닌 자료형 
enum EnumColor {
	RED, GREEAN, BLUE, MAGENTA; 
}
class EnumMain{
	String colorName;
	EnumColor color;

	public static void main(String[] args) {
		System.out.println(EnumColor.RED);
		System.out.println();
		// enum이 모두 static으로 내부적 설정이 되어 있다는 것. 
		// EnumColor 안의 색들을 하나의 값들로 인식이 되어 들어온다. 

		EnumMain em = new EnumMain();
		em.colorName = "빨강";
		em.color = EnumColor.RED;
		System.out.println(em.colorName + "\t" + em.color);
		// 이렇게도 가능 
		
		em.colorName = "보라";
		EnumColor VIOLET = EnumColor.MAGENTA;

		// int a = 25; 
		// int b = a; // 이런 식과 비슷함.. 
		// MAGENTA와 VIOLET 상수가 같다는 것으로 표시 
		// 클래스만 자료형이 아닌 EnumColor또한 그렇게 될 수 있는 것. 

		System.out.println(em.colorName + "\t" + VIOLET);
		System.out.println();
		
		// 인덱스값이 0부터 시작한다. 
		for(EnumColor data : EnumColor.values()){
			System.out.println(data + "\t" 
								+ data.ordinal() + "\t"
								+ data.valueOf(data + "")); // String으로 바꿔라 
								// String값을 enum에서 찾는 valueOf
								// data.valueOf("BLACK"); 시 찾는 값이 없다는 에러가 뜸 (아래 설명 참조)
		}

	}
}
// valueOf()
// String 값을 enum에서 가져오고 값이 없으면 IllegalArgumentException 발생
