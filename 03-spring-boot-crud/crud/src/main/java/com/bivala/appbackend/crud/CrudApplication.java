package com.bivala.appbackend.crud;

import com.bivala.appbackend.crud.dao.StudentDAO;
import com.bivala.appbackend.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			System.out.println("Welcomeeee to Bivala CRUD Example");
			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryStudents(studentDAO);
//			queryStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			updateStudentRawQuery(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
			queryStudents(studentDAO);

		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int deletedRows=studentDAO.deleteAll();
		System.out.println("Delete rows==>"+deletedRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(3);
	}

	private void updateStudentRawQuery(StudentDAO studentDAO) {
		int updated=studentDAO.updateWithQuery("Doni","Gumilar",2);
		System.out.println("Student data after update: "+updated);

	}

	private void updateStudent(StudentDAO studentDAO) {
		Student tempStudent=studentDAO.findByID(1);
		System.out.println("Student ID: "+tempStudent.getId());
		System.out.println("Student data: "+tempStudent);

		tempStudent.setLastName("Subandono");
		tempStudent.setEmail("testing.subandono@gmail.com");
		tempStudent.setFirstName("Alisya");
		Student tempStudent2
				=studentDAO.update(tempStudent);
		System.out.println("Student data after update: "+tempStudent2);

	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students=studentDAO.findByLastName("Wijaya");
		for (Student student: students){
			System.out.println(student);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
		List<Student> students=studentDAO.findAll();
		for (Student student: students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent=studentDAO.findByID(1);
		System.out.println("Student ID: "+tempStudent.getId());
		System.out.println("Student data: "+tempStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
//		create student objeect
		System.out.println("Creating new students object ...");
		Student tempStudent=new Student("Testing1","Wijaya","vald.karate@gmail.com");
		Student tempStudent1=new Student("Testing2","Wijaya","vald.karate@gmail.com");
		Student tempStudent2=new Student("Testing3","Wijaya","vald.karate@gmail.com");

//		save the student object
		System.out.println("Saving all the students");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

	}

	private void createStudent(StudentDAO studentDAO) {
//		create student objeect
		System.out.println("Creating new student object ...");
		Student tempstudent=new Student("Freddy1","Wijaya","vald.karate@gmail.com");

//		save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempstudent);
//		display id of the saved student
		System.out.println("Saved student. Generated id: "+tempstudent.getId());
	}
}
