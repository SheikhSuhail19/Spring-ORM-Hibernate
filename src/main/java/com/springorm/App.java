package com.springorm;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);

		System.out.println("**********************Welcome to Spring ORM Project**********************");

		while (true) {
			System.out.println("----------SELECT AN OPTION----------:");
			System.out.println("PRESS 1 to Add New Student");
			System.out.println("PRESS 2 to Display a Single Student");
			System.out.println("PRESS 3 to Display all Students");
			System.out.println("PRESS 4 to Update a Student");
			System.out.println("PRESS 5 to Delete a Student");
			System.out.println("PRESS 6 to EXIT");

			try {
				int input = scanner.nextInt();
				scanner.nextLine();

				switch (input) {
					case 1:
						// Case 1: Insert a new student
						System.out.print("Enter student ID: ");
						int studentId = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Enter student name: ");
						String studentName = scanner.nextLine();
						System.out.print("Enter student city: ");
						String studentCity = scanner.nextLine();

						Student student = new Student(studentId, studentName, studentCity);
						int result = studentDao.insert(student);
						System.out.println("Done " + result);
						break;
					case 2:
						// Case 2: Get a student by ID
						System.out.print("Enter student ID: ");
						int getStudentId = scanner.nextInt();
						scanner.nextLine();
						Student resultStudent = studentDao.getStudent(getStudentId);
						System.out.println(resultStudent);
						break;
					case 3:
						// Case 3: Get all students
						List<Student> allStudents = studentDao.getAllStudents();
						System.out.println(allStudents);
						break;
					case 4:
						// Case 4: Update a student
						System.out.print("Enter student ID to update: ");
						int updateStudentId = scanner.nextInt();
						scanner.nextLine();
						Student updatedStudent = studentDao.getStudent(updateStudentId);
						System.out.print("Enter updated student name: ");
						String updatedName = scanner.nextLine();
						System.out.print("Enter updated student city: ");
						String updatedCity = scanner.nextLine();

						updatedStudent.setStudentName(updatedName);
						updatedStudent.setStudentCity(updatedCity);

						studentDao.updateStudent(updatedStudent);
						System.out.println(updatedStudent);
						break;
					case 5:
						// Case 5: Delete a student
						System.out.print("Enter student ID to delete: ");
						int deleteStudentId = scanner.nextInt();
						studentDao.deleteStudent(deleteStudentId);
						break;
					case 6:
						System.out.println("Thank you for using this application");
						System.exit(0);
				}

			} catch (Exception e) {
				System.out.println("Invalid input, try with another one !!!");
				System.out.println(e.getMessage());
			}
		}

	}
}


//        Student student = new Student(212, "Winnie", "Disneyland");

//        int r = studentDao.insert(student);
//        System.out.println("Done " + r);

//        Student result = studentDao.getStudent(212);
//        System.out.println(result);

//        List<Student> result = studentDao.getAllStudents();
//        System.out.println(result);

//        result.setStudentName("Winnie the Pooh");
//
//        studentDao.updateStudent(result);
//        System.out.println(result);

//        studentDao.deleteStudent(222);
