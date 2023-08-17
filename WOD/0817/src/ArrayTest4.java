
public class ArrayTest4 {

	public static void main(String[] args) {
		String hex = "13A0C";
		int hex1 = 1;
		String[] binary = new String[] { 
				"0000", "0001", "0010", "0011", // 0,1,2,3
				"0100", "0101", "0110", "0111", // 4,5,6,7
				"1000", "1001", "1010", "1011", // 8,9,10(A),11(B)
				"1100", "1101", "1110", "1111" // 12(C),13(D),14(E),15(F)
		};
		String result = "";
		for (int i = 0; i < hex.length(); i++) {  
			// String 변수는 변수명.length() 메서드를 사용하여 크기 구할 수 있다
			// 배열은 배열 변수명.length 메서드 사용하여 크기 구할 수 있다
			char ch = hex.charAt(i);
			if (ch >= '0' && ch <= '9') {
				result += binary[ch - '0'];
			} else {
				result += binary[9 + ch - 'A' + 1];
			}
		}
		System.out.println("hex : " + new String(hex));
		System.out.println("binary : " + result);

	}

}

// 출력 결과 
// hex : 13A0C
// binary : 00010011101000001100
