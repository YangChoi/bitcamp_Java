class MakeException extends Exception{ // 개발자가 만든 Exception 클래스 
	private String errorMsg;

	public MakeException(){}

	public MakeException(String errorMsg){
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString(){
		//return getClass() +":" + errorMsg;
		// 클래스명 : 에러메세지 
		return errorMsg; // 에러메세지만 나오게 
	}
	
}
