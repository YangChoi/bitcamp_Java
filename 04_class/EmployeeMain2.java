// 객체 배열 
//
import java.util.Scanner;
class EmployeeMain2{
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	
	EmployeeDTO[] arr = new EmployeeDTO[2]; // 객체 배열 
	arr[0] = new EmployeeDTO(); 
	arr[1] = new EmployeeDTO();
	

	for(int i = 0; i < arr.length; i++){
	
		System.out.print("이름 : ");
		String name = scan.next();
		

		System.out.print("직급 : ");
		String position = scan.next();
			
			
		System.out.print("기본급 : ");
		int basicPay= scan.nextInt();
			

		System.out.print("수당 : ");
		int extraPay = scan.nextInt();
		System.out.println("      ");
		
		arr[i].setData(name, position, basicPay, extraPay);

		
		arr[i].calcPay(); // 월급 계산 
		

		}
		
		// 출력
		for(EmployeeDTO data : arr){
		System.out.println("이름\t\t직급\t기본급\t수당\t세율\t월급");
		System.out.println(data.getName() +"\t"+
						data.getPosition() +"\t"+
						data.getBasicPay() + "\t"+
						data.getExtraPay() + "\t"+
						data.getTaxRate() + "\t" +
						data.getSalary() + "\t");
		System.out.println("      ");
		
		}
	}
}