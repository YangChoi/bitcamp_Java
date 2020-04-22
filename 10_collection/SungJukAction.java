import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class SungJukAction {
	Scanner scan = new Scanner(System.in);
	private ArrayList<SungJukDTO> list;  // ��� ���� ������ ���� 
	/*
	����Ʈ �ʱ�ȭ �ϴ� �ٸ� ��� 
	
	*/
	
	public SungJukAction(){
		list = new ArrayList<SungJukDTO>(); 
	}

	public void menu() {
		int choice;
		while (true) {
			System.out.println();
			System.out.println("1~6 �߿��� �����ϼ���");
			System.out.println("*****************");
			System.out.println("	1.�Է�");
			System.out.println("	2.���");
			System.out.println("	3.�˻�");
			System.out.println("	4.����");
			System.out.println("	5.����");
			System.out.println("	6.��");
			System.out.println("*****************");
			System.out.println();
			System.out.print("��ȣ : ");
			choice = scan.nextInt();

			// ������ ���� ���� ���� �������ش�. 
			if(choice == 6){
				System.out.println("�ý����� �����մϴ�");
				break; 
			}
			// if �� ���޾� ���� ������ ����� ������ ���α׷��� �ణ ������ ���� �ִ�. 
			// �׷��� else if�� ����. 
			// ���ǿ� �´� if���� ã���� �Ʒ��� ���ǵ��� �� ���캸�� �ʴ´�. 
			// 6�� ��쿣 ���ٰ� ���ƿ��� �ְ� �ƴϰ� �ƿ� ���������� ������ else if �ǹ̰� ����. 

			if (choice == 1) {
				insertArticle();
			} else if (choice == 2) {
				printArticle();
			} else if (choice == 3) {
				searchArticle();
			} else if (choice == 4) {
				deleteArticle();
			} else if (choice == 5) {
				sortArticle();
			}// if
		}// while
	}// menu()

	// �Է�
	public void insertArticle() {
			int no;
			System.out.print("��ȣ�Է� : ");
			no = scan.nextInt();
			/*
			for(SungJukDTO dto : list){
				if(no == dto.getNo()){
					System.out.println("�ߺ��� ��ȣ�Դϴ�.");
					return;
				}
			} // for dto 
			*/
			for(int i=0; i<list.size(); i++){
			if(no == list.get(i).getNo()){
				System.out.println("�ߺ��� ��ȣ�Դϴ�");
				return;
				}
			}

	

		System.out.print("�̸�  �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		int kor = scan.nextInt();
		System.out.print("���� �Է� : ");
		int eng = scan.nextInt();
		System.out.print("���� �Է� : ");
		int math = scan.nextInt();
		
		SungJukDTO dto = new SungJukDTO(no, name, kor, eng, math); // �����ڷ� ������ �־��ֱ� 
		dto.calc(); // ��� �޼ҵ� �����´�. 
		
		list.add(dto); // �Է¹��� dto ������ list�� �ִ´�.

		System.out.println("�Է� �Ϸ�");
	}// insertArticle

	// ���
	public void printArticle() {
		System.out.println("���");
		System.out.println("��ȣ\t\t�̸�\t����\t����\t����\t����\t���");

			for (SungJukDTO dto : list) {
				System.out.println(dto); // ����ϱ� 
			}// for
	} // printArticle()
	

	// search
	public void searchArticle(){
		
		int sw = 0; // ����ġ ���� 
		System.out.println();
			System.out.print("ã�� �̸��� �Է��ϼ��� : ");
			String name = scan.next();

			for(SungJukDTO dto : list){
				if(name.equals(dto.getName())){
					System.out.println(dto); // ����ϱ� 
					sw = 1; // ����� �� ���� ��ȭ��Ų��. 
				}
			}// for 

			if(sw == 0) System.out.println("ã�����ϴ� �̸��� �����ϴ�.");

	}// searchArticle()

	// delete
	public void deleteArticle(){
		System.out.println();
		System.out.print("������ �̸��� �Է��ϼ��� : ");
		String name = scan.next();
		// ����ġ���� 
		// ���� ������ �ƴ��� �ȵƴ��� Ȯ���ϴ� �뵵�̴�.
		// ���� ����Ǿ����� 1�� �ȴ�. 
		// ������� ������ �״�� 0
		int sw = 0;
		// ������ �ε����� ��ȭ�� �����. 
		// �׷��� ������ �Ʒ��� ���� �ε����� �������� �����ϸ� 
		// �ε����� �и��� ������ �����. 
		/*
		for(SungJukDTO dto : list){
			if(name.equals(dto.getName())){
				list.remove(dto); // ���� 
				sw = 1; 
			}
		}
		*/
		// ���� ���ͷ����ͷ� ó�� 
		Iterator<SungJukDTO> it = list.iterator();
		//Iterator�� �ε����� ���� �ʴ´�. 
		// ������ �ϳ��� �ϳ��� �ǳ� �޴´�. 
		while(it.hasNext()){ // ���� ��ġ�� �׸��� ������ T/ ������ F
 			//�����Ͱ� �ִ��� ������ ���� ������ �ٷ� ���´�.
			//SungJukDTO dto = it.next(); // ���� ��ġ�� �׸��� ������ �������� �̵� 
			// iterator�� ���׸� �Ȱɾ����Ƿ� object�� �ɷ��´�
			// ���� ����.. Obejct�� it�� dto�� �������� Ÿ���� �ٸ��� ������ 
			// �θ�� �ڽĿ��� ���缭 �ٿ� ĳ������ ������Ѵ�. 
			// �׷��ٿ� �׳� ���ʸ� ����! 
			SungJukDTO dto = it.next(); 
				if(name.equals(dto.getName())){
						it.remove(); // it.next()���� ��ȯ�� �׸��� ����� (���� ���� ���ۿ� ���� �ӽ� ����ҿ� �ִ� ��)    
						// �׷��� next()�� remove()�� �Ѽ�Ʈ 
						sw = 1; // �̰� ���ϴ��� �ٽ� ���� ����.. 
					}
		}// while

		if(sw == 0){ // ����ġ������ ���� �ڵ尡 ������� �ʾ��� �� �״�� 0���� �����µ� �׶��� �Ʒ��� �ڵ尡 ����� 
			System.out.println("ã�����ϴ� �̸��� �����ϴ� ");	
		}else {
			System.out.println("�����͸� �����Ͽ����ϴ�");	
		}
	}// deleteArticle()

	// sort
	public void sortArticle(){
		while(true){
			System.out.println("*****************");
			System.out.println("1. �̸����� ��������");
			System.out.println("2. �������� ��������");
			System.out.println("3. �����޴� ");
			System.out.println("*****************");
			System.out.println();

			int choice = scan.nextInt();
			if(choice == 3) break;

			if(choice == 1){
				// �̸����� ��������
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>(){
					@Override
					public int compare(SungJukDTO t1, SungJukDTO t2){
						return t1.getName().compareTo(t2.getName());
					}
				};

				Collections.sort(list, com);
				printArticle();
			}else if(choice == 2){
				// �������� �������� 
				Collections.sort(list);
				printArticle();
			}
		
		} // while

	}// sortArticle()
	
}
