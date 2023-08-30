package exc;

import java.util.ArrayList;
import java.util.HashSet;

class Exercise11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); // 교집합
		ArrayList cha = new ArrayList(); // 차집합
		ArrayList hap = new ArrayList(); // 합집합
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		

			
		// 교집합 retainAll
		ArrayList kyoList = (ArrayList) list1.clone();
		kyoList.retainAll(list2);
		kyo.addAll(kyoList);
		
		// 차집합 removeAll
		ArrayList chaList = (ArrayList) list1.clone();
		chaList.removeAll(list2);
		cha.addAll(chaList);
		
		// 합집합 addAll
		// 방법 1
		hap.addAll(cha);
		hap.addAll(list2);
		
		
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}