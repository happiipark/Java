import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		vector.add(10);
		vector.add(20);
		vector.add(30);
		vector.add(40);
		
		Enumeration<Integer> e = vector.elements();
		
		System.out.println("==== [ Vector (Enumeration)  ] ====");
		
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		Iterator<Integer> it =  list.iterator();
		
		System.out.println("==== [ ArrayList (Iterator)  ] ====");
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("==== [ ListIterator 정방향 ] ====");
		ListIterator<Integer> lit = list.listIterator();
		while(lit.hasNext()) {
			System.out.println(lit.next());
		}
		System.out.println("==== [ ListIterator 역방향 ] ====");
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
		
	}

}
