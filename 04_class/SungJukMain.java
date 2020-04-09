/*setDate(이름, 국어, 영어, 수학) 

이름    국어 영어 수학 총점 평균 학점 
홍아무개 90  31  31 */

class SungJukMain{
	public static void main(String[] args){
		SungJuk sj = new SungJuk();
		sj.setData("양아무개",40,20,90);
	
		
		sj.calcTot();
		sj.calcAvg();
		sj.calcGrade();

		SungJuk sj2 = new SungJuk();
		sj2.setData("김아무개",50,80,90);

		sj2.calcTot();
		sj2.calcAvg();
		sj2.calcGrade();

		SungJuk sj3 = new SungJuk();
		sj3.setData("최아무개",56,84,92);

		sj3.calcTot();
		sj3.calcAvg();
		sj3.calcGrade();


		
		System.out.println("이름\t\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.print(sj.getName()+"\t"+sj.getKor()+"\t"+sj.getEng()+"\t"+sj.getMath()+"\t"+sj.getTot()+"\t"+
			String.format("%.2f",sj.getAvg())+"\t"+sj.getGrade()+"\n");

		System.out.print(sj2.getName()+"\t"+sj2.getKor()+"\t"+sj2.getEng()+"\t"+sj2.getMath()+"\t"+sj2.getTot()+"\t"+
			String.format("%.2f",sj2.getAvg())+"\t"+sj2.getGrade()+"\n");
		System.out.print(sj3.getName()+"\t"+sj3.getKor()+"\t"+sj3.getEng()+"\t"+sj3.getMath()+"\t"+sj3.getTot()+"\t"+
			String.format("%.2f",sj3.getAvg())+"\t"+sj3.getGrade()+"\n");

	}
}

