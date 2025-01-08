// Singleton Course Registration System
import java.util.HashMap;
import java.util.Map;

public class RegistrationSystem {
    private static RegistrationSystem instance;
    private Map<Integer, Course> courses = new HashMap<>();

    private RegistrationSystem() {}

    public static synchronized RegistrationSystem getInstance() {
        if (instance == null) {
            instance = new RegistrationSystem();
        }
        return instance;
    }

    public void defineCourse(Course course) {
        if (!courses.containsKey(course.getCourseNumber())) {
            courses.put(course.getCourseNumber(), course);
        }
    }

    public Course getCourse(int courseNumber) {
        return courses.get(courseNumber);
    }

    public Map<Integer,Course> getCourses() {
        return courses;
    }

    public void reset() {
        courses.clear();
    }
}

