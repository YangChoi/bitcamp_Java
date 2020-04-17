class AA {}
class BB extends AA{}

class InstanceOf {
	public static void main(String[] args){
		AA aa = new AA();
		BB bb = new BB();
		AA aa2 = new BB(); 

		AA aa3 = aa; // aa의 클래스 타입은 같은 AA이므로 가능 
		if(aa instanceof AA){
			// aa는 casting 된다 
			// aa가 기리키는 곳에는 AA타입의 클래스가 있다. 
			System.out.println("1. TRUE");
		}else {
			System.out.println("1. FALSE");
		}//TRUE

		AA aa4 = bb; // 부모 = 자식 (가능)
		// bb 안에는 AA가 있다. BB가 AA에게 상속받음 
		if(bb instanceof AA){ 
			System.out.println("2. TRUE");
		}else {
			System.out.println("2. FALSE");
		}//TRUE

		BB bb2 = (BB)aa2;
		// BB는 자식. 
		// 그런데 부모의 값이 자식 값에 들어오려고 함
		// 자식 = 부모 
		// 불가능 
		// 따라서 자식 = (자식)부모 로 다운캐스팅해야함 
		if(aa2 instanceof BB){ 
			System.out.println("3. TRUE");
		}else {
			System.out.println("3. FALSE");
		}// TRUE

		//BB bb3 = (BB)aa;
		if(aa instanceof BB){ 
			System.out.println("4. TRUE");
		}else {
			System.out.println("4. FALSE");
		}// 에러 
		// 캐스팅 안됨 
		// aa는 AA 주소값만 이미 가지고 있다 
		// 자체적으로 BB를 만들어준적이 없다. 
		// 따라서 캐스팅 불가 
		// 순수하게 AA만 가리키고 있음
		

	}
}