// ��ü �迭 
//
import java.util.Scanner;
class EmployeeMain2{
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	
	EmployeeDTO[] arr = new EmployeeDTO[2]; // ��ü �迭 
	arr[0] = new EmployeeDTO(); 
	arr[1] = new EmployeeDTO();
	

	for(int i = 0; i < arr.length; i++){
	
		System.out.print("�̸� : ");
		String name = scan.next();
		

		System.out.print("���� : ");
		String position = scan.next();
			
			
		System.out.print("�⺻�� : ");
		int basicPay= scan.nextInt();
			

		System.out.print("���� : ");
		int extraPay = scan.nextInt();
		System.out.println("      ");
		
		arr[i].setData(name, position, basicPay, extraPay);

		
		arr[i].calcPay(); // ���� ��� 
		

		}
		
		// ���
		for(EmployeeDTO data : arr){
		System.out.println("�̸�\t\t����\t�⺻��\t����\t����\t����");
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