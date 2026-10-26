import java.util.Scanner;

public class Main{
    public static void main(String [] arg){

        Scanner scan = new Scanner(System.in);
        TodoManager manager = new TodoManager();


        while (true) {
            System.out.println("1.Add\n2.Delete\n3.Mark Complete\n4.Show Tasks\n5.Exit");
            int userInput = scan.nextInt();
            scan.nextLine(); //clearing buffer

            switch (userInput) {
                case 1:
                    System.out.println("Add Task: ");
                    String inputTask = scan.nextLine();
                    manager.addTask(inputTask);
                    break;
                case 2:
                    System.out.println("Enter task Number want to Delete Task: ");
                    int deleteTask = scan.nextInt();
                    manager.deleteTask(deleteTask);
                    break;
                case 3:
                    System.out.println("Enter task Number want to mark as Completed: ");
                    int marked = scan.nextInt();
                    manager.markCompleted(marked);
                    break;
                case 4:
                    manager.showTask();
                    break;
                case 5:
                    return;
            
                default: 
                    System.out.println("Enter a valid Number. Try again!");
                    break;
            }
            
        }
    }
}