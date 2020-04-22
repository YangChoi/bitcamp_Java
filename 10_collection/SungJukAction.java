import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class SungJukAction {
	Scanner scan = new Scanner(System.in);
	private ArrayList<SungJukDTO> list;  // 사람 수에 제한이 없다 
	/*
	리스트 초기화 하는 다른 방법 
	
	*/
	
	public SungJukAction(){
		list = new ArrayList<SungJukDTO>(); 
	}

	public void menu() {
		int choice;
		while (true) {
			System.out.println();
			System.out.println("1~6 중에서 선택하세요");
			System.out.println("*****************");
			System.out.println("	1.입력");
			System.out.println("	2.출력");
			System.out.println("	3.검색");
			System.out.println("	4.삭제");
			System.out.println("	5.정렬");
			System.out.println("	6.끝");
			System.out.println("*****************");
			System.out.println();
			System.out.print("번호 : ");
			choice = scan.nextInt();

			// 나가는 것을 가장 먼저 설정해준다. 
			if(choice == 6){
				System.out.println("시스템을 종료합니다");
				break; 
			}
			// if 문 연달아 쓰면 일일이 물어보기 때문에 프로그램이 약간 느려질 수도 있다. 
			// 그래서 else if를 쓴다. 
			// 조건에 맞는 if문을 찾으면 아래의 조건들은 더 살펴보지 않는다. 
			// 6의 경우엔 갔다가 돌아오는 애가 아니고 아예 나가버리기 때문에 else if 의미가 없다. 

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

	// 입력
	public void insertArticle() {
			int no;
			System.out.print("번호입력 : ");
			no = scan.nextInt();
			/*
			for(SungJukDTO dto : list){
				if(no == dto.getNo()){
					System.out.println("중복된 번호입니다.");
					return;
				}
			} // for dto 
			*/
			for(int i=0; i<list.size(); i++){
			if(no == list.get(i).getNo()){
				System.out.println("중복된 번호입니다");
				return;
				}
			}

	

		System.out.print("이름  입력 : ");
		String name = scan.next();
		System.out.print("국어 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		int math = scan.nextInt();
		
		SungJukDTO dto = new SungJukDTO(no, name, kor, eng, math); // 생성자로 데이터 넣어주기 
		dto.calc(); // 계산 메소드 가져온다. 
		
		list.add(dto); // 입력받은 dto 값들을 list에 넣는다.

		System.out.println("입력 완료");
	}// insertArticle

	// 출력
	public void printArticle() {
		System.out.println("출력");
		System.out.println("번호\t\t이름\t국어\t영어\t수학\t총점\t평균");

			for (SungJukDTO dto : list) {
				System.out.println(dto); // 출력하기 
			}// for
	} // printArticle()
	

	// search
	public void searchArticle(){
		
		int sw = 0; // 스위치 변수 
		System.out.println();
			System.out.print("찾을 이름을 입력하세요 : ");
			String name = scan.next();

			for(SungJukDTO dto : list){
				if(name.equals(dto.getName())){
					System.out.println(dto); // 출력하기 
					sw = 1; // 찍었을 때 값을 변화시킨다. 
				}
			}// for 

			if(sw == 0) System.out.println("찾고자하는 이름이 없습니다.");

	}// searchArticle()

	// delete
	public void deleteArticle(){
		System.out.println();
		System.out.print("삭제할 이름을 입력하세요 : ");
		String name = scan.next();
		// 스위치변수 
		// 값이 수행이 됐는지 안됐는지 확인하는 용도이다.
		// 만약 수행되었으면 1이 된다. 
		// 수행되지 않으면 그대로 0
		int sw = 0;
		// 삭제시 인덱스에 변화가 생긴다. 
		// 그렇게 때문에 아래와 같이 인덱스를 기준으로 삭제하면 
		// 인덱스가 밀리는 문제가 생긴다. 
		/*
		for(SungJukDTO dto : list){
			if(name.equals(dto.getName())){
				list.remove(dto); // 삭제 
				sw = 1; 
			}
		}
		*/
		// 따라서 이터레이터로 처리 
		Iterator<SungJukDTO> it = list.iterator();
		//Iterator는 인덱스를 믿지 않는다. 
		// 스스로 하나씩 하나씩 건네 받는다. 
		while(it.hasNext()){ // 현재 위치에 항목이 있으면 T/ 없느면 F
 			//데이터가 있는지 없는지 묻고 없으면 바로 나온다.
			//SungJukDTO dto = it.next(); // 현재 위치에 항목을 꺼내고 다음으로 이동 
			// iterator에 제네릭 안걸었으므로 object로 걸려온다
			// 위는 오류.. Obejct인 it를 dto에 넣으려니 타입이 다르기 때문에 
			// 부모는 자식에게 맞춰서 다운 캐스팅을 해줘야한다. 
			// 그럴바엔 그냥 제너릭 걸자! 
			SungJukDTO dto = it.next(); 
				if(name.equals(dto.getName())){
						it.remove(); // it.next()에서 반환한 항목을 지운다 (꺼낸 것은 버퍼와 같은 임시 저장소에 있는 것)    
						// 그래서 next()와 remove()는 한세트 
						sw = 1; // 이거 왜하는지 다시 설명 듣자.. 
					}
		}// while

		if(sw == 0){ // 스위치변수가 위의 코드가 수행되지 않았을 때 그대로 0으로 나오는데 그때는 아래의 코드가 수행됨 
			System.out.println("찾고자하는 이름이 없습니다 ");	
		}else {
			System.out.println("데이터를 삭제하였습니다");	
		}
	}// deleteArticle()

	// sort
	public void sortArticle(){
		while(true){
			System.out.println("*****************");
			System.out.println("1. 이름으로 오름차순");
			System.out.println("2. 총점으로 내림차순");
			System.out.println("3. 이전메뉴 ");
			System.out.println("*****************");
			System.out.println();

			int choice = scan.nextInt();
			if(choice == 3) break;

			if(choice == 1){
				// 이름으로 오름차순
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>(){
					@Override
					public int compare(SungJukDTO t1, SungJukDTO t2){
						return t1.getName().compareTo(t2.getName());
					}
				};

				Collections.sort(list, com);
				printArticle();
			}else if(choice == 2){
				// 총점으로 내림차순 
				Collections.sort(list);
				printArticle();
			}
		
		} // while

	}// sortArticle()
	
}
