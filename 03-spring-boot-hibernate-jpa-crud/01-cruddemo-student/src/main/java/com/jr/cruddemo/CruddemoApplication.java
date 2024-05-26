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
			createStudent(studentDAO);
		};
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
