class SungJukMain2 {
	public static void main(String[] args){
		//SungJuk aa = new SungJuk(); // ��ü 
		//SungJuk bb = new SungJuk(); 
		//SungJuk cc = new SungJuk(); 

		//int arr = new int[3]; // ���� 3���� ����ִ�. �濡�� �������� �� �� �ִ�. 
		SungJuk[] arr = new SungJuk[3]; // ��ü �迭 
		// ���� ������µ� SungJuk �ּҰ� ����ִ� �͵� �� ������ ��. 
		arr[0] = new SungJuk(); // �̰��� Ŭ���� ���� ��
		arr[1] = new SungJuk();
		arr[2] = new SungJuk();

		arr[0].setData("��ƹ���",40,20,90);
		arr[1].setData("��ƹ���",50,80,90);
		arr[2].setData("�־ƹ���",56,84,92);

		
		for(int i = 0; i < arr.length; i++){
			arr[i].calcTot();
			arr[i].calcAvg();
			arr[i].calcGrade();

			System.out.println(arr[i].getName()+"\t"
							+arr[i].getKor()+"\t"
							+arr[i].getEng()+"\t"
							+arr[i].getMath()+"\t"
							+arr[i].getTot()+"\t"
							+String.format("%.2f",arr[i].getAvg())+
							"\t"+arr[i].getGrade());

		}
	}
}