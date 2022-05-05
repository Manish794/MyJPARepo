package com.manish.jpa.app.service.test;

import java.util.List;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.service.StudentService;

public class GetByNameStartsTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();

		List<Student> students = service.getStudentByNameWithLike("K");
		if (students != null && students.size() > 0) {
			for (Student st : students) {
				System.out.println(st);
			}
		} else {
			System.out.println("No Data");
		}
	}
}
