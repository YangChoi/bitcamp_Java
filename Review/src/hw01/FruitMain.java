package hw01;
class FruitDTO{
	private String pum;
	private int jan, feb, mar, tot;
	private static int janSum, febSum, marSum;
	private static int sumJan, sumFeb, sumMar;

	
	FruitDTO(){}
	
	FruitDTO(String pum, int jan, int feb, int mar){
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar; 

	}
	
	// setter
	public void setPum(String pum) {
		this.pum = pum;
	}
	public void setJan(int jan) {
		this.jan = jan;
	}
	public void setFeb(int feb) {
		this.feb = feb;
	}
	public void setMar(int mar) {
		this.mar = mar;
	}

	// getter
	public String getPum() {
		return pum;
	}
	
	public int getJan() {
		return jan;
	}
	public int getFeb() {
		return feb;
	}
	public int getMar() {
		return mar; 
	}
	
	public void calcTot() {
		tot = jan + feb + mar;
		
		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
	}
	
	public void display() {
		
		
		System.out.println(pum+"\t\t"+jan+"\t"+feb+"\t"+mar+"\t"+tot);
	}// display()
	
	public static void output() {
		System.out.println("\t\t"+sumJan+"\t"+sumFeb+"\t"+sumMar);
	}// output()
	
	
	
	
}
public class FruitMain {

	public static void main(String[] args) {
		FruitDTO[] arr = {new FruitDTO("사과", 100, 200, 300),
						new FruitDTO("포도", 200, 300, 400),
						new FruitDTO("딸기", 150, 250, 340)};
		System.out.println("PUM\t\tJAN\tFEB\tMAR\t\tTOT");
		for(FruitDTO dto : arr) {
			dto.calcTot();
			dto.display();
		}
		FruitDTO.output();
		

	}

}
