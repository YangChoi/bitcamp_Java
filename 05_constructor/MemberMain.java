import java.util.Scanner;

class MemberMain{
	Scanner scan = new Scanner(System.in);
		// 원래를 메모리 잡아먹으니까 처음부터 Scanner 선언하는 것을 선호하진 않는다. 
	MemberDTO[] arr = new MemberDTO[5]; 
	// 클래스 전체가 끝날 때까지 살아있는 arr
	// 따라서 main 밖, class 안에 선언해놓는다. 
	

	public void menu(){
		// static 없는 상태 : 호출 시 클래스 객체 생성해주어야한다..
		int choice;

		while(true){
			System.out.println();
			System.out.println("=======================================================");
			System.out.println("1. 가입  2. 출력  3. 수정   4. 탈퇴   5. 끝내기");
			System.out.println("=======================================================");
			choice = scan.nextInt();

			if(choice == 5){
				// 끝내기 
				break; //while 나감 
			}

			if(choice == 1){
				// 가입
				this.insert(); // main과 똑같은 주소값을 가지고 있기 때문에 this 생략된 꼴 
 
			}else if(choice == 2){
				// 출력
				list(); // 얘도 this 생략된 꼴 

			}else if(choice == 3){
				// 수정
				update();

			}else if(choice == 4){
				// 탈퇴 
				delete();

			}else{
				System.out.println("1에서 5번 사이의 숫자만 입력하세요");
			}


		} // while문
	} // menu()

	public void insert(){
		// 추가할 때 그 배열이 arr[0]일지 arr[2]일지 모르는 상태 
		// 내가 어디까지 만들어놨는지 모르기 때문에 null 값을 확인해서 비어있는 곳을 알아야한다. 
		int i; 
		for(i = 0; i < arr.length; i++){
			if(arr[i] == null){
				break; // null이면 나와라 
			}

			if(i == arr.length){
				// 배열이 꽉찼다 
				System.out.println("정원 초과 입니다");
				return; // 메소드 벗어나기 
				
			}
		}// for

			// null확인 다 끝난 후 공간확보를 했으면 입력 
			arr[i] = new MemberDTO(); 
			System.out.print("이름  : ");
			arr[i].setName(scan.next());
			System.out.print("나이  : ");
			arr[i].setAge(scan.nextInt());
			System.out.print("전화번호  : ");
			arr[i].setPhone(scan.next());
			System.out.print("주소 : ");
			arr[i].setAddress(scan.next());
			

			// 남은 자리 세기 
			int count = 0; 
			for(i = 0; i < arr.length; i++){
				if(arr[i] == null){
					count++;
				}
				
			}
			System.out.println("1 row created");
			System.out.println(count + " 자리 남았습니다. ");
			
	}// insert()

	public void update(){
		
		System.out.print("수정을 위해 핸드폰 번호를 입력해주세요 " );
		String phone = scan.next();
		
		int i;
		for(i = 0; i < arr.length; i++){
			if(arr[i] != null){
				// null이면 dto도 없으니까 찾을 필요도 없음
				if(arr[i].getPhone().equals(phone)){
					// 있는 정보와 입력한 정보가 같은지
					
					// 해당 정보한번 출력해주기 
					System.out.println("이름" + "\t\t" + "나이" + "\t\t" + "핸드폰" + "\t" + "주소");
					System.out.println("=======================================================");
					System.out.println(arr[i].getName() + "\t\t" + arr[i].getAge() + "\t\t" + arr[i].getPhone() + "\t"
					+ arr[i].getAddress());
					
					// 수정
					System.out.print("수정할 이름 입력 : ");
					arr[i].setName(scan.next());
					System.out.print("수정할 나이 입력 : ");
					arr[i].setAge(scan.nextInt());
					System.out.print("수정할 전화번호 입력 : ");
					arr[i].setPhone(scan.next());
					System.out.print("수정할 주소 입력 : ");
					arr[i].setAddress(scan.next());
					
					System.out.println("1 row updated");

					
					break;
				}
			}
		}// for

		if(i == arr.length){
			// 5번 다 돈 경우는 없다는 것 
			System.out.println("없는 정보입니다.");
		}
		
	}// update()

	public void list() {
		System.out.println("이름" + "\t\t" + "나이" + "\t\t" + "핸드폰" + "\t" + "주소");
		System.out.println("=======================================================");
		for(MemberDTO data : arr){
			if(data != null) { //  null이 아닌 것만 찍기 
				System.out.print(data.getName() + "\t\t" + data.getAge() + "\t\t" + data.getPhone() + "\t"
					+ data.getAddress());
			}
		}
	
	}// list()
	
	public void delete(){
		
		System.out.print("수정을 위해 핸드폰 번호를 입력해주세요 " );
		String phone = scan.next();
		
		int i;
		for(i = 0; i < arr.length; i++){
			if(arr[i] != null){
				// null이면 dto도 없으니까 찾을 필요도 없음
				if(arr[i].getPhone().equals(phone)){
					// 있는 정보와 입력한 정보가 같은지
					arr[i] = null;
					System.out.println("1 row deleted");
					break;
				}
			}
		}// for

		if( i == arr.length){
			System.out.println("찾는 정보가 없습니다.");
		}
		
	} // delete()


	public static void main(String[] args){
		MemberMain main = new MemberMain(); // static 없는 메소드 호출을 위해서 클래스 객체 생성 

		main.menu(); // 위의 menu 메소드에 갔다가 실행하고 다시 여기로 내려옴 
		// 여기로 다시 돌아온 것은 5번을 입력해서 while문을 나온 것이기 때문에 
		// 종료되었다는 뜻 
		System.out.println("프로그램을 종료합니다");
		

	} // main()
}