package com.manish.jpa.app.service.test;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.service.StudentService;

public class AddStudentTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();
		Student st = new Student();
		st.setSname("mohan");
		st.setEmail("mohan@xyz.com");
		st.setCty("Delhi");
		Student result = service.addStudent(st);
		System.out.println(result);
	}
}
