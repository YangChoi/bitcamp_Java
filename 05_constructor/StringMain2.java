import java.util.Scanner;

class StringMain2 {
	// 숙제 
	// indexOf(?, ?) 인자 두개 들어가는 거 찾아서 쓰기 
	public static void main(String[] args){
		// 치환 : replace
		Scanner scan = new Scanner(System.in);
		
		int index = 0; 
		int count = 0; 
		String str, find, change; 
		String result;
		
		System.out.print("문자열 입력 : ");
		str = scan.next();
		System.out.print("현재 문자열 입력 : ");
		find = scan.next();
		System.out.print("바꿀 문자열 입력 : ");
		change = scan.next();
		
		if(str.length() < find.length()){
			System.out.println("입력한 문자열의 크기가 작습니다");

		}else {
			str = str.toLowerCase(); // 입력받은 문자열을 소문자로 바꾸기 
			find = find.toLowerCase(); // 현재 문자열도 소문자로 
			
			while((index = str.indexOf(find, index)) != -1){ // 현재의 위치에서(index) 글자를 찾아라 
			// 그리고 찾은 것을 다시 index로 준다. 
			// 만약 찾지 못해서 -1이 나오는 경우가 아니면 while문이 돌아간다 
				index += find.length();
				// 인덱스에서 찾고자하는 문자열의 길이를 더해서 다시 또 find를 찾는다 
				count++;
				// 한번 찾을 때마다 count를 1더한다 
			} // while 

			System.out.println(str.replace(find, change));
			// find를 찾아서 change로 바꿔라 
			System.out.println(count + "회 치환 " );


		}
	

		 
	}
}