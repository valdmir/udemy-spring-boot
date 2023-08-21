package com.bivala.advancedmapping;

import com.bivala.advancedmapping.dao.AppDAO;
import com.bivala.advancedmapping.entity.Instructor;
import com.bivala.advancedmapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			System.out.println("hello world");
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
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
