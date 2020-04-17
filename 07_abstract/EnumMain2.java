enum EnumColor2{
	// enum 괄호안의 데이터는 생성자로 전달된다. 
	RED("빨강"), GREEN("초록"), BLUE("파랑"), MAGENTA("보라");
	private String colorName;
	
	// public 사용하면 안됨 
	// private or default 여야한다. 
	// 이 내부에만 값을 전달하겠다는 것
	// 외부에선 들어올 수 없다. 
	// 즉 main 메소드 있는 클래스에서 new로 부를 수 없다는 것 
	EnumColor2(String colorName){
		this.colorName = colorName; 
	}
	public String getColorName(){
		return colorName;
	}
}

class EnumMain2{
	public static void main(String[] args) {
		System.out.println(EnumColor2.RED);
		System.out.println();


		for(EnumColor2 data : EnumColor2.values()){
			System.out.println(data + "\t" 
				+data.ordinal() + "\t"
				+data.valueOf(data + "") + "\t"
				+data.getColorName());
		}
	}
}
