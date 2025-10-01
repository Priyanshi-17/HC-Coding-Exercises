
public class TaskFactory {
    public static Task createTask(String description, String start, String end, String priority) {
        if (!isValidTimeFormat(start) || !isValidTimeFormat(end)) {
            Logger.getInstance().log("Error: Invalid time format.");
            System.out.println("Error: Invalid time format.");
            return null;
        }
        return new Task(description, start, end, priority);
    }
    private static boolean isValidTimeFormat(String time) {
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }
}