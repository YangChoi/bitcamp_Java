class EmployeeDTO{

	private String name; // �̸� 
	private String position; // ����
	private int basicPay; // �⺻��
	private int extraPay;// ����
	private double taxRate;// ����
	private int salary;// ����


	// set
	public void setData(String n, String p, int b, int e){
		name = n; 
		position = p;
		basicPay = b;
		extraPay = e;
	}
	

	// calc
	//���� : �⺻�� + ���� -(�⺻��+����)*����
	// setter/getter �޼ҵ� ����, ����� calcPay()
	
	// ���� ��� & ���� �԰��
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
