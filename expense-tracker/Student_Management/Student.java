package Student_Management;

public class Student {
    private String name;
    private String roll;
    private String course;
    private String email;
    private String id;

    public Student(String name, String roll, String course, String email, String id) {
        this.name = name;
        this.roll = roll;
        this.course = course;
        this.email = email;
        this.id = id;

    }

   
    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getCourse() {
        return course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Name: '" + name +
                "' Roll: '" + roll +
                "' Course: '" + course +
                "' Email: '" + email +
                "' id: '" + id + "'";
    }

}
