import java.util.ArrayList;

public class TodoManager {

    private ArrayList<Todo> todos = new ArrayList<>();

    public void addTask(String task) {
        todos.add(new Todo(task));
        System.out.println("Task added succesfully.");
    }

    public void deleteTask(int markedInput) {
         int index = markedInput - 1;

        if (index >= 0 && index < todos.size()) {
            Todo todo = todos.get(index);
            todos.remove(index);
            System.out.println("\nTask \"" + todo.getDescription() + "\" Remove suceesfully!\n");
        } else {
            System.out.println("\nInvalid task number!");
        }
    }

    public void markCompleted(int markedInput) {
        int index = markedInput - 1;

        if (index >= 0 && index < todos.size()) {
            Todo todo = todos.get(index);
            todo.markAsComplete();
            System.out.println("\nTask \"" + todo.getDescription() + "\" marked as complete!\n");
        } else {
            System.out.println("\nInvalid task number!");
        }

    }

    public void showTask() {
        if (todos.isEmpty()) {
            System.out.println("\nNo tasks found! Add one first.\n");
            return;
        }
        System.out.println("---------All Task----------");
        for (int i = 0; i < todos.size(); i++) {
            // Todo todo = todos.get(i);
            // String status = todo.getIsCompleted() ? "[X]" : "[ ]";

            // System.out.println((i + 1) + ". " + status + " " + todo.getDescription());
            System.out.println((i + 1) + ". " + todos.get(i));
        }
        System.out.println("--------That's all---------\n");

    }

}
