import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest1 { // 읽어서 콘솔에 출력

	public static void main(String[] args) {
//		FileInputStream fis = null;  // 바이트 단위로 읽어주면 다 깨져서 들어옴
		FileReader fis = null;  // 문자단위로 읽어주기 위해
		BufferedReader br = null; // 보조 스트림은 항상 1차 스트림을 가지고 생성
		try {
			// try 안에서 생긴 변수는 final 에 접근 불가능 
			fis = new FileReader("news.txt");
			br = new BufferedReader(fis);
			int data;
			while((data=br.read()) != -1) {
				System.out.print((char)data);
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
