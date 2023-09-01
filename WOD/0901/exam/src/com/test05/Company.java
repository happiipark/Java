package com.test05;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		HashMap<Integer, Employee> map = new HashMap<>();
		// 1번의 데이터를 기반으로 객체를 생성하여 HashMap에 저장한다.
		// HashMap에 저장시 키 값은 각 객체의 Number로 한다.
		map.put(1, new Secretary("홍길동", 1, "Secretary", 800));
		map.put(2, new Sales("이순신", 2, "Sales", 1200));
		System.out.println(String.format("name\t department\t salary\t"));
		System.out.println("================================");

		// 모든 객체의 기본 정보를 출력한다. ( for문 이용 , keySet() 이용 )
		for (Integer i : map.keySet()) {
			System.out.println(
					String.format("%5s\t %10s\t %7d\t", map.get(i).name, map.get(i).department, map.get(i).salary));
		}

		// 모든 객체의 인센티브 100씩 지급한다.
		System.out.println();
		System.out.println("인센티브100지급");
		System.out.println();

		for (int i = 1; i <= map.size(); i++) {
			if (map.get(i) instanceof Bonus) {
				Bonus bo = (Bonus) map.get(i);
				bo.incentive(100);

			}
			if (map.get(i) instanceof Employee) {
				Employee emp = (Employee) map.get(i);
				emp.tax();
			}
		}

		System.out.println(String.format("name\t department\t salary\t\t tax\t"));
		System.out.println("===========================================");

		// 모든 객체의 정보와 세금을 출력한다. ( for문 이용 )
		for (Integer i : map.keySet()) {
			System.out.println(
					String.format("%5s\t %10s\t %7d\t %.2f", map.get(i).name, map.get(i).department, map.get(i).salary, (double)map.get(i).tax()));
		}
	}

}
