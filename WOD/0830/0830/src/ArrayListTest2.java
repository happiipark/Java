import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest2 {
	
	static void print(List<Integer> list) {
		for(Integer n : list) {
			System.out.print(n+",");
		}
		System.out.println();
	}
	
	static void print2(List<Person> list) {
		for(Person n : list) {
			System.out.println(n+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(4);
		list1.add(3);
		list1.add(5);
		list1.add(1);
		
		ArrayList<Integer> list2 = new ArrayList<>(list1);
		print(list1);
		print(list2);
		
		List<Integer> sublist = list1.subList(2, 4);
		print(sublist);
		
		Collections.sort(list1);
		print(list1);
		
		ArrayList<Person> list3 = new ArrayList<>();
		list3.add(new Person("hong",30));
		list3.add(new Person("song",20));
		list3.add(new Person("gong",25));
		print2(list3);
		Collections.sort(list3); 
		// sort(정리)를 할려면 일반적으로 String, Integer은 가능하지만 
		//내가 만든 클래스는 불가능 할 수 있다 -> 비교 할 수 없어서 
		// 비교를 위해서 내가 만든 클래스에 implements Comparable<클래스타입>
		// Comparable을 구현
		//그리고 compareTo 메소드를 오버라이딩!
		print2(list3);
		
	}
}
