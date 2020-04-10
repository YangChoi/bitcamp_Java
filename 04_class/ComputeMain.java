class ComputeTest{
	private int x, y;
	private int sum;
	private int sub; //차
	private int mul; //곱
	private double div; // 나누기 (소수이하 3째자리)

	// set
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public void calc (){
		sum = x + y;
		sub = x - y;
		mul = x * y;
		div = (double)x / y;

	}

	// get
	public int getX(){
		return x; 
	}

	public int getY(){
		return y;
	}

	public int getSum(){
		return sum;
	}
	
	public int getSub(){
		return sub;
	}

	public int getMul(){
		return mul;
	}
	
	public String getDiv(){
		return String.format("%.3f",div); // String.format이 들어오면서 div값이 Stringd이 되기 때문에 리턴값이 String
	}

}

class ComputeMain{
	public static void main(String[] args){
		ComputeTest[] ct = new ComputeTest[3];
		
		ct[0] = new ComputeTest();
		ct[1] = new ComputeTest();
		ct[2] = new ComputeTest();
		

		ct[0].setX(320);
		ct[0].setY(126);

		ct[1].setX(126);
		ct[1].setY(89);
		
		ct[2].setX(257);
		ct[2].setY(126);
		
		// 출력 및 계산
		System.out.println("X\tY\tSUM\tSUB\tMUL\tDIV");
		for(ComputeTest a : ct){
			
			a.calc();

			
			System.out.println(a.getX()+"\t"+a.getY()+"\t"+a.getSum()+"\t"+a.getSub()+"\t"+a.getMul()+"\t"+a.getDiv());

		}

		
	}
}