import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {

            System.out.println("\n-----Contacts Book-----");
            System.out.println(
                    "(1) Add Contact \n(2) Delete Contact \n(3) Search Contact  \n(4) All Contacts \n(5) Exit ");
            System.out.println("Enter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:

                    String nameInput = "";
                    while (true) {

                        System.out.println("Enter Name: ");
                        nameInput = scan.nextLine();

                        if (manager.nameValidation(nameInput)) {
                            break;
                        } else {
                            System.out.println(
                                    "Invalid name! Name cannot contain numbers or be blank. Please try again.\n");
                        }

                    }

                    String contactInput = "";
                    while (true) {
                        System.out.println("Enter Contact: ");
                        contactInput = scan.nextLine();

                        if (manager.contactValidation(contactInput)) {
                            break;
                        } else {
                            System.out
                                    .println("Invalid ContactNumber format, must have 10 digit & no space. try Again!");
                        }

                    }

                    String emailinput;
                    while (true) {
                        System.out.println("Enter Email: ");
                        emailinput = scan.nextLine();

                         if (manager.emailValidation(emailinput)) {
                            break;
                        } else {
                            System.out
                                    .println("Invalid email format! Example of valid email: user@gmail.com\n");
                        }

                        
                    }
                    manager.addContacts(new Contact(nameInput, contactInput, emailinput));
                    break;

                case 2:
                    System.out.println("Enter Contact Number want to Delete: ");
                    String deleteContact = scan.nextLine();
                    manager.deleteContact(deleteContact);
                    break;

                case 3:
                    System.out.println("Enter Contact Number want to Search: ");
                    String searchContact = scan.nextLine();
                    manager.searchContact(searchContact);
                    break;

                case 4:
                    manager.showContact();
                    break;
                case 5:
                    return;

                default:
                    System.out.println("Enter Valid opration. Try again!");
                    break;
            }

        }

    }
}
