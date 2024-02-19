package com.student;
import com.student.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    void addStudent() throws IOException {
        System.out.println("Enter user name:");
        String name = br.readLine();
        System.out.println("Enter user phone:");
        String phone = br.readLine();
        System.out.println("Enter user city:");
        String city=br.readLine();
        //create student object to store student
        Student st=new Student(name,phone,city);
       boolean answer= studentDao.insertStudnetToDB(st);
        if (answer)
        {
            System.out.println("Student is added Successfully");
        }
        else {
            System.out.println("Something went wrong please try again.....");
        }
        System.out.println(st);

    }

    static void deleteStudent()throws IOException {
        // Implement deletion logic
        System.out.println("Enter student id to delete");
        int userID=Integer.parseInt(br.readLine());
       boolean f= studentDao.deleteStudent(userID);
        if (f)
        {
            System.out.println("Student Delete Successfully");
        }
        else {
            System.out.println("Something went wrong please try again.....");
        }




    }

    static void displayStudent() {
        // Implement display logic
        studentDao.showAllStudent();

    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome to the Student Management App!");

        while (true) {
            System.out.println("PRESS 1 TO ADD STUDENT ");
            System.out.println("PRESS 2 TO DELETE STUDENT");
            System.out.println("PRESS 3 TO DISPLAY STUDENT");
            System.out.println("PRESS 0 TO EXIT APP");

            try {
                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        new Main().addStudent();
                        System.out.println("You selected 1. Add Student");
                        break;
                    case 2:
                        deleteStudent();
                        System.out.println("You selected 2. Delete Student");
                        break;
                    case 3:
                        displayStudent();
                        System.out.println("You selected 3. Display Students");
                        break;
                    case 0:
                        System.out.println("Exiting the application. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error reading input. Please try again.");
            }
            System.out.println("Thank you for using my application.......->");
        }
    }
}
