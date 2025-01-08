// Command Pattern for User Actions
public class RequestNotificationCommand implements Command {
    private Student student;
    private Course course;

    public RequestNotificationCommand(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public void execute() {
        System.out.println(student + " has requested notifications for " + course.getName());
    }
}
