package boardProject;

import util.MyArray;

/* 
 * 댓글 관련 메소드들 
 */
public class ReplyUtil {
	 // 해당 게시글의 댓글을 보여주는 메소드 
	public static void list(Reply[] arr, int boardId, Member[] memberArr) {
		// 댓글 배열과 우리가 어떤 글을 보는지 (boardId) 
		for(Reply r : arr) {
			if(r.boardId == boardId) {
				System.out.println(r.id +" "+ r.content +" "+ MemberUtil.showNickName(memberArr, r.memberId));
			}
		}
	}
	
	// 댓글 추가 
	public static Reply[] insert(Reply[] arr, Reply r) {
		// 인덱스 정해주기 
		r.id = arr.length > 0 ? arr[arr.length-1].id + 1 : 1;
//		if(arr.length > 0) {
//			r.id = arr[arr.length-1].id + 1;
//		} 위의 삼항연산자로...
		
		arr = MyArray.add(arr, r);
		return arr;
	}
	
	// 댓글 삭제 
	public static Reply[] delete(Reply[] arr, Reply r) {
		arr = MyArray.remove(arr, r);
		// 댓글을 쓴 사람만 댓글을 제거하도록 
		
		return arr; 
	}
	
	// 해당 글의 댓글의 갯수를 보여주는 메소드 
	public static int countReply(int boardId, Reply[] replyArr) {
		int count = 0;
		for(Reply r : replyArr) {
			if(r.boardId == boardId) {
				count++;
			}
		}
		return count;
		
	}


}
