import java.util.Scanner;

class MemberMain {
	Scanner scan = new Scanner(System.in);
	MemberDTO[] ar = new MemberDTO[5];
	
	public void menu(){
		int choice;

		while(true){
			System.out.println();
			System.out.println("************");
			System.out.println("   1. ����");
			System.out.println("   2. ���");
			System.out.println("   3. ����");
			System.out.println("   4. Ż��");
			System.out.println("   5. ��");
			System.out.println("************");
			System.out.print("   ��ȣ : ");
			choice = scan.nextInt();
			if(choice == 5) break;

			if(choice == 1) this.insert();
			else if(choice == 2) list();
			else if(choice == 3) update();
			else if(choice == 4) delete();
			else System.out.println("1 ~ 5�� ���ڸ� �Է��ϼ���");
		}//while
	}

	public void insert(){
		System.out.println();

		int i;
		for(i=0; i<ar.length; i++){
			if(ar[i] == null){
				ar[i] = new MemberDTO();
				System.out.print("�̸�  : ");
				ar[i].setName(scan.next());
				System.out.print("����  : ");
				ar[i].setAge(scan.nextInt());
				System.out.print("��ȭ��ȣ  : ");
				ar[i].setPhone(scan.next());
				System.out.print("�ּ� : ");
				ar[i].setAddress(scan.next());

				break;
			}
		}//for

		if(i==ar.length){
			System.out.println("5���� ������ �� á���ϴ�");
			return; //�޼ҵ带 �����
		}		
		
		int count=0;
		for(i=0; i<ar.length; i++){
			if(ar[i] == null) count++;
		}
		System.out.println("1 row created");
		System.out.println(count+"�ڸ� ���ҽ��ϴ�");
	}

	public void list(){
		System.out.println();
		System.out.println("�̸�\t����\t�ڵ���\t\t�ּ�");
		for(MemberDTO data : ar){
			if(data != null){
				System.out.println(data.getName()+"\t"
								 + data.getAge()+"\t"
								 + data.getPhone()+"\t"
								 + data.getAddress());
			}
		}
	}

	public void update(){
		System.out.println();
		System.out.print("�ڵ��� ��ȣ �Է� : ");
		String phone = scan.next();
		int i;
		for(i=0; i<ar.length; i++){
			if(ar[i] != null){
				if(ar[i].getPhone().equals(phone)){
					System.out.println(ar[i].getName()+"\t"
								 + ar[i].getAge()+"\t"
								 + ar[i].getPhone()+"\t"
								 + ar[i].getAddress());

					//����
					System.out.println();
					System.out.print("������ �̸� �Է� : ");
					ar[i].setName(scan.next());
					System.out.print("��ȭ��ȣ  : ");
					ar[i].setPhone(scan.next());
					System.out.print("�ּ� : ");
					ar[i].setAddress(scan.next());

					System.out.println("1 row(s) updated");

					break;
				}
			}
		}//for

		if(i==ar.length)
			System.out.println("ã�� ȸ���� �����ϴ�");
	}

	public void delete(){
		System.out.println();
		System.out.print("�ڵ��� ��ȣ �Է� : ");
		String phone = scan.next();
		int i;
		for(i=0; i<ar.length; i++){
			if(ar[i] != null){
				if(ar[i].getPhone().equals(phone)){
					ar[i] = null;
					System.out.println("1 row(s) deleted");
					break;
				}
			}
		}//for

		if(i==ar.length)
			System.out.println("ã�� ȸ���� �����ϴ�");
	}

	public static void main(String[] args) {
		MemberMain main = new MemberMain();
		main.menu();
		System.out.println("���α׷��� �����մϴ�");
	}
}
