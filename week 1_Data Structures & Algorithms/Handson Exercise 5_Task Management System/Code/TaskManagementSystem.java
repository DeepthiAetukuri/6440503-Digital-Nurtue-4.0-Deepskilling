public class TaskManagementSystem {
    static class Task {
        int taskId;
        String taskName;
        String status;
        Task next;
        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }
        @Override
        public String toString() {
            return taskId + " - " + taskName + " - " + status;
        }
    }
    static Task head = null;
    public static void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }
    public static Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public static void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }
        Task current = head;
        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
    public static void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
    public static void main(String[] args) {
        addTask(1, "Design UI", "Pending");
        addTask(2, "Implement Backend", "In Progress");
        addTask(3, "Write Tests", "Pending");
        System.out.println("All Tasks:");
        displayTasks();
        System.out.println("\nSearching for Task ID 2:");
        Task found = searchTask(2);
        System.out.println(found != null ? "Found: " + found : "Task not found.");
        System.out.println("\nDeleting Task ID 1:");
        deleteTask(1);
        displayTasks();
    }
}
