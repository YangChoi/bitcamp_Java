class EmployeeDTO{

	private String name; // 이름 
	private String position; // 직급
	private int basicPay; // 기본급
	private int extraPay;// 수당
	private double taxRate;// 세율
	private int salary;// 월급


	// set
	public void setData(String n, String p, int b, int e){
		name = n; 
		position = p;
		basicPay = b;
		extraPay = e;
	}
	

	// calc
	//월급 : 기본급 + 수당 -(기본급+수당)*세율
	// setter/getter 메소드 설정, 계산은 calcPay()
	
	// 세율 계산 & 월급 게계산
	public void calcPay(){
		if(basicPay <= 2000000) {
			taxRate = 0.01;
		}else if(basicPay <= 4000000){
			taxRate = 0.02;
		}else if(basicPay > 4000000){
			taxRate = 0.03;
		}
		salary = (int)(basicPay + extraPay - (basicPay + extraPay) * taxRate);
	}
	
	public void setTaxRate(double t){
		taxRate = t;
	}
	public void setSalary(int s){
		salary = s;
	}

	// get

	public String getName(){
		return name;
	}
	public String getPosition(){
		return position;
	}
	public int getBasicPay(){
		return basicPay;
	}
	public int getExtraPay(){
		return extraPay;
	}
	public double getTaxRate(){
		return taxRate;
	}
	public int getSalary(){
		return salary;
	}
}

/*
DTO(Data Transfer Object)
VO(Value Object)
Bean
*/
