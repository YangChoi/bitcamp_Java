import java.util.Scanner;
class EmployeeMain {
	/* 
	아무 쓸모없는 껍데기 
	월급 : 기본급 + 수당 -(기본급+수당)*세율
	setter/getter 메소드 설정, 계산은 calcPay()

	// 직원의 월급을 계산하는 프로그램 
	// 이름, 직급, 기본급, 수당, 세율, 월급 
	// 세율 : 
	// 200만원 이하 : 1%(0.01)
	// 400만원 이하 : 2%(0.02)
	// 400만원 초과 : 3%(0.03) 으로 설정 



	[실행결과]
	이름:
	직급:
	기본급:
	수당:

	양아무개 과장 25000 1000 0.02 얼마얼마 
	*/

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EmployeeDTO dto = new EmployeeDTO();
		
		System.out.print("이름 : ");
		String name = scan.next();
		

		System.out.print("직급 : ");
		String position = scan.next();
		
		
		System.out.print("기본급 : ");
		int basicPay= scan.nextInt();
		

		System.out.print("수당 : ");
		int extraPay = scan.nextInt();
		
		dto.setData(name, position, basicPay, extraPay);
	
	
		dto.calcPay(); // 월급 계산 
		

		
	System.out.println("이름\t\t직급\t기본급\t수당\t세율\t월급");
	System.out.println(dto.getName() +"\t"+
						dto.getPosition() +"\t"+
						dto.getBasicPay() + "\t"+
						dto.getExtraPay() + "\t"+
						dto.getTaxRate() + "\t" +
						dto.getSalary() + "\t");


	}
}
