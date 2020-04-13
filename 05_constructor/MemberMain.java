import java.util.Scanner;

class MemberMain{
	Scanner scan = new Scanner(System.in);
		// ������ �޸� ��Ƹ����ϱ� ó������ Scanner �����ϴ� ���� ��ȣ���� �ʴ´�. 
	MemberDTO[] arr = new MemberDTO[5]; 
	// Ŭ���� ��ü�� ���� ������ ����ִ� arr
	// ���� main ��, class �ȿ� �����س��´�. 
	

	public void menu(){
		// static ���� ���� : ȣ�� �� Ŭ���� ��ü �������־���Ѵ�..
		int choice;

		while(true){
			System.out.println();
			System.out.println("=======================================================");
			System.out.println("1. ����  2. ���  3. ����   4. Ż��   5. ������");
			System.out.println("=======================================================");
			choice = scan.nextInt();

			if(choice == 5){
				// ������ 
				break; //while ���� 
			}

			if(choice == 1){
				// ����
				this.insert(); // main�� �Ȱ��� �ּҰ��� ������ �ֱ� ������ this ������ �� 
 
			}else if(choice == 2){
				// ���
				list(); // �굵 this ������ �� 

			}else if(choice == 3){
				// ����
				update();

			}else if(choice == 4){
				// Ż�� 
				delete();

			}else{
				System.out.println("1���� 5�� ������ ���ڸ� �Է��ϼ���");
			}


		} // while��
	} // menu()

	public void insert(){
		// �߰��� �� �� �迭�� arr[0]���� arr[2]���� �𸣴� ���� 
		// ���� ������ ���������� �𸣱� ������ null ���� Ȯ���ؼ� ����ִ� ���� �˾ƾ��Ѵ�. 
		int i; 
		for(i = 0; i < arr.length; i++){
			if(arr[i] == null){
				break; // null�̸� ���Ͷ� 
			}

			if(i == arr.length){
				// �迭�� ��á�� 
				System.out.println("���� �ʰ� �Դϴ�");
				return; // �޼ҵ� ����� 
				
			}
		}// for

			// nullȮ�� �� ���� �� ����Ȯ���� ������ �Է� 
			arr[i] = new MemberDTO(); 
			System.out.print("�̸�  : ");
			arr[i].setName(scan.next());
			System.out.print("����  : ");
			arr[i].setAge(scan.nextInt());
			System.out.print("��ȭ��ȣ  : ");
			arr[i].setPhone(scan.next());
			System.out.print("�ּ� : ");
			arr[i].setAddress(scan.next());
			

			// ���� �ڸ� ���� 
			int count = 0; 
			for(i = 0; i < arr.length; i++){
				if(arr[i] == null){
					count++;
				}
				
			}
			System.out.println("1 row created");
			System.out.println(count + " �ڸ� ���ҽ��ϴ�. ");
			
	}// insert()

	public void update(){
		
		System.out.print("������ ���� �ڵ��� ��ȣ�� �Է����ּ��� " );
		String phone = scan.next();
		
		int i;
		for(i = 0; i < arr.length; i++){
			if(arr[i] != null){
				// null�̸� dto�� �����ϱ� ã�� �ʿ䵵 ����
				if(arr[i].getPhone().equals(phone)){
					// �ִ� ������ �Է��� ������ ������
					
					// �ش� �����ѹ� ������ֱ� 
					System.out.println("�̸�" + "\t\t" + "����" + "\t\t" + "�ڵ���" + "\t" + "�ּ�");
					System.out.println("=======================================================");
					System.out.println(arr[i].getName() + "\t\t" + arr[i].getAge() + "\t\t" + arr[i].getPhone() + "\t"
					+ arr[i].getAddress());
					
					// ����
					System.out.print("������ �̸� �Է� : ");
					arr[i].setName(scan.next());
					System.out.print("������ ���� �Է� : ");
					arr[i].setAge(scan.nextInt());
					System.out.print("������ ��ȭ��ȣ �Է� : ");
					arr[i].setPhone(scan.next());
					System.out.print("������ �ּ� �Է� : ");
					arr[i].setAddress(scan.next());
					
					System.out.println("1 row updated");

					
					break;
				}
			}
		}// for

		if(i == arr.length){
			// 5�� �� �� ���� ���ٴ� �� 
			System.out.println("���� �����Դϴ�.");
		}
		
	}// update()

	public void list() {
		System.out.println("�̸�" + "\t\t" + "����" + "\t\t" + "�ڵ���" + "\t" + "�ּ�");
		System.out.println("=======================================================");
		for(MemberDTO data : arr){
			if(data != null) { //  null�� �ƴ� �͸� ��� 
				System.out.print(data.getName() + "\t\t" + data.getAge() + "\t\t" + data.getPhone() + "\t"
					+ data.getAddress());
			}
		}
	
	}// list()
	
	public void delete(){
		
		System.out.print("������ ���� �ڵ��� ��ȣ�� �Է����ּ��� " );
		String phone = scan.next();
		
		int i;
		for(i = 0; i < arr.length; i++){
			if(arr[i] != null){
				// null�̸� dto�� �����ϱ� ã�� �ʿ䵵 ����
				if(arr[i].getPhone().equals(phone)){
					// �ִ� ������ �Է��� ������ ������
					arr[i] = null;
					System.out.println("1 row deleted");
					break;
				}
			}
		}// for

		if( i == arr.length){
			System.out.println("ã�� ������ �����ϴ�.");
		}
		
	} // delete()


	public static void main(String[] args){
		MemberMain main = new MemberMain(); // static ���� �޼ҵ� ȣ���� ���ؼ� Ŭ���� ��ü ���� 

		main.menu(); // ���� menu �޼ҵ忡 ���ٰ� �����ϰ� �ٽ� ����� ������ 
		// ����� �ٽ� ���ƿ� ���� 5���� �Է��ؼ� while���� ���� ���̱� ������ 
		// ����Ǿ��ٴ� �� 
		System.out.println("���α׷��� �����մϴ�");
		

	} // main()
}