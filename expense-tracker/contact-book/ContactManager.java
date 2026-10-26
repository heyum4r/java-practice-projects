import java.util.HashMap;

public class ContactManager {
    private HashMap<String, Contact> contactBooks = new HashMap<>();

    // validation

    public boolean nameValidation(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        } else {
            return name.matches("^[a-zA-Z\\s]{2,20}$");
        }
    }

    public boolean contactValidation(String contactNum) {

        if (contactNum == null || contactNum.trim().isEmpty()) {
            return false;
        } else {
            return contactNum.matches("^[\\d]{10}$");
        }
    }

    public boolean emailValidation(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        } else {
            return email.matches("^[a-z\\d]+@[a-z]+\\.[a-z]{2,}$");
        }
    }

    // save contact
    public void addContacts(Contact contactObj) {
        if (contactBooks.containsKey(contactObj.getContactNum())) {
            System.out.println("Number Exist! Try Diffrent Number");

        } else {
            contactBooks.put(contactObj.getContactNum(), contactObj);
        }
    }

    // Delete contact
    public void deleteContact(String contactNumber) {
        Contact found = contactBooks.get(contactNumber);
        if (found != null) {
            contactBooks.remove(contactNumber);
            System.out.println("Contact deleted sucessfully!");
        } else {
            System.out.println("Contact not Found to Delete");
        }
    }

    // search contact
    public void searchContact(String contactNumber) {
        Contact found = contactBooks.get(contactNumber);

        if (found != null) {
            System.out.println("Contact Found!");
            System.out.println(found);
        } else {
            System.out.println("Contact not found!");
        }
    }

    // contact history
    public void showContact() {

        if (!contactBooks.isEmpty()) {
             System.out.println("----All Contacts are:----- ");
            for(Contact c : contactBooks.values()){
                System.out.println(c);
            }
        } else {
            System.out.println("No contact found! Add Frist");
        }
    }

}
