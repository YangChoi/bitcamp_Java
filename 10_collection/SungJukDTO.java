class SungJukDTO {
	private int no;
	private String name; 
	private int kor, eng, math, tot;
	private double avg; 
	
	// »ý¼ºÀÚ
	public SungJuk(int no, String name, int kor, int eng, int math, int tot, double avg){
		this.no = no; 
		this.name = name; 
		this.kor = kor; 
		this.eng = eng; 
		this.math = math;
		this.tot = tot; 
		this.avg = avg;
	}

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

	// getter
	public int getNo(){
		return no;
	}
	public String getName(){
		return name; 
	}
	public int getKor(){
		return kor; 
	}
	public int getEng(){
		return eng; 
	}
	public int getMath(){
		return math;	
	}
	public int getTot(){
		return tot;
	}
	public double getAvg(){
		return avg;
	}


	@Override 
	public String toString(){
		return no + name + kor + eng + math + tot + avg;
	}
}
