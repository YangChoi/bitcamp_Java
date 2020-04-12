package homework;

import java.util.Scanner;

class MemberDTO {
	private String name;
	private int age;
	private String phone, address;

	public MemberDTO() {
	}

	// ������ �ޱ�
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

// �޼ҵ�
class MemberUtil {

	// �ε��� ã���ִ� �޼ҵ�
	public static int indexOf(MemberDTO[] arr, String keyword) {
		for (int i = 0; i < arr.length; i++) {
			if (keyword.equals(arr[i])) {
				return i;
			}
		}
		return -1; // ã�� �� ���� ���
	}

	// ����
	public void insert(Scanner scan, MemberDTO[] arr, String name, int age, String phone, String address, int count) {

	}

	// ����Ʈ ���
	public MemberDTO[] list(MemberDTO[] arr, String name, int age, String phone, String address) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("�̸�" + "\t\t" + "����" + "\t\t" + "�ڵ���" + "\t" + "�ּ�");
			System.out.print(arr[i].getName() + "\t\t" + arr[i].getAge() + "\t\t" + arr[i].getPhone() + "\t"
					+ arr[i].getAddress());
		}
		return arr;

	}

	// ����
	public MemberDTO[] update(Scanner scan, MemberDTO[] arr) {
		
		MemberDTO dto = new MemberDTO();
		
		System.out.println("�����ϱ� ");
		
		System.out.print("������ �̸� �Է� : ");
		dto.name = scan.next();
		System.out.print("������ ���� �Է� : ");
		dto.age = scan.nextInt();
		System.out.print("������  �ڵ��� �Է� : ");
		dto.phone = scan.next();
		System.out.print("������ �ּ� �Է� : ");
		dto.address = scan.next();
		scan.nextLine();
		
		return arr;

	}

	// Ż��
	public void remove(Scanner scan, MemberDTO[] arr, String name, int age, String phone, String address) {

		System.out.print("������ �ڵ��� ��ȣ�� �Է����ּ��� : ");
		String choicePh = scan.next();

		int index = indexOf(arr, choicePh);

		if (index != -1) {
			if (choicePh != null) { // ��ȣ�� ����� ������ ���� 

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
				System.out.println("�������� �ʴ� ��ȣ�Դϴ�.");
			}
		}

		System.out.println("���� �Ǿ����ϴ�.");
	}

}

public class MemberMain {

	public static void main(String[] args) {

		String name;
		int age;
		String phone;
		String address;
		int count;// �ڸ� ����

		Scanner scan = new Scanner(System.in);
		MemberDTO[] arr = new MemberDTO[5];
		// 5���� ����� ���� ��ü����

		MemberUtil mu = new MemberUtil(); // non static method
		
		count = 0;
		
		while (true) {
			System.out.println("1. ����  2. ���    3. ����   4. Ż��   5. ������ ");
			int choice = scan.nextInt();
	

			// ���� insert
			if (choice == 1) {
				
				if (count < 5) { // �ڸ��� ������
					// �Է�
					arr[count] = new MemberDTO(); // �ּ��ְ�

					System.out.print("�̸�  : ");
					name = scan.next();
					System.out.print("����  : ");
					age = scan.nextInt();
					scan.nextLine();
					
					System.out.print("��ȭ��ȣ  : ");
					phone = scan.next();
					System.out.print("�ּ� : ");
					address = scan.next();
					scan.nextLine(); // �Է¹ް�

					arr[count] = new MemberDTO(name, age, phone, address); // �� �ְ�
					count++; // COUNT +1

					System.out.println("1 row created");
					System.out.println((5 - count) + " �ڸ� ���ҽ��ϴ�."); // ���ڸ����� COUNT ����

				} else {
					// �����ʰ�
					System.out.println("5�� ���� �ʰ��Դϴ�.");
					mu.list(arr, name, age, phone, address);
				}
			} else if (choice == 2) {
				// ���
				mu.list(arr, name, age, phone, address);
				
			} else if (choice == 3) {
				// ����
				// new MemberUtil().update();
			} else if (choice == 4) {
				// Ż��
				mu.remove(scan, arr, name, age, phone, address);

			} else if (choice == 5) {
				System.out.println("�����մϴ�");
				break;
			} // if
		} // while

	}

}
