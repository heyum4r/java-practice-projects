package Student_Management;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        StudentManager student = new StudentManager();

        while (true) {
            System.out.println("\n-----Student MANAGEMENT SYSTEM-----");
            System.out.println("(1) Add Student \n(2) Delete Student \n(3) Update Student \n(4) Search Student \n(5) Student History \n(6)Exit ");
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            

            switch (choice) {
                case 1:
                    String name = "";
                    while (true) {
                        System.out.println("Enter Name:");
                        name = scanner.nextLine();

                        if (StudentManager.setNameValidation(name)) {
                            break;
                        } else {
                            System.out.println(
                                    "Invalid name! Name cannot contain numbers or be blank. Please try again.\n");
                        }
                    }

                    String roll = "";
                    while (true) {
                        System.out.println("Enter Roll:");
                        roll = scanner.nextLine();

                        if (StudentManager.rollValidation(roll)) {
                            break;

                        } else {
                            System.out.println(
                                    "Invalid roll number! Must contain only letters and numbers (no symbols or spaces).\n");
                        }
                    }

                    String course = "";
                    while (true) {
                        System.out.println("Enter course:");
                        course = scanner.nextLine();

                        if (StudentManager.setCourseValidation(course)) {
                            break;
                        } else {
                            System.out.println(
                                    "Invalid course! course cannot contain special charactor or be blank. Please try again.\n");
                        }
                    }

                    String email = "";
                    while (true) {
                        System.out.println("Enter email:");
                        email = scanner.nextLine();

                        if (StudentManager.gmailValidation(email)) {
                            break;
                        } else {
                            System.out.println(
                                    "Invalid email format! Example of valid email: user@gmail.com\n");
                        }
                    }

                    student.addStudent(name, roll, course, email);
                    break;

                case 2:
                    System.out.println("Delete Student data by Id : ");
                    String deleteName = scanner.nextLine();
                    student.deleteStudent(deleteName);
                    break;

                case 3:
                    System.out.println("Enter Student ID to update:");
                        String id = scanner.nextLine();

                     String updateEmail = "";
                     while (true) {
                          System.out.println("Enter new email:");
                          updateEmail = scanner.nextLine();

                             if (StudentManager.gmailValidation(updateEmail)) {
                             break; 
                             } else {
                                 System.out.println("Invalid email format! Example: user@gmail.com\n");
                                 }
                                }

                                 student.updateStudent(id, updateEmail);
                                 break;

                case 4:
                    System.out.println("Search Student data by Id : ");
                    String searchName = scanner.nextLine();
                    student.searchStudent(searchName);
                    break;

                case 5:
                    student.history();  
                    break;

                case 6:
                    return;
                default:
                    System.out.println("Invalid Numbers.");
                    break;
            }

        }

    }
}
