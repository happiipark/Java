import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
//			fis = new FileInputStream("news.txt");
//			fos = new FileOutputStream("news2.txt");
			fis = new FileInputStream("WOD.jpg");
			fos = new FileOutputStream("WOD2.jpg");
			
			
//			int data;
//			while ((data = fis.read()) != -1) { 
//				// 모든 파일은 마지막 값이 -1
//				// 마지막 값이 -1이 아니면  news에 데이터를 읽어 news2에 저장
//				// -1이, 즉 마지막 바이트에 다다르면 데이터 쓰기 종료
//				fos.write(data); //news를 news2에 복사
//			}
			
			
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] buff = new byte[100];
			int len;
			while((len=bis.read(buff)) > 0) {  // 꽉 채워서읽어온다
//				fos.write(buff,0,len);  // 실제 읽어온 길이만큼 읽기
				bos.write(buff,0,len);
				//
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
//				if (fis != null)
//					fis.close();
				
				
				if (bis != null) bis.close();
				
				
//				if (fos != null)
//					fis.close();
				
				
				if (bos != null) bos.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
