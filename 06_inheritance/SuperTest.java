class SuperTest{
	protected double weight, height; 

	// �����ڸ� ���ؼ� ������ �ʱ�ȭ 

	public SuperTest(double weight, double height){
	// �Ű������� 1:1�� �������ش� 
	// double weight, height �Ұ�
		System.out.println("SuperTest ������");
		this.weight = weight; 
		this.height = height; 
	}

	// ���� �����ڴ� �⺻ �����ڰ� �ƴϱ� ������ ������ �������Ѵ�. 
	public SuperTest(){
		System.out.println("SuperTest �⺻ ������");
	}

	public void disp(){
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
	}

}

