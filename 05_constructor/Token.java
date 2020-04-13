import java.util.StringTokenizer;
class Token {
	public static void main(String[] args){
		String str = "�п�,��,,���ӹ�";
		// tokenizer : "�п�" "��" "���ӹ�"
		// split : "�п�" "��" "" "���ӹ�" (������� ���)

		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("��ū ���� = " + st.countTokens());

		while(st.hasMoreTokens()){
			// ��ū ���� Ȯ�� 
			System.out.println(st.nextToken());
			// ������ ���� ��ġ ��ū ������(���⼭ ����ϰ�) �������� �̵� 
		}
		
		System.out.println("------------------------------");
		String[] arr = str.split(",");
		for(String data : arr){
			System.out.println(data);
		}
	}
}