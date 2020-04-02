package coronaProject;

import java.util.Scanner;

import util.MyScanner;

public class CoronaEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Nation[] world = null;
		City[] cities = null;
		
		while (true) {
			// 메뉴를 출력한다.
			// 1. 세계 현황보기
			// 2. 한국 현황보기
			// 3. 종료
			System.out.println("==== 코로나 상황판 ====");
			System.out.println("1. 세계 현황  2. 한국현황  3. 종료");
			System.out.print(">>");
			int choice = MyScanner.nextInt(scan);
			// 세계 현황
			if (choice == 1) {
				// 1, 2, 3 옵션 보여주는 메소드
				// choice가 1이면 새로 입력, 2면 출력, 3이면 종료 
				choice = showMenu(scan);
				if (choice == 1) {
					// 입력하기
					// 입력하기 눌렀을 때 Nation[]이 null 이면 곧장 입력하기 누르고
					// 만약 null이 아니면 전체수정인지 개별수정인지 묻는다.
					if (world == null) {
						// 비어 있으면 입력하는 메소드
						world = NationUtil.start(scan);
					} else {
						System.out.println("1. 전체 다시 수정   2. 개별수정");
						System.out.print(">>>>");
						choice = MyScanner.nextInt(scan);
						// update 메소드
						if (choice == 1) {
							// 전체 다시 수정
							world = NationUtil.start(scan);
						} else {
							// 개별 수정
							// 현재 상태 전체를 출력하고
							// 수정할 나라의 번호 선택
							NationUtil.print(world);
							System.out.print("수정할 번호를 입력하세요 : ");
							// 번호 수정하는 인덱스 만듦
							int index = validateIndex(scan, world.length);
							// index에 적합한 숫자를 입력받으면 update 메소드 실행
							world = NationUtil.update(world, index, scan);
						}
					}
				} else if (choice == 2) {
					// 출력하기
					// 출력메소드 실행하되 world가 널인지 체크해서 널 아닐때에 실행
					if (world != null) {
						NationUtil.print(world);
					} else {
						// 경고 메세지만 출력
						System.out.println("아직 입력된 정보가 없습니다. ");
					}
				} else if (choice == 3) {
					// 뒤로가기
					break;
				}

				// 한국현황
			} else if (choice == 2) {
				// 1, 2, 3 옵션 보여주는 메소드 
				choice = showMenu(scan);
				
				if (choice == 1) {
					// 입력하기
					if (cities == null) {
						cities = CityUtil.start(scan);
					} else {
						System.out.println("1. 전체 다시 수정   2. 개별수정");
						System.out.print(">>>>");
						choice = MyScanner.nextInt(scan);
						if (choice == 1) {
							// 전체 수정
							cities = CityUtil.start(scan);
						} else {
							// 개별 수정
							CityUtil.print(cities);
							System.out.print("수정할 번호를 입력하세요 : ");
							// 번호 수정하는 인덱스 만듦
							int index = validateIndex(scan, cities.length);
							cities = CityUtil.update(index, scan, cities);
						}
					}

				} else if (choice == 2) {
					// 출력하기
					if (cities != null) {
						CityUtil.print(cities);
					}
				} else {
					// 뒤로
					System.out.println("아직 입력된 정보가 없습니다. ");
				}

				// 프로그램종료
			} else if (choice == 3) {
				System.out.println("종료");
				break;
			}
		}
		scan.close();
	}

	// 적합한 번호가 나올 때 까지 번호 수정하는 메소드 validateIndex
	public static int validateIndex(Scanner scan, int length) {
		System.out.print("수정할 번호를 입력하세요 : ");
		int index = MyScanner.nextInt(scan) - 1;
		// i+1로 출력을 임의로 만들었기 때문에 (index값이 0부터 시작해서 출력되면 보기에 안좋으니까..)
		// 그래서 우리가 입력을 받을 때 사용자 입력 숫자 -1 을 해서 프로그램에 넣는다.
		while (index < 0 || index >= length) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("수정할 번호를 입력하세요. ");
			index = MyScanner.nextInt(scan) - 1;
			// 여기도 마찬가지로 -1 해주어야한다.
			// 아니면 1을 수정하라고 했는데
			// 보이는건 1번 인덱스(사용자 상의)인데 실제 인덱스인 0(프로그램상의)도 역시 수정이 된다.
		}
		return index;

	}

	// 1, 2, 3 옵션 보여주는 메소드 
	public static int showMenu(Scanner scan) {
		int choice = 0;
		System.out.println("1. 입력하기  2. 출력하기  3. 뒤로");
		System.out.print(">>>");
		choice = MyScanner.nextInt(scan);

		return choice;
	}
}
