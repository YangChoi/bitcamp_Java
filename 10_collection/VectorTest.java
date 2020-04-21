import java.util.Vector;

class VectorTest {
	public static void main(String[] args){
		Vector<String> v = new Vector<String>(); // 기본 용량 10개 , 10개씩 증가 
		System.out.println("벡터 크기 = " + v.size()); // 0
		System.out.println("벡터 용량 = " + v.capacity()); // 기본 용량 10개 
		System.out.println();

		System.out.println("항목 추가");
		for(int i = 1; i <= 10; i++){
			v.add(i +"");
		}

		System.out.println("벡터 크기 = " + v.size()); // 10
		System.out.println("벡터 용량 = " + v.capacity()); // 10 : 현재값을 초과하지 않기 때문에 10개 그대로 
		System.out.println();

		
		// 크기가 용량을 초과했을 때 
		// 용량은 10이 늘어나 총 20개가 된다. 
		System.out.println("항목 초과");
		v.addElement(5+""); // 중복허용, 순서 
		System.out.println("벡터 크기 = " + v.size()); // 11
		System.out.println("벡터 용량 = " + v.capacity()); // 20
		System.out.println();
	

		// 벡터의 주소값은? 
		System.out.println(v); // 들어간 순서대로 나오고 중복을 허용하는 것을 확인 
		

		System.out.println("항목 제거");
		v.remove(10); // 인덱스 10번째 값 제거 
		System.out.println(v);

	}
}
