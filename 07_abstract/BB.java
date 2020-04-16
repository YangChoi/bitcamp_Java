abstract class AA {
	public abstract void sub();
	// 현재 존재하지 않기 때문에 구현부 없이 세미콜론
	
	public final void disp(){}
	// final 걸면 override 절대 하면 안됨
}

class BB extends AA {
// 부모클래스가 추상클래스이면 자식 클래스는 반드시 오버라이드 해줘야한다. 
	public void sub(){} // 반드시 override
	public void disp(){} // override 하면 안됨 - final 걸어줌 
}

// override와 final은 정반대 개념 

// 추상클래스 도대체 왜 쓰나?
// >> 






