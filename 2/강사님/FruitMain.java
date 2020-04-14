/*
���� �Ǹŷ� ���ϱ�
���� �����հ赵 ���Ͻÿ�

Ŭ���� : FruitDTO
pum, jan, feb, mar, tot
sumJan, sumFeb, sumMar

������
calcTot()
display()
output() - static

Ŭ���� : FruitMain


[������]
---------------------------------
PUM		JAN   FEB   MAR		TOT
---------------------------------
���    100    80    75     255
����     30    25    10     xxx
����     25    30    90     xxx
---------------------------------
        xxx   xxx   xxx				output()�� ó��
*/

class FruitDTO {
	private String pum;
	private int jan, feb, mar, tot;
	private static int sumJan, sumFeb, sumMar;

	public FruitDTO(String pum, int jan, int feb, int mar) {
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}

	public void calcTot(){
		tot = jan+feb+mar;

		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
	}

	public void display() {
		System.out.println(pum+"\t"+jan+"\t"+feb+"\t"+mar+"\t"+tot);
	}
	
	public static void output() {
		System.out.println("\t"+sumJan+"\t"+sumFeb+"\t"+sumMar);
	}
}
//-------------
class FruitMain {
	public static void main(String[] args) {
		FruitDTO[] ar = {new FruitDTO("���",100,80,75),
						 new FruitDTO("����",30,25,10),
						 new FruitDTO("����",25,30,90)};
		
		for(FruitDTO data : ar){
			data.calcTot();
			data.display();
		}
		System.out.println("-----------------------------------------");
		FruitDTO.output();		
	}
}
