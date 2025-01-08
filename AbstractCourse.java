import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCourse implements Course {
    protected String name;
    protected int courseNumber;
    protected List<Student> enrolledStudents;
    protected int maxEnrollment; // Maximum number of students that can enroll

    public AbstractCourse(String name, int courseNumber, int maxEnrollment) {
        this.name = name;
        this.courseNumber = courseNumber;
        this.enrolledStudents = new ArrayList<>();
        this.maxEnrollment = maxEnrollment;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCourseNumber() {
        return courseNumber;
    }

    public boolean enroll(Student student) {
        if (enrolledStudents.size() >= maxEnrollment) {
            throw new IllegalStateException("Course is full");
        }
        enrolledStudents.add(student);
        return true;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}
