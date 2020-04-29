class ScoreDTO {
	private String hak; // ÇÐ¹ø
	private String name; 
	private int kor; 
	private int eng; 
	private int math;
	private int tot; 
	private double avg;

	public ScoreDTO(String hak, String name, int kor, int eng, int math){
		this.hak = hak;
		this.name = name; 
		this.kor = kor;
		this.eng = eng; 
		this.math = math;
	}

	// getter 
	public String getHak(){
		return hak;
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
	public int getAvg(){
		return avg; 
	}

	public void calcTot(){
		tot = kor + eng + math;

	}
	public void calcAvg(){
		avg = (kor+eng+math)/3.0;
	}


}
