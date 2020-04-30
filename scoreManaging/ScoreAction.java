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
			System.out.println("***���� �Է� ���α׷�***");
			System.out.println("   1. �Է�");
			System.out.println("   2. ���");
			System.out.println("   3. �˻�");
			System.out.println("   4. ����");
			System.out.println("   5. ����");
			System.out.println("   6. ��");
			System.out.println("*****************");
			System.out.print("   > ");

			choice = scan.nextInt();
			if (choice == 6) {
				System.out.println("�����մϴ�.");
				break; // ����
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
			System.out.print("��ȣ �Է� : ");
			no = scan.nextInt();

			if (list.isEmpty()) {
				sw = 1;
			}
			for (int i = 0; i < list.size(); i++) {
				if (no == list.get(i).getNo()) {
					sw = 0;
					System.out.println("�ߺ��� ȸ���Դϴ�.");
				} else if (no != list.get(i).getNo()) {
					sw = 1;

				}
			} // for
		} while (sw != 1);

		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� ���� �Է� : ");
		int kor = scan.nextInt();
		System.out.print("���� ���� �Է� : ");
		int eng = scan.nextInt();
		System.out.print("���� ���� �Է� : ");
		int math = scan.nextInt();

		ScoreDTO dto = new ScoreDTO(no, name, kor, eng, math);
		dto.calc();

		list.add(dto);
		System.out.println("�Է� �Ϸ� ");

	}// insert()

	public void print() {
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for (ScoreDTO dto : list) {
			System.out.println(dto);
		}

	}// print()

	public void search() {
		System.out.println();
		System.out.print("�˻��� ��ȣ�� �Է��ϼ��� : ");
		int no = scan.nextInt();
		int sw = 0;
		for(ScoreDTO dto : list) {
			if(no == dto.getNo()) {
				System.out.println(dto);
				sw = 1;
			}
		}
		if(sw == 0) {
			System.out.println("ã�� ������ �����ϴ�. ");
		}
		
		
	}// search()

	public void delete() {
		System.out.println();
		System.out.print("������ ��ȣ�� �Է��ϼ��� : ");
		int no = scan.nextInt();
		int sw = 0;

		Iterator<ScoreDTO> it = list.iterator();
		while (it.hasNext()) {
			ScoreDTO dto = it.next();
			if (no == dto.getNo()) {
				it.remove();
				sw = 1;
				System.out.println("������ �����Ϸ�");
			}
		} // while
		if (sw == 0) {
			System.out.println("������ ������ �����ϴ�. ");
		}

	}// delete()

	public void sort() {
		System.out.println();
		System.out.println("1. �̸����� ��������   2. �������� ��������   3. �����޴�");
		int choice = scan.nextInt();
		
		if(choice ==3) {
			System.out.println("���� �޴��� ���ư��ϴ�.");
			return;
		}
		if(choice == 1) {
			// �̸����� ��������
			Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {
				@Override
				public int compare(ScoreDTO dto, ScoreDTO dto2) {
					return dto.getName().compareTo(dto2.getName());
				}
			};
			System.out.println("******�̸����� ��������******");
			Collections.sort(list, com);
			print();
		}else if(choice == 2){
			// �������� ��������
			System.out.println("******�������� ��������******");
			Collections.sort(list);
			print();
		}
	}

}
