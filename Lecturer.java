import java.util.ArrayList;
import java.util.List;

class Lecturer implements Participant {
    private String name;
    private String department;
    private String title;
    private List<Course> coursesTeaching;

    public Lecturer(String name, String department, String title) {
        this.name = name;
        this.department = department;
        this.title = title;
        this.coursesTeaching = new ArrayList<>();
    }

    // Method to create a new course
    public void createCourse(String type, String courseName, int courseNumber, int maxEnrollment) {
        Course newCourse = CourseFactory.createCourse(type, courseName, courseNumber, maxEnrollment);
        coursesTeaching.add(newCourse);
        RegistrationSystem.getInstance().defineCourse(newCourse);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public List<Course> getCoursesTeaching() {
        return coursesTeaching;
    }
}
