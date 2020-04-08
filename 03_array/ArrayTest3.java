// 주차장 관리 
// 1. 입차 
// 2. 출차 
// 3. 목록 (차가 몇대 있나)
// 4. 끝


// 번호 : 

import java.util.Scanner;
class ArrayTest3{
	public static void main(String[] args){
		// 차가 있으면 t/ 없느면 f
		// 차 5대만 주차할 수 있는 공간 : 배열 
		boolean[] car = new boolean[5]; // 차 5대 
		Scanner scan = new Scanner(System.in);
		// 배열은 GARBAGE값 안들어 있음
		// 그렇기 때문에 초기값으로 FALSE가 들어있다. 
	
		// 배열에서 0번째는 사람에겐 1번째이다.
		// 그렇기 때문에 사람에게 보일 때는 INDEX+1 되어야함 
		while(true){
			System.out.println("1. 입차  2. 출차  3. 목록  4. 끝");
			int input = scan.nextInt();

			if(input == 1){
				//입차
				System.out.println("입차할 위치를 입력해주세요 ");
				int in = scan.nextInt();
				
				if(car[in-1] == true){ // if문에 들어있기 때문에 car[in-1] 자체가 참 거짓이 될 수 있어서 == true 안써도 된다. 
					System.out.println(in + "번째 위치는 주차 불가합니다.");
				}else {
					System.out.println(in + "번째 위치에 주차하였습니다. ");	
					car[in-1] = true; // 입차함 
				}
				

			}else if(input == 2 ) {
				// 출차
				System.out.println("출차할 위치를 입력하세요");
				int out = scan.nextInt();

					if(car[out-1]){
						car[out-1] = false; // 출차 
						System.out.println((out-1) + "위치의 차를 출차합니다");
					}else {
						System.out.println("해당 자리에 주차되어있지 않습니다. ");
					}
			
				

			}else if(input == 3) {
				// 목록
				System.out.println("목록입니다");
				for(int i = 0; i < car.length; i++){
					System.out.println((i+1) + "번째 위치 : " + car[i]);
				} // for

			}else if(input == 4){
				// 끝
				break;
			}
		}
	}
}
