import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamTest {
	
	static void write(List<Person> pers) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("pers.dat"));
			oos.writeObject(pers);
//			oos.writeInt(pers.size());
//			for(Person p : pers) {
//				oos.writeObject(p);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static List<Person> read(){
//		List<Person> pers = new ArrayList<>();
		
		ObjectInputStream ois = null;
		List<Person> pers = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("pers.dat"));
			pers = (List<Person>)(ois.readObject());
//			int count = ois.readInt();
//			for (int i = 0 ; i < count; i++) {
//				Person p = (Person)(ois.readObject());
//				pers.add(p);
//			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null ) ois.close();
			} catch (IOException e) {
				e.printStackTrace();;
			}
		}
		return pers;
	}
	
	public static void main(String[] args) {
		
//		List<Person> pers = new ArrayList<>();
//		pers.add(new Person("hong", 20, 173.5, false));
//		pers.add(new Person("song", 30, 183.7, false));
//		pers.add(new Person("gong", 40, 174.2, true));
//		write(pers);
		
		List<Person> pers = read();
		for(Person p : pers) {
			System.out.println(p);
		}
		
		
	}

}
