import java.util.Scanner;

class StringBufferTest{
	Scanner scan = new Scanner(System.in);
	
	private int dan; 
	
	// �����ڿ��� �Է��� �޴´�. 
	public StringBufferTest(){
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է��Ͻÿ� " );
		this.dan = scan.nextInt();
	}

	
	// get
	public int getDan(){
		return dan;
	}

	public void display(){
		StringBuffer buffer = new StringBuffer(); // StringBuffer �ʱ�ȭ �� �� "" �ȵ� (String Ÿ�԰� StringBuffer�� �ٸ��� ����// null�� �آa��)
		
		for(int i = 1; i <=9; i++){
			//System.out.println(this.dan + "*" + i + "=" + dan*i);
						
			buffer.append(dan); // append : ���� �߰��϶� 
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);

			System.out.println(buffer);
			buffer.delete(0, buffer.length());
			// �ռ� ����� �ͱ��� �� �پ �����Ƿ� �տ��� ����� �̹� ���� �͵��� 
			// delete�� �����ش�. 0��° ���� buffer.length
			// �迭.length  ���ڿ�.length()
			
		}
	}


	public static void main(String[] args){
		StringBufferTest sbt = new StringBufferTest(); // Ŭ������ �޸� ��� (�޸� ���� + ������)
		// >> ������ �θ� 
		sbt.display();
	}
}

/*
���ϴ� �� �Է� : 7
������ ��� 
*/