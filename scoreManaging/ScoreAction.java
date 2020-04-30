package scoreManaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;


public class ScoreAction{
	private ArrayList<ScoreDTO> list;
	Scanner scan = new Scanner(System.in);

	public ScoreAction() {
		list = new ArrayList<ScoreDTO>();
	}

	public void menu() {
		int choice;
		while (true) {
			System.out.println();
			System.out.println("***성적 입력 프로그램***");
			System.out.println("   1. 입력");
			System.out.println("   2. 출력");
			System.out.println("   3. 검색");
			System.out.println("   4. 삭제");
			System.out.println("   5. 정렬");
			System.out.println("   6. 끝");
			System.out.println("*****************");
			System.out.print("   > ");

			choice = scan.nextInt();
			if (choice == 6) {
				System.out.println("종료합니다.");
				break; // 종료
			}

			if (choice == 1) {
				insert();
			} else if (choice == 2) {
				print();
			} else if (choice == 3) {
				search();
			} else if (choice == 4) {
				delete();
			} else if (choice == 5) {
				sort();
			}

		}
	}// menu()

	public void insert() {

		int no;
		int sw = 0;
		do {
			System.out.println();
			System.out.print("번호 입력 : ");
			no = scan.nextInt();

			if (list.isEmpty()) {
				sw = 1;
			}
			for (int i = 0; i < list.size(); i++) {
				if (no == list.get(i).getNo()) {
					sw = 0;
					System.out.println("중복된 회원입니다.");
				} else if (no != list.get(i).getNo()) {
					sw = 1;

				}
			} // for
		} while (sw != 1);

		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어 점수 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 점수 입력 : ");
		int math = scan.nextInt();

		ScoreDTO dto = new ScoreDTO(no, name, kor, eng, math);
		dto.calc();

		list.add(dto);
		System.out.println("입력 완료 ");

	}// insert()

	public void print() {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for (ScoreDTO dto : list) {
			System.out.println(dto);
		}

	}// print()

	public void search() {
		System.out.println();
		System.out.print("검색할 번호를 입력하세요 : ");
		int no = scan.nextInt();
		int sw = 0;
		for(ScoreDTO dto : list) {
			if(no == dto.getNo()) {
				System.out.println(dto);
				sw = 1;
			}
		}
		if(sw == 0) {
			System.out.println("찾는 정보가 없습니다. ");
		}
		
		
	}// search()

	public void delete() {
		System.out.println();
		System.out.print("삭제할 번호를 입력하세요 : ");
		int no = scan.nextInt();
		int sw = 0;

		Iterator<ScoreDTO> it = list.iterator();
		while (it.hasNext()) {
			ScoreDTO dto = it.next();
			if (no == dto.getNo()) {
				it.remove();
				sw = 1;
				System.out.println("데이터 삭제완료");
			}
		} // while
		if (sw == 0) {
			System.out.println("삭제할 정보가 없습니다. ");
		}

	}// delete()

	public void sort() {
		System.out.println();
		System.out.println("1. 이름으로 오름차순   2. 총점으로 내림차순   3. 이전메뉴");
		int choice = scan.nextInt();
		
		if(choice ==3) {
			System.out.println("이전 메뉴로 돌아갑니다.");
			return;
		}
		if(choice == 1) {
			// 이름으로 오름차순
			Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {
				@Override
				public int compare(ScoreDTO dto, ScoreDTO dto2) {
					return dto.getName().compareTo(dto2.getName());
				}
			};
			System.out.println("******이름으로 오름차순******");
			Collections.sort(list, com);
			print();
		}else if(choice == 2){
			// 총점으로 내림차순
			System.out.println("******총점으로 내림차순******");
			Collections.sort(list);
			print();
		}
	}

}
