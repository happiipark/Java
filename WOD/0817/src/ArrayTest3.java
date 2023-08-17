

public class ArrayTest3 {

	public static void main(String[] args) {
		char[] hex = new char[] {'C','A','F','E','2','0','2','3'};
		String[] binary = new String[] {
				"0000", "0001", "0010", "0011", //0,1,2,3
				"0100", "0101", "0110", "0111", //4,5,6,7
				"1000", "1001", "1010", "1011", //8,9,10(A),11(B)
				"1100", "1101", "1110", "1111"  //12(C),13(D),14(E),15(F)
		};
		
		String result = "";
		
		for(int i=0; i<hex.length; i++) {
			char ch = hex[i];
			if(ch>='0' && ch<='9') {
				result += binary[ch-'0'];
			}else {
				result += binary[9+ch-'A'+1];
			}
			
		}
		System.out.println("hex : " + new String(hex));
		System.out.println("binary : " + result);
		
		// '0' => 0000 (binary[0])
		// '1' => 0001 (binary[1])
		// '9' => 0010 (binary[9])
		
		// 'A' => 0010 (binary[9]) 9 + 'F' - 'A' + 1 => 10
		// 'B' => 1010 (binary[10]) 9 - 'B' -'A' + 1 => 11
		// 'F' => 1011 (binary[15]) 9 + 'F' - 'A' = 69 - 65 + 1 = 5
	}

}

// 출력 결과
// hex : CAFE2023
// binary : 11001010111111100010000000010011
