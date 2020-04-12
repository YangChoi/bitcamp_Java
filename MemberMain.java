package homework;

import java.util.Scanner;

class MemberDTO {
	private String name;
	private int age;
	private String phone, address;

	public MemberDTO() {
	}

	// 데이터 받기
	public MemberDTO(String name, int age, String phone, String address) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	// get
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
}

// 메소드
class MemberUtil {

	// 인덱스 찾아주는 메소드
	public static int indexOf(MemberDTO[] arr, String keyword) {
		for (int i = 0; i < arr.length; i++) {
			if (keyword.equals(arr[i])) {
				return i;
			}
		}
		return -1; // 찾는 값 없는 경우
	}

	// 가입
	public void insert(Scanner scan, MemberDTO[] arr, String name, int age, String phone, String address, int count) {

	}

	// 리스트 출력
	public MemberDTO[] list(MemberDTO[] arr, String name, int age, String phone, String address) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("이름" + "\t\t" + "나이" + "\t\t" + "핸드폰" + "\t" + "주소");
			System.out.print(arr[i].getName() + "\t\t" + arr[i].getAge() + "\t\t" + arr[i].getPhone() + "\t"
					+ arr[i].getAddress());
		}
		return arr;

	}

	// 수정
	public MemberDTO[] update(Scanner scan, MemberDTO[] arr) {
		
		MemberDTO dto = new MemberDTO();
		
		System.out.println("수정하기 ");
		
		System.out.print("수정할 이름 입력 : ");
		dto.name = scan.next();
		System.out.print("수정할 나이 입력 : ");
		dto.age = scan.nextInt();
		System.out.print("수정할  핸드폰 입력 : ");
		dto.phone = scan.next();
		System.out.print("수정할 주소 입력 : ");
		dto.address = scan.next();
		scan.nextLine();
		
		return arr;

	}

	// 탈퇴
	public void remove(Scanner scan, MemberDTO[] arr, String name, int age, String phone, String address) {

		System.out.print("삭제할 핸드폰 번호를 입력해주세요 : ");
		String choicePh = scan.next();

		int index = indexOf(arr, choicePh);

		if (index != -1) {
			if (choicePh != null) { // 번호가 제대로 있으면 삭제 

				MemberDTO[] front = new MemberDTO[index];

				for (int i = 0; i < arr.length; i++) {
					front[i] = arr[i];

				}

				MemberDTO[] back = new MemberDTO[arr.length + front.length - 1];

				int backIndex = 0;
				for (int i = index + 1; i < arr.length; i++) {
					back[backIndex] = arr[i];
					backIndex++;
				}

				arr = new MemberDTO[front.length + back.length];

				backIndex = front.length;
				for (int i = 0; i < back.length; i++) {
					arr[backIndex] = back[i];
					backIndex++;
				}
			}else {
				System.out.println("존재하지 않는 번호입니다.");
			}
		}

		System.out.println("삭제 되었습니다.");
	}

}

public class MemberMain {

	public static void main(String[] args) {

		String name;
		int age;
		String phone;
		String address;
		int count;// 자리 세기

		Scanner scan = new Scanner(System.in);
		MemberDTO[] arr = new MemberDTO[5];
		// 5명의 멤버가 들어가는 객체변수

		MemberUtil mu = new MemberUtil(); // non static method
		
		count = 0;
		
		while (true) {
			System.out.println("1. 가입  2. 출력    3. 수정   4. 탈퇴   5. 끝내기 ");
			int choice = scan.nextInt();
	

			// 가입 insert
			if (choice == 1) {
				
				if (count < 5) { // 자리가 있으면
					// 입력
					arr[count] = new MemberDTO(); // 주소주고

					System.out.print("이름  : ");
					name = scan.next();
					System.out.print("나이  : ");
					age = scan.nextInt();
					scan.nextLine();
					
					System.out.print("전화번호  : ");
					phone = scan.next();
					System.out.print("주소 : ");
					address = scan.next();
					scan.nextLine(); // 입력받고

					arr[count] = new MemberDTO(name, age, phone, address); // 값 주고
					count++; // COUNT +1

					System.out.println("1 row created");
					System.out.println((5 - count) + " 자리 남았습니다."); // 총자리에서 COUNT 빼기

				} else {
					// 정원초과
					System.out.println("5명 정원 초과입니다.");
					mu.list(arr, name, age, phone, address);
				}
			} else if (choice == 2) {
				// 출력
				mu.list(arr, name, age, phone, address);
				
			} else if (choice == 3) {
				// 수정
				// new MemberUtil().update();
			} else if (choice == 4) {
				// 탈퇴
				mu.remove(scan, arr, name, age, phone, address);

			} else if (choice == 5) {
				System.out.println("종료합니다");
				break;
			} // if
		} // while

	}

}
