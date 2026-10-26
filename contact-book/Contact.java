public class Contact {
    private String name;
    private String contactNum;
    private String email;

    public Contact(String name, String contactNum, String email) {
        this.name = name;
        this.contactNum = contactNum;
        this.email = email;
    }

    public String getName() {
        return name;
    } 

    public String getContactNum() {
        return contactNum;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Number: " + contactNum + " Email: " + email + "\n";
    }


}
