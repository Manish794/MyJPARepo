package com.manish.jpa.app.service.test;

import java.util.List;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.service.StudentService;

public class GetByCityStudentTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();

		List<Student> students = service.getStudentByCity("Delhi");
		if (students != null && students.size() > 0) {
			for (Student st : students) {
				System.out.println(st);
			}
		} else {
			System.out.println("No Data");
		}
	}
}
