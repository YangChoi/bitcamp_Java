package boardProject;

public class MemberUtil {
	// 1. Member 배열에 대한 add, expand 등의 배열 메소드를 
	// MyArray.java에 만들기 
	// 2. Reply 구조체를 만들고 Reply 배열에 대한 add, expand 등의 
	// 메소드를 MyArray.java에 만들기 
	// 3. Board, Member, Reply에 대한 remove를 MyArray.java에 만들기 
	public static String showNickName(Member[] memberArr, int id) {
		for(int i = 0; i < memberArr.length; i++) {
			if(memberArr[i].id == id) {
				return memberArr[i].nickName;
				
			}
		}
		return null;
	}
	
	
}
