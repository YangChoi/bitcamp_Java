package day03;
/*
 * 2중 for loop을 이용한 1 ~ 100까지의 소수를 구하는 프로그램
 * 소수(Prime Number)란 무엇인가 
 * 1과 자기자신 외에는 약수가 없는 숫자 
 * = 약수의 갯수가 단 2개인 숫자
 * 
 *  약수란 무엇인가 
 *  A를 B로 나누었을 때 나누어 떨어지면 
 *  B는 A의 약수이다 
 *  나누어 떨어진다라는 의미는 나머지가 0이란 의미이다 
 *  
 *  그렇다면 어떤 숫자의 가장 큰 약수는? 
 *  >> 자기자신 
 *  
 *  이 3가지 이용해서 
 *  1~100 사이의 약수를 구하는 프로그램을 만들어 볼 것이다. 
 */
public class Ex09NestedForLoop {

	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) { // 1부터 100까지 
			int count = 0; 
			// count는 약수의 개수 
			
			for(int k = 1; k <= i; k++) { // 1부터 100까지의 숫자를 나눌 숫자 k
				if(i % k == 0) { // i를 k(i의 자기자신)로 나누었을 때 나머지가 0이 된다면 약수이므로 
					count++; // count + 1
				}
			}
			
			if(count == 2) { // 약수가 1과 자기자신인 경우 
				System.out.println(i + "는 소수입니다. ");
			}
		}

	}

}
