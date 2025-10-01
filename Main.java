import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        scheduleManager.registerObserver(new ConflictAlertObserver());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Astronaut Daily Schedule Organizer");

        while (true) {
            System.out.println("\nOptions: [1] Add Task [2] Remove Task [3] View Tasks [0] Exit");
            int opt = scanner.nextInt();
            scanner.nextLine();

            if (opt == 0) break;
            if (opt == 1) {
                System.out.print("Description: ");
                String desc = scanner.nextLine();
                System.out.print("Start time (HH:mm): ");
                String start = scanner.nextLine();
                System.out.print("End time (HH:mm): ");
                String end = scanner.nextLine();
                System.out.print("Priority (Low/Medium/High): ");
                String priority = scanner.nextLine();

                Task task = TaskFactory.createTask(desc, start, end, priority);
                if (task == null) { continue; }
                scheduleManager.addTask(task);
            } 
            else if (opt == 2) {
                System.out.print("Task description to remove: ");
                String desc = scanner.nextLine();
                scheduleManager.removeTask(desc);
            } 
            else if (opt == 3) {
                scheduleManager.viewTasks();
            }
        }
        scanner.close();
    }
}