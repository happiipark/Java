import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();  // Queue는 객체 생성시 LinkList()로
		queue.add(100); //데이터 삽입을 enqueue
		queue.offer(200); // enqueue
		queue.offer(300); // enqueue
		
		System.out.println("==== [데이터 삽입] ====");
		System.out.println(queue);
		
		queue.poll(); // 데이터 삭제 dequeue
//		queue.poll(); // 데이터 삭제 dequeue
		queue.remove(); // 데이터 삭제 dequeue
		
		System.out.println("==== [데이터 삭제] ====");
		System.out.println(queue);
		
		System.out.println("==== [데이터 삽입] ====");
		queue.add(100); //데이터 삽입을 enqueue
		queue.offer(200); // enqueue
		queue.offer(300); // enqueue
		System.out.println(queue);
		
		
		System.out.println("==== [데이터 초기화] ====");
		queue.clear(); // 초기화
		System.out.println(queue);
		
	}

}
