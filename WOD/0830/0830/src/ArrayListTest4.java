import java.util.ArrayList;
import java.util.List;

public class ArrayListTest4 {
	
	
	static void print(List<Integer> list) {
		for(Integer n : list) {
			System.out.print(n+",");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(10);
		list1.add(5);  //0
		list1.add(4);  //1
		list1.add(2);  //2
		list1.add(0);  //3
		list1.add(1);  //4
		list1.add(3);  //5
		
		
		List<Integer> list2 = list1.subList(1, 4);
		print(list1);
		print(list2);
		System.out.println(list1.containsAll(list2));
		System.out.println("======[ retainAll ]======");
		list1.retainAll(list2);  // retainAll() : 포함된거 제외하고 삭제?
		print(list1);
		System.out.println("======[ add ]======");
		list1.add(0,6); // 0번째에 6 삽입
		print(list1);
		System.out.println("======[ set ]======");
		list1.set(0,7); // 0번째 데이터를 7로 변경
		print(list1);
		System.out.println("======[ add ]======");
		list1.add(7); // 리스트 끝에 데이터  7 추가
		print(list1);
		System.out.println("======[ remove ]======");
		list1.remove(new Integer(7)); // 특정 데이터 삭제 중복될 경우 가장 앞에 있는 데이터만
		print(list1);
	}

}
