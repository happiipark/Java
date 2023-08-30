import java.util.Stack;

public class StackTest {
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500); // push는 데이터 넣기
		
		System.out.println(stack.pop()); // pop은 데이터 빼내기
		System.out.println(stack.pop());
//		System.out.println(stack.toString());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
//		for(Object n : stack) {
//			System.out.println(n);  /
//		}
		
	}

}
