// Observer Pattern for Notifications
import java.util.ArrayList;
import java.util.List;

public class CourseAvailabilityNotifier {
    private List<CourseObserver> observers = new ArrayList<>();

    public void addObserver(CourseObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Course course) {
        for (CourseObserver observer : observers) {
            observer.update(course);
        }
    }
}
