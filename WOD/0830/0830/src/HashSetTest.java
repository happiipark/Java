import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
//		HashSet<Integer> hs = new HashSet<>(Arrays.asList(1,2,3,4,5));
//		for(Integer n : hs) {
//			System.out.println(n);
//		}

		HashSet<Integer> hs = new HashSet<>();
		// 중복허용X(Set의 특징), 차례대로 들어가지 않는다(Hash 의 특징)
		hs.add(234);
		hs.add(14);
		hs.add(45);
		hs.add(8);
		hs.add(11);
		hs.add(45);
//		for(Integer n : hs) {
//			System.out.println(n);
//		}

		HashSet<Person> ahs = new HashSet<>();
		ahs.add(new Person("홍길동", 23));
		ahs.add(new Person("김길동", 30));
		ahs.add(new Person("고길동", 33));
		ahs.add(new Person("하길동", 40));
		ahs.add(new Person("고길동", 33));
		// HashSet 에서 add할경우 발생하는 과정
		// 내부에서 같은 데이터인지의 여부를 입력되는 데이터의 hashCode() 와 equals() 함수로
		// 동일한 데이터를 넣으면 10 하나만 출력, 집합형태임

		/*
		 * add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출하므로 저장할 객체의 equals()와
		 * hashCode()가 적절히 오버라이딩되어 있어야 한다. 그렇지 않으면 중복된 객체를 중복된 것으로 간주하지 않을 수 있다.
		 */

		for (Person p : ahs) {
			System.out.println(p);
		}

	}

}
