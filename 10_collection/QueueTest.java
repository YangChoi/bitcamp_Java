import java.util.LinkedList;
import static java.lang.System.out;

// First in First out
class QueueTest {
	public static void main(String[] args) {
		String[] item = {"소나타", "렉스톤", "재규어"};
		LinkedList<String> q = new LinkedList<String>();

		for(String n : item){ // item을 n에 넣고 
			q.offer(n); // 요소 추가 // 그것을 q에다 넣는다. 
		}

		out.println("q의 크기 : " + q.size() + "\n");
		String data = "";

		while((data = q.poll()) != null){ // data를 꺼내온다. null 이 아니면 (데이터가 있으면)
			out.println(data + "삭제!"); // 삭제한다 
			out.println("q의 크기 : " + q.size() + "\n"); // 총 큐의 크기를 출력 
		}// data가 빌 때 까지 while 문 계속 
	}
}
