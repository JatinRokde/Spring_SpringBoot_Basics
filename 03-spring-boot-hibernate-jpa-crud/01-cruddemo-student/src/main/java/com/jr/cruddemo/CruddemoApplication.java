package com.jr.cruddemo;

import com.jr.cruddemo.dao.StudentDAO;
import com.jr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create 3 student objects
		Student tempStudent1 = new Student("Prajwal", "Farkunde", "prajwal.farkunde@cuchd.in");
		Student tempStudent2 = new Student("Vishal", "Singh", "vishal.singh@cuchd.in");
		Student tempStudent3 = new Student("Maulik", "Bhatnagar", "maulik.bhatnagar@cuchd.in");

		//save the student objects
		System.out.println("Saving the Students.. ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating the new Student object.. ");
		Student tempStudent = new Student("Kaushik", "Paul", "kaushik.paul@cuchd.in");

		// save the student object
		System.out.println("Saving the Student.. ");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved Student. Generated ID: " + tempStudent.getId());

	}
}
