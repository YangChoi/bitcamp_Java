import java.util.Scanner;

class ShapeTest{
	protected double area; 

	public ShapeTest(){
		System.out.println("ShapeTest 기본생성자");
		// 얘는 따로 호출한 적 없지만 본 클래스를 상속받는 자식 클래스들에게 불려 같이 생성된다. 
	}

	public void calcArea(){
		System.out.println("도형을 계산합니다");
	}
	
	public void dispArea(){
		System.out.println("도형을 출력합니다");
	}
}

//------------------------
class SamTest extends ShapeTest{
	protected int base, height;

	// 생성자 
	public SamTest(){
		System.out.println("SamTest 기본생성자");

		Scanner scan = new Scanner(System.in);
		System.out.print("밑변 : ");
		base = scan.nextInt();
		System.out.print("높이 : ");
		height = scan.nextInt();
	}
	
	@Override // @ : 어노테이션..(표시를 해주면 그제야 오버라이드가 안되었다는 에러 메세지가 뜬다)
	// 위의 표시를 하지 않으면 메소드 명이 다르면 다른 곳의 같은 이름의 메소드로 가서 수행된다. (말없이..)
	public void calcArea(){
		area = base*height/2.0;
	}
	
	public void dispArea(){
		System.out.println("삼각형 넓이 = " + area);
	}
	
}

class SaTest extends ShapeTest{
	protected int width, height; 

	public SaTest(){
		System.out.println("SaTest 기본생성자");

		Scanner scan = new Scanner(System.in);
		System.out.println("가로 : ");
		width = scan.nextInt();
		System.out.println("세로 : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea(){
		area = width * height;
	}

	public void dispArea(){
		System.out.println("사각형 넓이 = " + area);
	}
}

		
class SadariTest extends ShapeTest{
	protected int top, bottom, height; 

	public SadariTest(){
		System.out.println("SadariTest 기본생성자");

		Scanner scan = new Scanner(System.in);
		System.out.println("윗변 : ");
		top = scan.nextInt();
		System.out.println("밑변 : ");
		bottom = scan.nextInt();
		System.out.println("높이 : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea(){
		area = (top+bottom) * height/2.0;
	}

	public void dispArea(){
		System.out.println("직사각형 넓이 = " + area);
	}
}

//--------------------------
//-------------------------
class ShapeMain{
	public static void main(String[] args){
	/*	
		SamTest sam = new SamTest(); 1:1 관계 
		sam.calcArea(); // 오버라이드 되었기 떄문에 나 자신에게 우선권이 부여됨
		// 따라서 ShapeTest의 calcArea는 수행되지 않음 
		sam.dispArea();
		System.out.println();

		SaTest sa = new SaTest();
		sa.calcArea();
		sa.dispArea();
		System.out.println();

		SadariTest sadari = new SadariTest();
		sadari.calcArea();
		sadari.dispArea();
		System.out.println(); 
		*/
		
		ShapeTest shape; 
		// 리모컨을 사온다. 여기에 객체 생성하지말기
		shape = new SamTest();
		// 참조는 부모것으로 생성은 자식걸로
		// 부모 = 자식(다형성) 
		// 자식 = (자식)부모 (다운캐스팅)
		// >> 다형성 
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SaTest();
		// 참조는 부모것으로 생성은 자식걸로
	
		// >> 다형성 
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SadariTest();
		// 참조는 부모것으로 생성은 자식걸로
 
		// >> 다형성 
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		// 즉, 리모컨 한대로 모든 기계를 조종한다. 
		// 

	}
}

/*
@
어노테이션 
*/