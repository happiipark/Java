import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
//		StringTokenizer st = new StringTokenizer("apple, banana, orange");
//		StringTokenizer st = new StringTokenizer("apple, banana, orange",",");
		StringTokenizer st = new StringTokenizer("apple#banana$orange,kiwi","#$,");
		// "#$," 구분자 판단
		// 스페이스(공백)로 구분 혹은 구분자( ",")로 구분, 
		//마지막에 true로 줄 경우 ',' 구분자도 데이터로 확인(판단)하여 출력 default는 false임
		while(st.hasMoreTokens()) {   // hasMoreTokens 추가 토근 여부 확인
			System.out.println(st.nextToken());  // 다음 토큰 
		}
		System.out.println(st.countTokens()); // countTokens() : 남아있는 토큰 수 카운트
	}

}
