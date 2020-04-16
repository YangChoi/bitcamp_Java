import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


class Today {
	public static void main(String[] args) throws ParseException{
		Date date = new Date();
		System.out.println("���� ��¥ : " + date);

		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� E���� H:m:s");
		System.out.println("���� ��¥ : " + sdf.format(date));
		System.out.println();
		
		//1991-07-16
		//19910716152510
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910716152510"); // String -> Date�� ��ȯ 

		System.out.println("�� ����" + birth);
		System.out.println("�� ����" + sdf.format(birth)); // ���� ���� �ٸ� ���Ŀ� ���߰� �ʹٸ�..
		// ���� �˾Ƽ� ���� ���ϴ� �������� ����� �� �ִ�. 
		System.out.println();

		//Calendar cal = new ��¼�� �ȵ�! �߻�Ŭ������
		// �׷��� �ڽ� Ŭ���� ��ƿ´� 
		//Calendar cal = new GregorianCalendar(); // �ڽ� Ŭ������ �̿��� Calendar Ŭ���� �������� ���
		// �ƴϸ� �޼ҵ带 ������ �´�!
		Calendar cal = Calendar.getInstance(); // �޼ҵ带 �̿��� Calendar Ŭ���� �������� ��� - �ý��� ��¥, �ð� ������ 
		//int year = cal.get(Calendar.YEAR); 
		int year = cal.get(1); // 1 : Calendar.YEAR ������ 1�������� ��� ��...
		int month = cal.get(Calendar.MONTH)+1; // 1���� Constant field value�� 0���� 0���� ���´�. 
		// ���� +1�� ���ָ� �� 
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // ������ �Ͽ��Ϻ����ؼ� 1���� ������...
	
		String week = null;
		switch(dayOfWeek){
			case 1:
				week = "�Ͽ���";
				break;
			case 2:
				week = "������";
				break;
			case 3: 
				week = "ȭ����";
				break;
			case 4:
				week = "������";
				break;
			case 5:
				week = "�����";
				break;
			case 6:
				week = "�ݿ���";
				break;
			case 7:
				week = "�����";
				break;
		}
		System.out.println(year + "�� " + month + "�� " + day + "�� " + week);

	}
}