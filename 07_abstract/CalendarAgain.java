import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;


class CalendarTest{
	private int year, month, week, lastDay; 

	public CalendarTest(){
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ �Է� : ");
		year = scan.nextInt();
		System.out.print("���Է� �Է� : ");
		month = scan.nextInt();
	}

	public void find(){
		Calendar cal = Calendar.getInstance();
		// get�� �������� ��, set�� ���� �ִ� �� 
		// �ý����� ��¥, �ð��� �ʿ��Ѱ� �ƴ϶� �츮�� ���� ������ ���̹Ƿ� set�� �̿� 
		// �� ������ ���� �ý����� ��¥�� �ð��� ������. set ����ؼ� ���� ��������. 
		cal.set(Calendar.YEAR, year); // ���� ���ϴ� ��¥�� �����ض� 
		cal.set(Calendar.MONTH, month-1); // �׳� month �ϸ� 0���� �����ϱ� ������
		// 4���� �Է��ϸ� 3�� �ǰ� �ؾ��Ѵ�. �׷��� ������ -1. (������ �ٸ��� �ִ� �۾��̱� ����)
		cal.set(Calendar.DAY_OF_MONTH, 1); // �ϵ� �ƹ��� ���ϸ� ���� ��¥�� �ȴ�. 
		//�츮�� 1�Ϻ��� �����ϴ� �޷��� ���ϱ� ������ 1�� �־� ������ ������ 1�� �ϰ� 1�� �־��ش�. 

		//cal.set(year, month-1, 1) �� �ѹ��� �־��൵ �ȴ�. 
		
		week = cal.get(Calendar.DAY_OF_WEEK); // ����� ������ �׿� ���� ���� ���Ϻ��� ���� �����ϴ��� ��� 1,2, 3, 4, 5... 
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // ������ ���� ���� ū �� // 31, 30, 28, 29...
	}

	public void display(){
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		for(int i = 1; i < week; i++){ // 1���� lastDay���� ���Ͷ�
			System.out.print("\t");
		}
		for(int i = 1; i <= lastDay; i++){
			System.out.print(i+"\t");
			if(week % 7 == 0){
				System.out.println();
			}// if
			week++;
		}// for
	}
}

class CalendarAgain {
	public static void main(String[] args) {
		CalendarTest ct = new CalendarTest();
		ct.find();
		ct.display();

	}
}
