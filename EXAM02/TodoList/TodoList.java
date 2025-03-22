// TaskStatus Enum
enum TaskStatus {
    NEW, IN_PROGRESS, COMPLETED
}

// TodoList Class
public class TodoList {
    private final Task[] tasks;
    private final int capacity;
    private int currentSize = 0;
    private int count;

    public TodoList(int capacity) {
        this.capacity = capacity;
        tasks = new Task[capacity];
    }

    public void addTask(String description) {
        if (currentSize < capacity) {
            tasks[currentSize] = new Task(description);
            currentSize++;
            count++;
        }
    }

    public void setStatus(int index, TaskStatus status) {
        if (index >= 0 && index < currentSize) {
            tasks[index].setStatus(status);
        }
    }

    public void setDescription(int index, String newDescription) {
        if (index >= 0 && index < currentSize) {
            tasks[index].setDescription(newDescription);
        }
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < currentSize; i++) {
            System.out.printf("%-33s | %s\n", tasks[i].getDescription(), tasks[i].getStatus());
        }
    }

    public int getCount() {
        return this.count;
    }
}

