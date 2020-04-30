package scoreManaging;

import java.text.DecimalFormat;

public class ScoreDTO implements Comparable<ScoreDTO>{
	private int no;
	private String name; 
	private int kor, eng, math, tot; 
	private double avg; 
	
	public ScoreDTO(int no, String name, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// getter
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	
	public void calc() {
		tot = kor + eng + math;
		avg = tot/3.0;
	}
	
	// dto 출력 
	@Override
	public String toString() {
		return no +"\t" +
				name + "\t" +
				kor + "\t" +
				eng + "\t" +
				math + "\t" +
				tot + "\t" +
				new DecimalFormat("###.###").format(avg);
	}
	
	@Override
	public int compareTo(ScoreDTO dto) {
		// 내림차순 
		return this.tot < dto.tot ? 1 : -1;
	}

}
