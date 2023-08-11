
public class OperTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(10/4);  // 2출력
		System.out.println(10.0/4);  // 2출력
		
		int kor = 99, eng = 88, math = 100;
		int tot = kor+eng+math;
		double avg = (double)tot/3;
		System.out.println("총점 : " + tot + ", 평균 : " + avg);
		
		int mod = 10%4;
		System.out.println(mod);
		
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b);
		System.out.println(c);
		
		int i1 = 100000;
		int i2 = 200000;
		long res = (long)i1 * i2;
		System.out.println(res);
		
		long i3 = 100000*100000L;
		System.out.println(i3);
		
		int i4 = 100000*100000/100000; // 오버플로우 발생
		System.out.println(i4);
		
		int i5 = 100000/100000*100000; // 오버 플로우 발생 X
		System.out.println(i5);
	}

}
