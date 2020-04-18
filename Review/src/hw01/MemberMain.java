package hw01;

import java.util.Scanner;

public class MemberMain {
	Scanner scan = new Scanner(System.in);
	MemberDTO[] arr = new MemberDTO[5]; // 5먕의 정보만 받음

	public void menu() {
		while (true) {
			System.out.println("1. 가입  2. 출력  3. 수정   4. 탈퇴   5. 끝");
			int choice = scan.nextInt();

			if (choice == 5) {
				System.out.println("프로그램을 종료합니다. ");  
				break;
			}

			if (choice == 1) {                         
				// 가입
				insert();
			} else if (choice == 2) {
				// 출력
				list();
			} else if (choice == 3) {
				// 수정
				update();
			} else if (choice == 5) {
				// 탈퇴
				delete();
			} else {
				System.out.println("1에서 5사이의 숫자만 입력해주세요 ");
			}

		} // while
	} // menu()

	// 가입
	public void insert() {
		System.out.println();
		int i; 
		for(i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				arr[i] = new MemberDTO();
				System.out.print("이름: ");
				arr[i].setName(scan.next());
				System.out.print("나이: ");
				arr[i].setAge(scan.nextInt());
				System.out.print("핸드폰번호: ");
				arr[i].setPhone(scan.next());
				System.out.print("주소: ");
				arr[i].setAddress(scan.next());
				
				
				break;
			}
		}// for i
	
		
		if(i == arr.length) {
			System.out.println("정원 초과입니다");
			return; 
			
		}// if
		
		int count = 0; 
		for(i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				count++; //빈자리를 센다 
			}
		}
		System.out.println("1 row created");
		System.out.println(count + "자리가 남았습니다");
	}// insert
	
	public void list() {
		System.out.println();
		
		System.out.println("이름\t나이\t핸드폰\t\t주소");
		for(MemberDTO data : arr) {
			if(data != null) {
				System.out.println(data.getName()+"\t"
						 + data.getAge()+"\t"
						 + data.getPhone()+"\t"
						 + data.getAddress());
			}
		} // for data

	} // list()
	
	public void update() {
		System.out.println("수정을 위해 전화번호를 입력해주세요 ");
		String inputPh = scan.next();
		
		int i;
		for(i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				if(arr[i].getPhone().equals(inputPh)) {
					System.out.println(arr[i].getName()+"\t"
							 + arr[i].getAge()+"\t"
							 + arr[i].getPhone()+"\t"
							 + arr[i].getAddress());
					
					// 수정 
					
		
					System.out.print("수정할 이름 입력 : ");
					arr[i].setName(scan.next());
					System.out.print("수정할 나이 입력 : ");
					arr[i].setAge(scan.nextInt());
					System.out.print("전화번호  : ");
					arr[i].setPhone(scan.next());
					System.out.print("주소 : ");
					arr[i].setAddress(scan.next());
					
					System.out.println("1 row updated");
					
					break;
				}
			}
		}// for i

		
		if(i == arr.length) {
			System.out.println("찾는 회원이 없습니다");
		}
	}// update()
	
	//삭제 
	public void delete() {
		System.out.println("찾는 전화번호를 입력해주세요 ");
		String inputPh = scan.next();
		
		int i; 
		for(i = 0; i < arr.length; i++) {
			if(arr[i].getPhone().equals(inputPh)) {
				arr[i] = null;
				System.out.println("1 row deleted");
				break;
			}
		}// for i
		
		if(i == arr.length) {
			System.out.println("찾는 회원이 없습니다.");
			return;
		}
	}// delete()	
	
	

	public static void main(String[] args) {
		MemberMain m = new MemberMain();
		m.menu();
		System.out.println("프로그램을 종료합니다. ");
	}

}
