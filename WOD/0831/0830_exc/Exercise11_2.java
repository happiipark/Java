package exc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

class Exercise11_2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		HashSet set = new HashSet(list);
		TreeSet tset = new TreeSet(set);
		Stack stack = new Stack();
		stack.addAll(tset);
		while (!stack.empty())
			System.out.println(stack.pop());
	}
}

// HashSet -> 순서 상관 없이, 중복 없이 들어감 : 3, 6, 2, 7
// TreeSet -> 크기 순서대로 들어감 : 2, 3, 6, 7
// stack   -> 2,3,6,7로 스택에 쌓임
// 스택은 FILO 처음 들어간 게 제일 마지막
// 답 : 7 6 3 2 순으로 출력