//import static java.lang.Math.random;
// ���⼭ import�� ���ָ� �ؿ� Math.random()���� Math�� ���൵ �ȴ�. 
// �ٵ� ��ĩ random�� ImportStatic Ŭ������ ���̶�� ������ �� �����Ƿ� �����ϵ���. 
//import static java.lang.Math.pow;
// ���� �͵��� �Ʒ��� �ٿ� �� �� ����
import static java.lang.Math.*;
import static java.lang.String.format;
import static java.lang.System.out;

class ImportStatic {
	public static void main(String[] args){
		System.out.println("���� = " + Math.random()); // 0 <=���� < 1
		// ���� Math.random()�� static�� �ƴϾ��ٸ� 
		// new Math().random() �̷��� ��ü�� �����ؾ����� ��. 

		System.out.println("���� = " + pow(2, 5)); // 2�� 5�� ��� 
		// Math.pow�� ���� ��������. 

		System.out.println("�Ҽ� ���� 2° �ڸ� = " + format("%.2f", 43.56789));
		// String.format
		out.println();
	}
}