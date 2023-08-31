import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest3 {
	public static void main(String[] args) {
		Properties prop1 = new Properties();
		try {
			prop1.load(new FileInputStream("setting.txt"));
			System.out.println(prop1.getProperty("title"));
			System.out.println(prop1.getProperty("content"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
// stream byte단위, read/writer 문자 단위
// 프로세스에 꽂는거는 문자단위뿐, piped reader, writer
// 