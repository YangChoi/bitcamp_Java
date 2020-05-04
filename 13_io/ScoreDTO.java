import java.io.Serializable;
import java.text.DecimalFormat;

class ScoreDTO implements Comparable<ScoreDTO>, Serializable{
	private String hak; // 학번
	private String name; 
	private int kor; 
	private int eng; 
	private int math;
	private int tot; 
	private double avg;

	/*
	public ScoreDTO(String hak, String name, int kor, int eng, int math){
		this.hak = hak;
		this.name = name; 
		this.kor = kor;
		this.eng = eng; 
		this.math = math;
	}*/

	// setter
	public void setHak(String hak){
		this.hak = hak;
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
	public String getAvg(){
		return new DecimalFormat("0.###").format(avg);
	}

	public void calc(){
		tot = kor + eng + math;
		avg = tot/3.0;

	}

	@Override
	public int compareTo(ScoreDTO dto){
		// 총점으로 내림차순 
		// if(this.tot > dto.tot) return 1; // 오름차순
		// else if(this.tot < dto.tot) return -1 // 내림차순
		// else return 0; // 둘다 똑같다 

		// 내림차순일때는 반대로 해주면된다. 
		// if(this.tot > dto.tot) return -1; // 내림차순
		// else if(this.tot < dto.tot) return 1 // 오름차순
		// else return 0; // 둘다 똑같다 

		// 조건연산자 
		// 조건? 참 : 거짓;
		// 0은 같아도 상관없기 때문에 없어도 된다. 
		return this.tot > dto.tot ? -1 : 1; 
	}
	
}
