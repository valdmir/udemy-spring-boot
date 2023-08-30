package com.bivala.advancedmapping;

import com.bivala.advancedmapping.dao.AppDAO;
import com.bivala.advancedmapping.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			System.out.println("hello world");
//			createCourseAndReviews(appDAO);
//			retrieveAndReviews(appDAO);
//			deleteCourseAndReviews(appDAO);
//			createCoruseAndStudents(appDAO);
//			findCourseAndstudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addMoreCoursesForStudent(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};




	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=2;

		System.out.println("Deleting" );
		appDAO.deleteStudentById(theId);
		System.out.println("Done" );
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCoursesByStudentId(2);
		Course tempCourse1=new Course("New Rubik Cube");
		Course tempCourse2=new Course("Atari 2600");
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Updating Student:"+tempStudent);
		System.out.println("Associated courses:"+tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("Done!!");

	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding instructor id"+theId);
		Student student= appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("tempInstructor: "+student);
		System.out.println("the associated courses: "+student.getCourses());

		System.out.println("Done!!");
	}

	private void findCourseAndstudents(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id"+theId);
		Course course= appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("tempInstructor: "+course);
		System.out.println("the associated courses: "+course.getStudents());

		System.out.println("Done!!");
	}

	private void createCoruseAndStudents(AppDAO appDAO) {
//		create a course
		Course tempCourse=new Course("Pacman Test");
//		create the students
		Student tempStudent1=new Student("Testing","testing","testing@testing.com");

		Student tempStudent2=new Student("Testing 2","testing","testing@testing2.com");
//		add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

//		save the course and associated students
		System.out.println("Saving the coruse "+tempCourse);

		System.out.println("Saving the coruse "+tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Done");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=1;

		System.out.println("Deleting reviews" );
		appDAO.deleteCourseById(theId);
////		print the course
//		System.out.println(tempCourse);
//		System.out.println(tempCourse.getReviews());
		System.out.println("Done" );
	}

	private void retrieveAndReviews(AppDAO appDAO) {
//		get the course and reviews
		int theId=1;
		Course tempCourse=appDAO.findCourseAndReviewsByCourseId(theId);
//		print the course
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done" );
	}

	private void createCourseAndReviews(AppDAO appDAO) {
//		create a course
		Course tempCourse=new Course("Paceman");
		tempCourse.addReview(new Review("Bagus"));
		tempCourse.addReview(new Review("jelek"));
		tempCourse.addReview(new Review("perlu diperbaiki"));

//		add some reviews
		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("Done");
//		save the course
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding Course id"+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding Course id"+theId);
		Course tempCourse= appDAO.findCourseById(theId);
		System.out.println("temp Course: "+tempCourse);
		tempCourse.setTitle("Test changed");
		appDAO.update(tempCourse);
		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id"+theId);
		Instructor tempInstructor=appDAO.findInstructorByID(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		tempInstructor.setLastName("DONO");
		appDAO.update(tempInstructor);
		System.out.println("Done!!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id"+theId);
		Instructor tempInstructor= appDAO.findInstructorByJoinFetch(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());

		System.out.println("Done!!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id"+theId);
		Instructor tempInstructor=appDAO.findInstructorByID(theId);
		System.out.println("tempInstructor: "+tempInstructor);
//		find courses for instructor
		List<Course> courseList=appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courseList);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id"+theId);
		Instructor tempInstructor=appDAO.findInstructorByID(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor=
				new Instructor("Fred","Dharby","vladasdasdff@gmail.com");
		InstructorDetail tempInstructorDetail=
				new InstructorDetail("youtube.com","Gamer");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

//		create courses
		Course tempCourse1= new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2= new Course("Pinball Master class");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		System.out.println("Saving instructor "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		appDAO.deleteInstructorDetailByID(theId);
		System.out.println("delete instructor detail");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding instructor id"+theId);
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailByID(theId);
		System.out.println("tempInstructor:"+tempInstructorDetail.getInstructor());
		System.out.println("tempInstructorDetail:"+tempInstructorDetail);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		appDAO.deleteInstructorByID(theId);
		System.out.println("delete instructor");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id"+theId);
		Instructor tempInstructor=appDAO.findInstructorByID(theId);
		System.out.println("tempInstructor:"+tempInstructor);
		System.out.println("tempInstructorDetail:"+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor=
//				new Instructor("Chad","Dharby","vladasdf@gmail.com");
//		InstructorDetail tempInstructorDetail=
//				new InstructorDetail("testing@asdf.com","Luv2");

		Instructor tempInstructor=
				new Instructor("Fred","Dharby","vladasdasdff@gmail.com");
		InstructorDetail tempInstructorDetail=
				new InstructorDetail("testing@asdf.com","Luv2 asdfa");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving instructor "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");

	}
}
