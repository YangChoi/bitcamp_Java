package day01;
/*
 * 증감연산자 
 * ++ --
 * 증감연산자는 변수의 현재값으 1씩 변화시킨다. 
 * ++의 경우에는 1 증가시키고 
 * --의 경우에는 1 감소시킨다. 
 * 
 * 하지만 이 친구들은 +=, -=과는 역할이 좀 다르다. 
 * 
 */
public class Ex04 {

	public static void main(String[] args) {
		int number = 5;
		System.out.println(number+=1); // number = number + 1
		
		
		// 증감연산자는 앞에 붙어있냐 뒤에 붙어있냐에 따라서 
		// 우선준위가 바뀌게 된다. 
		int number2 = 6;
		System.out.println(number2++); // 6
		// 증감연산가가 뒤에 붙어 있으면 : 후위 증가 연산자 or 후위 감소 연산자 라고 부름
		// 우선순위가 가장 낮은 순위로 내려간다 ( = 제일 나중에 실행이 된다)
		System.out.println(number2); //7 
		// System.out.println(number2++); 의 경우에는 
		// System.out.println(number2);가 실행이 되고 
		// 그 다음에 number2++가 실행된다. 
		// 즉, number2의 현재값이 6이 화면에 출력되고 
		// 그리고 현재값이 1 증가되어서 number2는 7이 된다. 
		
		System.out.println(++number2); // 8
		// 증감연산자가 앞에 붙어 있으면 : 각각 전위증가연산자 or 전위 감소연산자 라고 부름
		// 또 우선순위는 1위가 된다 ( = 제일 먼저 실행이 된다)
		//number2가 위에서 7이 되었기 때문에 거기서 1을 더하면서 8이 되었다. 
		
		System.out.println(number += 3 + number2); // 6 + 3 + 8 = 17
		

		

	}

}
