// Strategy Pattern for Enrollment
public class StandardEnrollment implements EnrollmentStrategy {
    @Override
    public void enroll(Student student, Course course) {
        System.out.println("Enrolling " + student + " to " + course.getName() + " with standard procedures.");
    }
}
