package com.manish.jpa.app.service.test;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.service.StudentService;

public class SearchByIdTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();

		Student result = service.getStudentById(2);
		System.out.println(result);

	}
}
