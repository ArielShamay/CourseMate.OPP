// Strategy Pattern for Enrollment
public class FastTrackEnrollment implements EnrollmentStrategy {
    @Override
    public void enroll(Student student, Course course) {
        System.out.println("Fast-track enrollment for " + student + " to " + course.getName());
    }
}
