
public class MyInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 이름을 저장할 변수 선언하여 본인이름 할당
		String name = "박행복";
		
		// 나이를 저장할 변수 선언하여 본인나이 할당
		int age = 28;
		
		// 키를 저장할 변수 선언하여 본인키 소수점까지 할당
		double height = 180.00;
		
		// 남여 구분을 저장할 변수를 선언하여 본인 성별 할당 'F' or 'M'
		char gender = 'M';
		
		System.out.println(String.format("%s, %d, %f, %c", name, age, height, gender));
		
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(gender);
		
		
		
		
		
		
	}

}
