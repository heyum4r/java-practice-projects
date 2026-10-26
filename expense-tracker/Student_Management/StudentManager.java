package Student_Management;
import java.util.Random;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Random random = new Random();


    private boolean isIdExist(String id) {
        for(Student std : students) {
            if(std.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String generateUniqueID() {
        String newId;
        do {
            int number = 100000 + random.nextInt(900000);
            newId = String.valueOf(number);
        }while(isIdExist(newId));

            return newId;
    }

    //Add students
    public void addStudent(String name, String roll, String course, String email) {
        String uniqueId = generateUniqueID(); 

        Student newStudent = new Student(name, roll, course, email, uniqueId);
        
        students.add(newStudent);
        
        System.out.println("Student added successfully! Generated ID: " + uniqueId);
    }

    
   
   

    public static boolean setNameValidation(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        } else {
            return name.matches("^[a-zA-Z\\s]+$");
        }
    }

    public static boolean setCourseValidation(String course) {
        if (course == null || course.trim().isEmpty()) {
            return false;
        } else {
            return course.matches("^[a-zA-Z0-9\\s]+$");
        }
    }

    public static boolean rollValidation(String roll) {
        if (roll == null || roll.trim().isEmpty()) {
            return false;
        } else {
            return roll.matches("^[a-zA-Z0-9]+$");
        }
    }

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static boolean gmailValidation(String gmail) {
        if (gmail == null || gmail.trim().isEmpty()) {
            return false;
        } else {
            return gmail.matches(EMAIL_REGEX);
        }
    }

    // Delete Students
    public void deleteStudent(String id) {

        boolean removeStudent = students.removeIf(std -> std.getId().equalsIgnoreCase(id));
        if (removeStudent) {
            System.out.println("Student details removed!");
        } else {
            System.out.println("Student details not found!");
        }

    }

    // Update Students
    public void updateStudent(String id, String email) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.get(i).setEmail(email);
                return;
            }

        }
        System.out.println("Student not found!");

    }

    // Search students
    public void searchStudent(String id) {
        for (Student std : students) {
            if (std.getId().equalsIgnoreCase(id)) {
                System.out.println("found: " + std);
                return;
            }
        }
        System.out.println("Student details not found!");
    }

    // get all students
    public void history() {
        if (students.size() == 0) {
            System.out.println("No History avilable!");
        } else {
            System.out.println(students);

        }
    }

}
