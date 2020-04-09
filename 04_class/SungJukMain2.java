class SungJukMain2 {
	public static void main(String[] args){
		//SungJuk aa = new SungJuk(); // 객체 
		//SungJuk bb = new SungJuk(); 
		//SungJuk cc = new SungJuk(); 

		//int arr = new int[3]; // 방을 3개가 들어있다. 방에는 정수형만 들어갈 수 있다. 
		SungJuk[] arr = new SungJuk[3]; // 객체 배열 
		// 방을 만들었는데 SungJuk 주소가 들어있는 것들 만 들어오는 방. 
		arr[0] = new SungJuk(); // 이것이 클래스 만든 것
		arr[1] = new SungJuk();
		arr[2] = new SungJuk();

		arr[0].setData("양아무개",40,20,90);
		arr[1].setData("김아무개",50,80,90);
		arr[2].setData("최아무개",56,84,92);

		
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