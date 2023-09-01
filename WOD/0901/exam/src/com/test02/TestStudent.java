package com.test02;

import java.util.ArrayList;
import java.util.List;

public class TestStudent {

	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>(); 
		// Student 객체를 3개 생성하여 List에 저장한다.
		// List에 저장된 Student 객체 정보를 출력한다.
		list.add(new Student("홍길동", 20, 177, 74, "201301", "체육"));
		list.add(new Student("이순신", 44, 178, 77, "201302", "체육"));
		list.add(new Student("유관수", 18, 155, 45, "201303", "컴퓨터"));
		
		for(Student s : list) {
			System.out.println(s);
		}
	}

}
