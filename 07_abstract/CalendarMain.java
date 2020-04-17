// ���� 
/*
�⵵ �Է� : 2002
�� �Է� : 10
1���� 30(31) ������ for�������� ������ �ȴ�. 

������ �Է� = �⵵, �� �Է¹ޱ� 
�޷��� ������ ��..
getInstance�� �ƴϰ� ���� ���ϴ� �⵵�� ���� ���� �޷�
find() : ��¥ ������ �޼ҵ� 
- �����ϴ� ������ �������� ���س����Ѵ�. 
- 30, 31, 28, 29, ����� ���� ������ �� (�Ŵ��� ���Ϸ� ��������)
-�����ϴ� ����?(�ƴ� �޼ҵ�..) �Ŵ��� ? �Ϸ� ��������? (�� �޼ҵ�� ã�� ��) 
display() : ����ϴ� �޼ҵ� 
*/
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class CalendarTest {
	int year, month, lastDay, dayOfWeek;
	
	public CalendarTest(){
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ �Է� : ");
		year = scan.nextInt();
		System.out.print("���Է� �Է� : ");
		month = scan.nextInt();
	}


	public void find(){
		Calendar cal = Calendar.getInstance();
		
		//��, �� ����
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month); 
		// �Է¹��� ������ �����ϱ� 

		cal.set(year, month-1, 1); 

		// �ش� ��¥�� ���� 
		dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 
		// ������ ��¥�� �������� 
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

}

	public void display(){
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		dayOfWeek = 1;
		for(int i = 1; i <= lastDay; i++){ // 1�Ϻ��� �� ���� ������ �ϱ��� for�������� 
			for(int k = 1; k < dayOfWeek; k++){ // 1���� �����ϴ� k�� ���ۿ��Ϻ��� ������ 
				System.out.print(" ");  // ���� 
				if(dayOfWeek%7 == 0){ // ���� �����̶� 7�̶� ������ ������ 0�� �Ǹ� 
				System.out.println(); // �ٹٲ� 
				}
	
			}
		}
		
	}

}
class CalendarMain {
	public static void main(String[] args) {
		CalendarTest ct = new CalendarTest(); 
		ct.find();
		ct.display();
	}
}
