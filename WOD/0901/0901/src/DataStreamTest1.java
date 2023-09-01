import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable{
	String name;
	int age;
	double height;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	boolean married;

	Person(String name, int age, double height, boolean married) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.married = married;
	}

	@Override
	public String toString() {
		return String.format("이름 : %s, 나이 : %d, 키 : %f, 결혼 : %s", name, age, height, married ? "Y" : "N");
	}
}

public class DataStreamTest1 {

	static void write(Person p) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("person.bin");
			dos = new DataOutputStream(fos);
			// DataOutputStream : 변수의 값을 다양하게 저장하게 해줌
			dos.writeUTF(p.name);
			dos.writeInt(p.age);
			dos.writeDouble(p.height);
			dos.writeBoolean(p.married);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static Person read() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		Person p = null;
		try {
			fis = new FileInputStream("person.bin");
			dis = new DataInputStream(fis);
			String name = dis.readUTF();
			int age = dis.readInt();
			double height = dis.readDouble();
			boolean married = dis.readBoolean();
			p = new Person(name, age, height, married);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	static void write(List<Person> pers) {
		// 작성시(저장시) 사이즈를 알려줘서(저장)
		// 읽어올때 저장한 사이즈를 이용하여반복 가능하게끔 설정
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("person.bin");
			dos = new DataOutputStream(fos);

			dos.writeInt(pers.size()); // 읽을때를 대비해 사이즈(인원수 저장) : 읽을때 반복 횟수 지정을 위해

			for (Person p : pers) {
				dos.writeUTF(p.name);
				dos.writeInt(p.age);
				dos.writeDouble(p.height);
				dos.writeBoolean(p.married);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	static List<Person> readList() {
		List<Person> pers = new ArrayList<>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("person.bin");
			dis = new DataInputStream(fis);

			int count = dis.readInt(); // 사이즈(인원수) 저장 작성시에 미리 저장해둠
			for (int i = 0; i < count; i++) {
				String name = dis.readUTF();
				int age = dis.readInt();
				double height = dis.readDouble();
				boolean married = dis.readBoolean();
				pers.add(new Person(name, age, height, married));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pers;
	}

	public static void main(String[] args) {
//		Person p1 = new Person("hong", 35,175.3,false);
//		write(p1);
//		Person p = read();
//		System.out.println(p);
		// 하나씩 읽고 쓰기
		
		
		

//		List<Person> pers = new ArrayList<>();
//		pers.add(new Person("hong", 20, 173.5, false));
//		pers.add(new Person("song", 30, 183.7, false));
//		pers.add(new Person("gong", 40, 174.2, true));

//		write(pers);
		
		
		// 여러개 읽고 여러개 쓰기
		List<Person> pers = readList();
		for(Person p : pers) {
			System.out.println(p);
		}
		
	}

}
