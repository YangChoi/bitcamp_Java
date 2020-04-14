import java.util.Scanner;

class ShapeTest{
	protected double area; 

	public ShapeTest(){
		System.out.println("ShapeTest �⺻������");
		// ��� ���� ȣ���� �� ������ �� Ŭ������ ��ӹ޴� �ڽ� Ŭ�����鿡�� �ҷ� ���� �����ȴ�. 
	}

	public void calcArea(){
		System.out.println("������ ����մϴ�");
	}
	
	public void dispArea(){
		System.out.println("������ ����մϴ�");
	}
}

//------------------------
class SamTest extends ShapeTest{
	protected int base, height;

	// ������ 
	public SamTest(){
		System.out.println("SamTest �⺻������");

		Scanner scan = new Scanner(System.in);
		System.out.print("�غ� : ");
		base = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}
	
	@Override // @ : ������̼�..(ǥ�ø� ���ָ� ������ �������̵尡 �ȵǾ��ٴ� ���� �޼����� ���)
	// ���� ǥ�ø� ���� ������ �޼ҵ� ���� �ٸ��� �ٸ� ���� ���� �̸��� �޼ҵ�� ���� ����ȴ�. (������..)
	public void calcArea(){
		area = base*height/2.0;
	}
	
	public void dispArea(){
		System.out.println("�ﰢ�� ���� = " + area);
	}
	
}

class SaTest extends ShapeTest{
	protected int width, height; 

	public SaTest(){
		System.out.println("SaTest �⺻������");

		Scanner scan = new Scanner(System.in);
		System.out.println("���� : ");
		width = scan.nextInt();
		System.out.println("���� : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea(){
		area = width * height;
	}

	public void dispArea(){
		System.out.println("�簢�� ���� = " + area);
	}
}

		
class SadariTest extends ShapeTest{
	protected int top, bottom, height; 

	public SadariTest(){
		System.out.println("SadariTest �⺻������");

		Scanner scan = new Scanner(System.in);
		System.out.println("���� : ");
		top = scan.nextInt();
		System.out.println("�غ� : ");
		bottom = scan.nextInt();
		System.out.println("���� : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea(){
		area = (top+bottom) * height/2.0;
	}

	public void dispArea(){
		System.out.println("���簢�� ���� = " + area);
	}
}

//--------------------------
//-------------------------
class ShapeMain{
	public static void main(String[] args){
	/*	
		SamTest sam = new SamTest(); 1:1 ���� 
		sam.calcArea(); // �������̵� �Ǿ��� ������ �� �ڽſ��� �켱���� �ο���
		// ���� ShapeTest�� calcArea�� ������� ���� 
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
		// �������� ��´�. ���⿡ ��ü ������������
		shape = new SamTest();
		// ������ �θ������ ������ �ڽİɷ�
		// �θ� = �ڽ�(������) 
		// �ڽ� = (�ڽ�)�θ� (�ٿ�ĳ����)
		// >> ������ 
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SaTest();
		// ������ �θ������ ������ �ڽİɷ�
	
		// >> ������ 
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SadariTest();
		// ������ �θ������ ������ �ڽİɷ�
 
		// >> ������ 
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		// ��, ������ �Ѵ�� ��� ��踦 �����Ѵ�. 
		// 

	}
}

/*
@
������̼� 
*/