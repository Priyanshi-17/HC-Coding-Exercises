import java.util.*;

// Observer interface
interface Observer {
    void update(String message);
}

// Subject (Publisher)
class NewsPublisher {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }

    public void publish(String news) {
        System.out.println("[Publisher] " + news);
        for (Observer o : observers) {
            o.update(news);
        }
    }
}

// Concrete Observers
class EmailSubscriber implements Observer {
    private String email;
    EmailSubscriber(String email) { this.email = email; }
    public void update(String message) {
        System.out.println("Email to " + email + ": " + message);
    }
}

class MobileSubscriber implements Observer {
    private String phone;
    MobileSubscriber(String phone) { this.phone = phone; }
    public void update(String message) {
        System.out.println("Push Notification to " + phone + ": " + message);
    }
}

// Demo
public class MainObserver {
    public static void main(String[] args) {
        NewsPublisher publisher = new NewsPublisher();

        Observer emailUser = new EmailSubscriber("alice@example.com");
        Observer mobileUser = new MobileSubscriber("9999999999");

        publisher.addObserver(emailUser);
        publisher.addObserver(mobileUser);

        publisher.publish("Observer Pattern Demo Started!");
        publisher.publish("New article uploaded.");
    }
}
