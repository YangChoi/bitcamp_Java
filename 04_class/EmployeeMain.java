import java.util.Scanner;
class EmployeeMain {
	/* 
	�ƹ� ������� ������ 
	���� : �⺻�� + ���� -(�⺻��+����)*����
	setter/getter �޼ҵ� ����, ����� calcPay()

	// ������ ������ ����ϴ� ���α׷� 
	// �̸�, ����, �⺻��, ����, ����, ���� 
	// ���� : 
	// 200���� ���� : 1%(0.01)
	// 400���� ���� : 2%(0.02)
	// 400���� �ʰ� : 3%(0.03) ���� ���� 



	[������]
	�̸�:
	����:
	�⺻��:
	����:

	��ƹ��� ���� 25000 1000 0.02 �󸶾� 
	*/

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EmployeeDTO dto = new EmployeeDTO();
		
		System.out.print("�̸� : ");
		String name = scan.next();
		

		System.out.print("���� : ");
		String position = scan.next();
		
		
		System.out.print("�⺻�� : ");
		int basicPay= scan.nextInt();
		

		System.out.print("���� : ");
		int extraPay = scan.nextInt();
		
		dto.setData(name, position, basicPay, extraPay);
	
	
		dto.calcPay(); // ���� ��� 
		

		
	System.out.println("�̸�\t\t����\t�⺻��\t����\t����\t����");
	System.out.println(dto.getName() +"\t"+
						dto.getPosition() +"\t"+
						dto.getBasicPay() + "\t"+
						dto.getExtraPay() + "\t"+
						dto.getTaxRate() + "\t" +
						dto.getSalary() + "\t");


	}
}
