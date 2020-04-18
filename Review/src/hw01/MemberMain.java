package hw01;

import java.util.Scanner;

public class MemberMain {
	Scanner scan = new Scanner(System.in);
	MemberDTO[] arr = new MemberDTO[5]; // 5���� ������ ����

	public void menu() {
		while (true) {
			System.out.println("1. ����  2. ���  3. ����   4. Ż��   5. ��");
			int choice = scan.nextInt();

			if (choice == 5) {
				System.out.println("���α׷��� �����մϴ�. ");  
				break;
			}

			if (choice == 1) {                         
				// ����
				insert();
			} else if (choice == 2) {
				// ���
				list();
			} else if (choice == 3) {
				// ����
				update();
			} else if (choice == 5) {
				// Ż��
				delete();
			} else {
				System.out.println("1���� 5������ ���ڸ� �Է����ּ��� ");
			}

		} // while
	} // menu()

	// ����
	public void insert() {
		System.out.println();
		int i; 
		for(i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				arr[i] = new MemberDTO();
				System.out.print("�̸�: ");
				arr[i].setName(scan.next());
				System.out.print("����: ");
				arr[i].setAge(scan.nextInt());
				System.out.print("�ڵ�����ȣ: ");
				arr[i].setPhone(scan.next());
				System.out.print("�ּ�: ");
				arr[i].setAddress(scan.next());
				
				
				break;
			}
		}// for i
	
		
		if(i == arr.length) {
			System.out.println("���� �ʰ��Դϴ�");
			return; 
			
		}// if
		
		int count = 0; 
		for(i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				count++; //���ڸ��� ���� 
			}
		}
		System.out.println("1 row created");
		System.out.println(count + "�ڸ��� ���ҽ��ϴ�");
	}// insert
	
	public void list() {
		System.out.println();
		
		System.out.println("�̸�\t����\t�ڵ���\t\t�ּ�");
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
		System.out.println("������ ���� ��ȭ��ȣ�� �Է����ּ��� ");
		String inputPh = scan.next();
		
		int i;
		for(i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				if(arr[i].getPhone().equals(inputPh)) {
					System.out.println(arr[i].getName()+"\t"
							 + arr[i].getAge()+"\t"
							 + arr[i].getPhone()+"\t"
							 + arr[i].getAddress());
					
					// ���� 
					
		
					System.out.print("������ �̸� �Է� : ");
					arr[i].setName(scan.next());
					System.out.print("������ ���� �Է� : ");
					arr[i].setAge(scan.nextInt());
					System.out.print("��ȭ��ȣ  : ");
					arr[i].setPhone(scan.next());
					System.out.print("�ּ� : ");
					arr[i].setAddress(scan.next());
					
					System.out.println("1 row updated");
					
					break;
				}
			}
		}// for i

		
		if(i == arr.length) {
			System.out.println("ã�� ȸ���� �����ϴ�");
		}
	}// update()
	
	//���� 
	public void delete() {
		System.out.println("ã�� ��ȭ��ȣ�� �Է����ּ��� ");
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
			System.out.println("ã�� ȸ���� �����ϴ�.");
			return;
		}
	}// delete()	
	
	

	public static void main(String[] args) {
		MemberMain m = new MemberMain();
		m.menu();
		System.out.println("���α׷��� �����մϴ�. ");
	}

}
