import java.text.DecimalFormat;

class SungJukDTO implements Comparable<SungJukDTO>{
	private int no;
	private String name; 
	private int kor, eng, math, tot;
	private double avg; 
	

	// ������
	public SungJukDTO(int no, String name, int kor, int eng, int math){
		this.no = no; 
		this.name = name; 
		this.kor = kor; 
		this.eng = eng; 
		this.math = math;
		// ����, ��հ��� ����ϴ� �����ʹ� �����ڷ� ���� �ʾƵ� �ȴ�. 
	}
	/*
	// setter
	public void setNo(int no){
		this.no = no;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setKor(int kor){
		this.kor = kor;
	}
	public void setEng(int eng){
		this.eng = eng;
	}
	public void setMath(int math){
		this.math = math;
	}
	public void setTot(int tot){
		this.tot = tot;
	}
	public void setAvg(int avg){
		this.avg = avg;
	}
	*/

	// ����, ���
	public void calc(){
		tot = kor + eng + math; 
		avg = (double)tot/3;
	}
	
	

	// getter
	public int getNo(){
		return this.no;
	}
	public String getName(){
		return this.name; 
	}
	public int getKor(){
		return this.kor; 
	}
	public int getEng(){
		return this.eng; 
	}
	public int getMath(){
		return this.math;	
	}


	@Override 
	public String toString(){
		return no +"\t"
				+ name +"\t"
				+ kor +"\t"
				+ eng +"\t"
				+ math +"\t"
				+ tot +"\t"
				+ new DecimalFormat("####.###").format(avg); // �Ҽ� ��°�ڸ����� ǥ�� 
	}

	@Override 
	public int compareTo(SungJukDTO o){
		return this.tot < o.tot ? 1 : -1; // �������� ��������
	}
}
