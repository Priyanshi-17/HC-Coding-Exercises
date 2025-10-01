import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
        // Optionally write to a file for real logging
        // try (FileWriter fw = new FileWriter("log.txt", true)) {
        //      fw.write(message + "\\n");
        // } catch (IOException e) { /* Handle error */ }
    }
}
