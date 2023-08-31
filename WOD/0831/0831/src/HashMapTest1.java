import java.util.HashMap;
import java.util.Map;

public class HashMapTest1 {
	public static void main(String[] args) {
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("1001", 35); // 데이터 삽입(key,value)
		if (hmap.containsKey("1001") == false) { // key 존재 여부 확인
			hmap.put("1001", 40);
		}
		hmap.put("1002", 20);
		hmap.put("1003", 33);
		hmap.put("1004", 27);
		Integer value = hmap.get("1001"); // key를 value 조회
		System.out.println(value);
		System.out.println("=======");
		for (Integer n : hmap.values()) { // value 전체 목록 조회
			System.out.println(n);
		}

		System.out.println("=======");
		for (String k : hmap.keySet()) { // key 전체 목록 조회
			System.out.println(k);
		}

		System.out.println("=======");
		for (String k : hmap.keySet()) { // key 전체 목록 조회
			System.out.println(hmap.get(k)); // value 조회
		}

		System.out.println("=======");
		for (String k  : hmap.keySet()) { // key 전체 목록 조회
			System.out.println(String.format("key : %s, value : %d", k, hmap.get(k))); // value 조회
		}
		
		hmap.remove("1004");

		System.out.println("=======");
		for (Map.Entry<String, Integer> entry : hmap.entrySet()) { // key 전체 목록 조회
			System.out.println(String.format("key : %s, value : %d"
					, entry.getKey(), entry.getValue())); // value 조회
		}
	}

}
