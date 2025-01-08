import java.util.ArrayList;
import java.util.List;

class Student implements Participant, CourseObserver {
    private String name;
    private String studentID;
    private String major;
    private List<Course> currentCourses;
    private List<Course> coursesInCart;
    private List<String> notifications;

    public Student(String name, String studentID, String major) {
        this.name = name;
        this.studentID = studentID;
        this.major = major;
        this.currentCourses = new ArrayList<>();
        this.coursesInCart = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        currentCourses.add(course);
    }

    public void dropCourse(Course course) {
        currentCourses.remove(course);
    }

    public List<Course> getCurrentCourses() {
        return currentCourses;
    }

    public List<Course> getCoursesInCart() {
        return coursesInCart;
    }

    public void addCourseToCart(Course course) {
        coursesInCart.add(course);
    }

    public List<String> getNotifications() {
        return notifications;
    }

    @Override
    public void update(Course course) {
        notifications.add(course.getName() + " available");
    }
}
