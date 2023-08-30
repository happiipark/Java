import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest6 {
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		System.out.println("=====[ numbers ]=====");
		System.out.println(numbers);
		// Arrays.asList(1,2,3,4,5,6,7,8,9) : 들어온 인자로 리스트 생성
		numbers.removeIf(n -> (n%3)==0);
		// 람다식 -> 이후에 나오는게 메서드를 구현한거라 보면 됨
		System.out.println("=====[ 람다식 적용 ]=====");
		System.out.println(numbers);
	}

}
