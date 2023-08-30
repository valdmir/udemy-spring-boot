package com.bivala.advancedmapping;

import com.bivala.advancedmapping.dao.AppDAO;
import com.bivala.advancedmapping.entity.Course;
import com.bivala.advancedmapping.entity.Instructor;
import com.bivala.advancedmapping.entity.InstructorDetail;
import com.bivala.advancedmapping.entity.Review;
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
			deleteCourseAndReviews(appDAO);
		};



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
		int theId=1;
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
