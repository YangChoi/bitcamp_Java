class FruitDTO{
	private String pum; 
	private int jan, feb, mar;
	private int tot; 
	static int sumJan, sumFeb, sumMar;
	// 생성자 
	public FruitDTO(String pum, int jan, int feb, int mar){
		this.pum = pum; 
		this.jan = jan; 
		this.feb = feb; 
		this.mar = mar; 
	}

	public void calcTot(){
		tot = jan + feb + mar;

		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
		
	}

	public void display(){
		System.out.println("----------------------------------------");
	
			System.out.println(pum + "\t\t"+ jan + "\t" + feb + "\t" + mar + "\t\t"+ tot);
		
	

	}

	public static void output(){
		System.out.println("\t\t"+sumJan + "\t" +sumFeb+"\t" +sumMar);
	}
	
	
}

class FruitMainAgain{
	public static void main(String[] args){
		
		FruitDTO[] arr = {new FruitDTO("사과", 100, 80, 75),
						new FruitDTO("포도", 30, 25, 105),
						new FruitDTO("사과", 25, 30, 90)};

		System.out.println("PUM\t\tJAN\tFEB\tMAR\t\tTOT");
		for(FruitDTO data : arr){
			data.calcTot();
			data.display();
		}


		System.out.println("----------------------------------------");
		FruitDTO.output();
	}
}