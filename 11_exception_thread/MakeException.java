class MakeException extends Exception{ // �����ڰ� ���� Exception Ŭ���� 
	private String errorMsg;

	public MakeException(){}

	public MakeException(String errorMsg){
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString(){
		//return getClass() +":" + errorMsg;
		// Ŭ������ : �����޼��� 
		return errorMsg; // �����޼����� ������ 
	}
	
}
