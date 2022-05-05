package com.manish.jpa.app.service.test;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.service.StudentService;

public class UpdateStudentTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();
		Student st = new Student();
		st.setSname("Kumar");
		st.setEmail("kumar@xyz.com");
		st.setCty("Hyd");
		st.setSid(2);
		Student result = service.updateStudent(st);
		System.out.println(result);
	}
}
