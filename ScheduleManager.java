import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance = null;
    private List<Task> tasks = new ArrayList<>();
    private List<ScheduleObserver> observers = new ArrayList<>();

    private ScheduleManager() {}
    public static ScheduleManager getInstance() {
        if (instance == null) instance = new ScheduleManager();
        return instance;
    }

    public void registerObserver(ScheduleObserver obs) {
        observers.add(obs);
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (isOverlap(t, task)) {
                notifyObservers("Error: Task conflicts with existing task \"" + t.getDescription() + "\".");
                Logger.getInstance().log("Task conflict detected with " + t.getDescription());
                return;
            }
        }
        tasks.add(task);
        Collections.sort(tasks);
        System.out.println("Task added successfully. No conflicts.");
        Logger.getInstance().log("Task added: " + task.getDescription());
        notifyObservers("Task added: " + task.getDescription());
    }

    public void removeTask(String description) {
        Iterator<Task> it = tasks.iterator();
        boolean found = false;
        while (it.hasNext()) {
            Task t = it.next();
            if (t.getDescription().equalsIgnoreCase(description)) {
                it.remove();
                System.out.println("Task removed successfully.");
                Logger.getInstance().log("Task removed: " + description);
                found = true;
                notifyObservers("Task removed: " + description);
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Task not found.");
            Logger.getInstance().log("Error: Task removal failed for " + description);
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            Logger.getInstance().log("Viewed empty schedule.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t.getStartTime() + " - " + t.getEndTime() + ": " +
                t.getDescription() + " [" + t.getPriority() + "]");
        }
        Logger.getInstance().log("Tasks viewed.");
    }

    private boolean isOverlap(Task t1, Task t2) {
        int start1 = Integer.parseInt(t1.getStartTime().replace(":", ""));
        int end1 = Integer.parseInt(t1.getEndTime().replace(":", ""));
        int start2 = Integer.parseInt(t2.getStartTime().replace(":", ""));
        int end2 = Integer.parseInt(t2.getEndTime().replace(":", ""));
        return start1 < end2 && start2 < end1;
    }

    private void notifyObservers(String message) {
        for (ScheduleObserver obs : observers) {
            obs.notify(message);
        }
    }
}