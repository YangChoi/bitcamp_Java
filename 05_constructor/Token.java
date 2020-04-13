import java.util.StringTokenizer;
class Token {
	public static void main(String[] args){
		String str = "학원,집,,게임방";
		// tokenizer : "학원" "집" "게임방"
		// split : "학원" "집" "" "게임방" (공백까지 계산)

		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("토큰 갯수 = " + st.countTokens());

		while(st.hasMoreTokens()){
			// 토큰 유무 확인 
			System.out.println(st.nextToken());
			// 있으면 현재 위치 토큰 꺼내고(여기서 출력하고) 다음으로 이동 
		}
		
		System.out.println("------------------------------");
		String[] arr = str.split(",");
		for(String data : arr){
			System.out.println(data);
		}
	}
}