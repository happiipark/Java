package com.test03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestMain03 {

	public static void main(String[] args) {
		
		
		double sum = 0.00;
		double avg = 0.00;
		String str = "1.22,4.12,5.93,8.71,9.34";
		// StringTokenizer 이용하여 List에 저장한다.
		// List에 저장된 데이터의 합과 평균을 구한다.

		StringTokenizer st = new StringTokenizer(str, ",");
		
		List<String> list = new ArrayList<>();
		
		while(st.hasMoreElements()) {
			list.add(st.nextToken());		
		}
		
		for(int i = 0; i < list.size(); i++) {
			sum +=Double.parseDouble(list.get(i));
		}
		avg = sum / list.size();
		System.out.println(String.format("합계 : %.3f", sum));  // %.3 -> 소수점 자리 표현
		System.out.println(String.format("평균 : %.3f", avg));
		
	}

}
