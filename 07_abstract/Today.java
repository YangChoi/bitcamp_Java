import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


class Today {
	public static void main(String[] args) throws ParseException{
		Date date = new Date();
		System.out.println("오늘 날짜 : " + date);

		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 H:m:s");
		System.out.println("오늘 날짜 : " + sdf.format(date));
		System.out.println();
		
		//1991-07-16
		//19910716152510
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910716152510"); // String -> Date로 변환 

		System.out.println("내 생일" + birth);
		System.out.println("내 생일" + sdf.format(birth)); // 내가 만든 다른 형식에 맞추고 싶다면..
		// 각자 알아서 내가 원하는 형식으로 출력할 수 있다. 
		System.out.println();

		//Calendar cal = new 어쩌고 안됨! 추상클래스다
		// 그러니 자식 클래스 잡아온다 
		//Calendar cal = new GregorianCalendar(); // 자식 클래스를 이용한 Calendar 클래스 가져오기 방법
		// 아니면 메소드를 가지고 온다!
		Calendar cal = Calendar.getInstance(); // 메소드를 이용한 Calendar 클래스 가져오기 방법 - 시스템 날짜, 시간 가져옴 
		//int year = cal.get(Calendar.YEAR); 
		int year = cal.get(1); // 1 : Calendar.YEAR 하지만 1쓰지말고 상수 써...
		int month = cal.get(Calendar.MONTH)+1; // 1월이 Constant field value가 0으로 0으로 나온다. 
		// 따라서 +1을 해주면 됨 
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일은 일요일부터해서 1부터 시작함...
	
		String week = null;
		switch(dayOfWeek){
			case 1:
				week = "일요일";
				break;
			case 2:
				week = "월요일";
				break;
			case 3: 
				week = "화요일";
				break;
			case 4:
				week = "수요일";
				break;
			case 5:
				week = "목요일";
				break;
			case 6:
				week = "금요일";
				break;
			case 7:
				week = "토요일";
				break;
		}
		System.out.println(year + "년 " + month + "월 " + day + "일 " + week);

	}
}