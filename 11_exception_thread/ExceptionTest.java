import java.util.Scanner;

class ExceptionTest {
	public static void main(String[] args) {
		// main�� ȣ��Ǹ� String[] args�� ������ ���� �� ����
		// main�� ȣ��Ǵ� ���� ����Ǵ� ���� 
		// ������ javac ������ ���� java ���� ��

		if(args.length > 0){ // �����Ͱ� �ϳ� ���� �� 
			System.out.println("args[0] = "+args[0]);
		} // ������ �ɾ��ָ� �����͸� ���� �ʾƵ� ������ ���� �ʴ´�. 
		System.out.println();

		Scanner scan = new Scanner(System.in);
		System.out.println("�����Է� : ");
		int num2 = scan.nextInt();
		
		// try-catch
		try{ // �� �ȿ��� ������ �߻��� ���ɼ��� ���� 
			int num = Integer.parseInt(args[0]); // 0�ε����� ���� String ��(�迭 args�� ������ Ÿ���� String �̹Ƿ�)�� ���������� �ٲ۴�. 
			// ���� args�� ȣ���̶�� �Է����� ��? 
			// ȣ���̸� ���������� �ٲܶ�? >> NumberFormatException : �� ������ ������ �ƴϳĴ� ���� 
			// ȣ���̴� ���������� �ٲ� �� ���ٴ� ���� ��
			// (������ �� ���� ����)
			
			System.out.print(num+ "/" + num2 + "=" + (num/num2));  // �������� 0���� ���� �� ����� �� ���ٰ� ����
			//System.out.print(num+ "/" + num2 + "=" + ((double)num/num2)); : �Ǽ����� 0���� ���� �� infinity ���� 
		}catch(NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���"); 
			// �����޽����� ���� ���� �ٲ۴�. 
			// ����ڰ� ���� ���� �� � ������ �Ͼ�� ���α׷��� �������� �ʴ��� �� �� �ְ�. 

		// 0�Է½� ������ ���꿡�� 
		}catch(ArithmeticException e){
			System.out.println("0�̿��� ���ڸ� �Է��ϼ���");
		}finally { // ���� try������ ���� ���� �� �ذ�Ǿ ����� �ͼ� ��´�. 
					// catch���� ���� �޽����� ��Ƶ� ����� �´�. 
			System.out.println();
			System.out.println("error�� �ְ� ���� ������ ���� " );
		}
	}
}
