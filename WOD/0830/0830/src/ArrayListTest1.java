import java.util.ArrayList;

class Person implements Comparable<Person> {
	String name;
	int age;
	Person(){}
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "(" +name + "," + age +")";
	}
	
	@Override
	public int compareTo(Person o) {
//		return age-o.age;
		return name.compareTo(o.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person == false) {
			return false;
		}
		Person p = (Person)obj;
		return name.equals(p.name) && age == p.age;
	}
}

public class ArrayListTest1 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(100); 
		int n = (Integer)al.get(0);
		
		
		Integer in = 200;
		int in2 = in;  //UnBoxing
		
		ArrayList al2 = new ArrayList(); 
		al2.add(new Person());  // arraylist안에 새로운 객체를 생성해도 object 클래스로 되깅
		Person p = (Person)al2.get(0); // 매번 다운캐스팅 해줘야함
		
		ArrayList<Person> al3 = new ArrayList<>(); // 제네릭 사용  // 들어올 클래스 타입 지정 가능
		al3.add(new Person());
		Person p2 = al3.get(0);
	}
}
