package com.sagar.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sagar.practice.controller.IStudentController;
import com.sagar.practice.factory.StudentControllerFactory;
import com.sagar.practice.model.Student;

public class Application {
	public static void main(String[] args) {
		
		IStudentController studentController = null;
		String status = null;
		String name = null;
		String email = null;
		String city = null;
		String country = null;
		Integer id = null;
		Student studentRecord = null;
		
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. Create");
				System.out.println("2. Read");
				System.out.println("3. Update");
				System.out.println("4. Delete");
				System.out.println("5. Exit");
				System.out.print("Enter your choice :: ");
				Integer choice = Integer.parseInt(br.readLine());
				studentController = StudentControllerFactory.getStudentController();
				
				switch(choice) {
				case 1:
					System.out.println("Enter the name : ");
					name = br.readLine();
					
					System.out.println("Enter the email : ");
					email = br.readLine();
					
					System.out.println("Enter the city : ");
					city = br.readLine();
					
					System.out.println("Enter the country : ");
					country = br.readLine();
					
					Student student = new Student();
					// sid is set as auto-increment in database table so no need to send from here
					student.setName(name);
					student.setEmail(email);
					student.setCity(city);
					student.setCountry(country);
					
					status = studentController.save(student);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record inserted successfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record insertion failed...");
					} else {
						System.out.println("Some problem occured...");
					}
					break;
				case 2:
					System.out.println("Enter the id : ");
					id = Integer.parseInt(br.readLine());
					
					studentRecord = studentController.findById(id);
					if (studentRecord != null) {
						System.out.println(studentRecord);
					} else {
						System.out.println("Record not available for given id :: " + id);
					}
					break;
				case 3:
					System.out.println("Enter the id : ");
					id = Integer.parseInt(br.readLine());
					
					studentRecord = studentController.findById(id);
					if (studentRecord != null) {
						Student newStudent = new Student();
						newStudent.setsId(id);
						System.out.println("Please provide updated details : ");
						
						System.out.println("Old name is :: " + studentRecord.getName());
						String newName = br.readLine();
						if (newName.equals("") || newName == null) {
							newStudent.setName(studentRecord.getName());
						} else {
							newStudent.setName(newName);
						}
						
						System.out.println("Old email is :: " + studentRecord.getEmail());
						String newEmail = br.readLine();
						if (newEmail.equals("") || newEmail == null) {
							newStudent.setEmail(studentRecord.getEmail());
						} else {
							newStudent.setEmail(newEmail);
						}
						
						System.out.println("Old City is :: " + studentRecord.getCity());
						String newCity = br.readLine();
						if (newCity.equals("") || newCity == null) {
							newStudent.setCity(studentRecord.getCity());
						} else {
							newStudent.setCity(newCity);
						}
						
						System.out.println("Old country is :: " + studentRecord.getCountry());
						String newCountry = br.readLine();
						if (newCountry.equals("") || newCountry == null) {
							newStudent.setCountry(studentRecord.getCountry());
						} else {
							newStudent.setCountry(newCountry);
						}
						
						status = studentController.updateById(newStudent);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Record updated successfully...");
						} else if (status.equalsIgnoreCase("failure")) {
							System.out.println("Record updation failed...");
						} else {
							System.out.println("Some problem occured...");
						}
						
					} else {
						System.out.println("Record not available for given id :: " + id);
					}
					break;
				case 4:
					System.out.println("Enter the id : ");
					id = Integer.parseInt(br.readLine());
					
					status = studentController.deleteById(id);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record deleted successfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record deletion failed...");
					} else {
						System.out.println("Record not available for given id :: " + id);
					}
					break;
				case 5:
					System.out.println("Thanks for using the application...");
					System.exit(0);
				default :
					System.out.println("Please choose correct options...");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}