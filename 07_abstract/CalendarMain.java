// 숙제 
/*
년도 입력 : 2002
월 입력 : 10
1부터 30(31) 까지는 for문돌려서 찍으면 된다. 

생성자 입력 = 년도, 월 입력받기 
달력을 얻어오는 것..
getInstance가 아니고 내가 원하는 년도와 월에 따른 달력
find() : 날짜 얻어오는 메소드 
- 시작하는 요일이 언제인지 구해내야한다. 
- 30, 31, 28, 29, 윤년과 같은 마지막 일 (매달이 몇일로 끝나는지)
-시작하는 요일?(아는 메소드..) 매달의 ? 일로 끝나는지? (이 메소드는 찾을 것) 
display() : 출력하는 메소드 
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
		System.out.print("년도 입력 : ");
		year = scan.nextInt();
		System.out.print("월입력 입력 : ");
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
		
		//년, 월 셋팅
		cal.set(Calendar.YEAR, getYear());
		cal.set(Calendar.MONTH, getMonth());

		cal.set(year, month-1, 1);

		// 해당 날짜의 요일 
		dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //
		// 마지막 날짜가 몇일인지 
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
		System.out.println("일\t월\t화\t수\t목\t금\t토");
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
