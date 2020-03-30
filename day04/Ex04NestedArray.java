package day04;
/*
 * 이차원배열
 * 
 */
public class Ex04NestedArray {

	public static void main(String[] args) {
		// 2차원 배열
		// 똑같은 데이터타입의 배열이 또 모여 있는 것
		// 배열 안에 배열 
		int[][] nestedArray = new int[2][4];
		// 그냥 배열처럼 인덱스를 주면 해당하는 번호의 무언가가 튀어나온다 
		// 그런데 
		// nestedArray[0] 이라고 하면 무엇이 튀어나올까?
		
		// [][][][] -> nestedArray[0]
		// [][][][] -> nestedArray[1]
		
		// 즉 nestedArray[0]은 int[4]가 나오게 된다. 
		// 그러면 int를 집어넣으려고 하면 어떻게 해야할까? 
		
		
		for(int i = 0; i< nestedArray.length; i++) { // nestedArray.length = 2
			for(int k = 0; k < nestedArray[i].length; k++) { // nestedArray[i].length = 4;
				System.out.println("nestedArray["+ i +"]" + "["+ k +"]: " + nestedArray[i][k]);
			}
		}

	}

}
