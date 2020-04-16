import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class NumberTest {
	public static void main(String[] args) {
		//NumberFormat nf = new NumberFormat();
		// 에러 - NumberFormat은 추상이기때문에 new로 생성 불가 
		
		NumberFormat nf = new DecimalFormat();
		// sub class 이용해서 numberFormat 만듦
		
		// 자식을 new로 해준다. 
		// 10진수 형태 
		// 3자리마다 쉼표를 찍음. 소수 이하 3째자리
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		// 소수점이 없으면 표시 안해줌 
		System.out.println();

		NumberFormat nf2 = new DecimalFormat("#,###.#원");
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678)); 
		System.out.println();

		
		NumberFormat nf3 = new DecimalFormat("#,###.00원");
		// 0 강제표시 
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678)); 
		System.out.println();

		//NumberFormat nf4 = NumberFormat.getInstance(); 
		// getInstance 안에서 NumbeFormat을 만들어서 나에게 주는 것 
		// 메소드를 이용해서 생성 
		// 저 안에서 클래스를 new 시켜서 주는 것 

		NumberFormat nf4 = NumberFormat.getCurrencyInstance(); //원가표시￦ 
		nf4.setMaximumFractionDigits(2);
		// 최대 소수 둘째까지 표시	
		nf4.setMinimumFractionDigits(2);
		// 소수 이하값이 없어도 0이 강제 표시 
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678)); 
		System.out.println();


		// 달러표시 
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US); 
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678)); 
		System.out.println();

	}
}

/*
	클래스 aa = new 클래스();
	클 aa = new 자식();
	// 모든 클래스가 new로만 생성되는거 아니다 
	// 메소드로 


*/
