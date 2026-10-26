public class Todo {
    private String description;
    private boolean isCompleted;

    public Todo(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void markAsComplete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + description;
    }

}