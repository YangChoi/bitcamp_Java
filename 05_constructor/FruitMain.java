
class FruitDTO{


	private String pum; 
	private int jan, feb, mar;
	private int tot; 
	private int sumJan, sumFeb, sumMar;
	
	// 생성자 
	public FruitDTO(String pum, int jan, int feb, int mar){
		this.pum = pum; 
		this.jan = jan; 
		this.feb = feb; 
		this.mar = mar; 
	}
	// setter
	public void setData(String pum, int jan, int feb, int mar){
		this.pum = pum; 
		this.jan = jan; 
		this.feb = feb; 
		this.mar = mar;
	}
	

	// getter
	public String getPum(){
		return pum;
	}

	public int getJan(){
		return jan;
	}

	public int getFeb(){
		return feb;
	}

	public int getMar(){
		return mar;
	}

	public int getSumJan(){
		return sumJan;
	}
	public int getSumFeb(){
		return sumFeb;
	}
	public int getSumMar(){
		return sumMar;
	}
	

	public void calcTot(){
		tot = jan + feb + mar;
		
	}

	// 월별 합계 
	public static void output(){
		for(int i = 0; i < arr.length; i++){
			arr[i].sumJan += jan[i];
			arr[i].sumFeb += feb[i];
			arr[i].sumMar += mar[i];
		}
	}
	// 출력
	public void display(){
		System.out.println("--------------------------");
		System.out.println("PUM\t\tJAN\tFEB\tMAR\t\tTOT");
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i].getPum() + "\t\t"+ arr[i].getJan() + "\t" + arr[i].getFeb() + "\t" + arr[i].getMar() + "\t\t"+ arr[i].getTot());
		}
		System.out.println("\t\t\t\t" + output());

	}
	
}

class FruitMain{
	FruitDTO[] arr = new FruitDTO[3]; // 값 3개 받음 
	public static void main(String[] args){

		FruitMain fm = new FruitMain();

		arr[0] = fm.setData("사과", 100, 80, 75);
		arr[1] = fm.setData("포도", 30, 25, 10);
		arr[2] = fm.setData("딸기", 25, 30, 90);

		fm.display();
	}
}