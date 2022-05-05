package com.manish.jpa.app.service.test;

import java.util.List;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.service.StudentService;

public class GetAllStudentTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();

		List<Student> students = service.getAllStudents();
		if (students != null) {
			for (Student st : students) {
				System.out.println(st);
			}
		} else {
			System.out.println("No Data");
		}
	}
}
