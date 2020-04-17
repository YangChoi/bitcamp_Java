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
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class CalendarTest {
	int year, month, lastDay, dayOfWeek;
	
	public CalendarTest(){
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		year = scan.nextInt();
		System.out.print("월입력 입력 : ");
		month = scan.nextInt();
	}


	public void find(){
		Calendar cal = Calendar.getInstance();
		
		//년, 월 셋팅
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month); 
		// 입력받은 값으로 설정하기 

		cal.set(year, month-1, 1); 

		// 해당 날짜의 요일 
		dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 
		// 마지막 날짜가 몇일인지 
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

}

	public void display(){
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		dayOfWeek = 1;
		for(int i = 1; i <= lastDay; i++){ // 1일부터 그 달의 마지막 일까지 for문돌려서 
			for(int k = 1; k < dayOfWeek; k++){ // 1부터 시작하는 k가 시작요일보다 작으면 
				System.out.print(" ");  // 띄운다 
				if(dayOfWeek%7 == 0){ // 만약 요일이랑 7이랑 나눠서 나머지 0이 되면 
				System.out.println(); // 줄바꿈 
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
