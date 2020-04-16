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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class CalendarTest {
	private int year; 
	private int month;
	public int lastDay; 
	public int startDay;
	public int dayOfWeek;


	public CalendarTest(){}
	public CalendarTest(int year, int month){
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ �Է� : ");
		year = scan.nextInt();
		System.out.print("���Է� �Է� : ");
		month = scan.nextInt();
	}

	public int getYear(){
		return year;
	}
	public int getMonth(){
		return month; 
	}

	public void find(){
		Calendar cal = Calendar.getInstance();
		
		//��, �� ����
		cal.set(Calendar.YEAR, getYear());
		cal.set(Calendar.MONTH, getMonth());

		cal.set(year, month-1, 1);

		// �ش� ��¥�� ���� 
		dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //
		// ������ ��¥�� �������� 
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		/*
		if(month != 2){
			lastDay += 30;
		}else if((year%400 == 0) || (year%4 == 0) && (year %100 != 0)){
			lastDay += 29;
		}else {
			lastDay += 28;
		} */

}
	public void display(){
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		for(int i = 1; i <= lastDay; i++){
			for(int k = 1; i < dayOfWeek; k++){
				System.out.print(" "); 
				if(dayOfWeek%7 == 0){
				System.out.println();
				}
				dayOfWeek++;
				
			}
		}
		
	}

}
class CalendarMain {
	public static void main(String[] args) {
		CalendarTest ct = new CalendarTest(); 
		ct.display();
	}
}
