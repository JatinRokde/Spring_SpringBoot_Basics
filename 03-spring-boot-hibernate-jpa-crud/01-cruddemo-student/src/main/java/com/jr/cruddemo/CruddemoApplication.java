package com.jr.cruddemo;

import com.jr.cruddemo.dao.StudentDAO;
import com.jr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting Student with ID: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change first name to "Madhur"
		System.out.println("Updating Student.. ");
		myStudent.setFirstName("Madhur");

		// update the Student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated Student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Bhatnagar");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object.. ");
		Student tempStudent = new Student("Rahul", "Gupta", "rahul.gupta@cuchd.in");

		// save the student
		System.out.println("Saving the student.. ");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated ID: " + theId);

		// retrieve the student based on the id: primary key
		System.out.println("Retrieving student with the ID " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the Student: " + myStudent);
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
