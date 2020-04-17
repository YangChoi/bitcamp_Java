import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;


class CalendarTest{
	private int year, month, week, lastDay; 

	public CalendarTest(){
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		year = scan.nextInt();
		System.out.print("월입력 입력 : ");
		month = scan.nextInt();
	}

	public void find(){
		Calendar cal = Calendar.getInstance();
		// get은 꺼내오는 것, set은 집어 넣는 것 
		// 시스템의 날짜, 시간이 필요한게 아니라 우리가 직접 지정한 것이므로 set을 이용 
		// 위 까지만 쓰면 시스템의 날짜와 시간을 가져옴. set 사용해서 직접 지정하자. 
		cal.set(Calendar.YEAR, year); // 내가 원하는 날짜로 지정해라 
		cal.set(Calendar.MONTH, month-1); // 그냥 month 하면 0부터 시작하기 때문에
		// 4월을 입력하면 3이 되게 해야한다. 그렇기 때문에 -1. (어제와 다르게 넣는 작업이기 때문)
		cal.set(Calendar.DAY_OF_MONTH, 1); // 일도 아무말 안하면 오늘 날짜가 된다. 
		//우리는 1일부터 시작하는 달력을 원하기 때문에 1을 넣어 무조건 시작을 1로 하게 1을 넣어준다. 

		//cal.set(year, month-1, 1) 로 한번에 넣어줘도 된다. 
		
		week = cal.get(Calendar.DAY_OF_WEEK); // 년월일 줬으니 그에 따라 무슨 요일부터 일이 시작하는지 계산 1,2, 3, 4, 5... 
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 선택한 월의 가장 큰 날 // 31, 30, 28, 29...
	}

	public void display(){
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i = 1; i < week; i++){ // 1부터 lastDay까지 나와라
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
