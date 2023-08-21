package exc;


class SutdaCard{ // 섯다
	int num =1;
	boolean isKwang = true;
	
	// 내가 푼거
	String info() {
		String result = "";
		if(isKwang == true) {
			result = num + "광";
		} else {
//			result = String.valueOf(num);
			result = num + "";
		}
		return result;
	}
	
	// 강사님이 푼거 
	String info1() {
		return num + (isKwang ? "광" : "");
	}
}

public class Ex1_2 {	
	
	public static void main(String[] args) {
		SutdaCard card1 = new SutdaCard();
		card1.num = 3;
		card1.isKwang = false;
		
		SutdaCard card2 = new SutdaCard(); // 
		System.out.println(card1.info()); 
		System.out.println(card2.info()); // 1K
		
	}

}

// 3
// 1K
