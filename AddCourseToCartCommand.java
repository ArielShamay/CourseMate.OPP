// Command Pattern for User Actions
public class AddCourseToCartCommand implements Command {
    private Student student;
    private Course course;

    public AddCourseToCartCommand(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public void execute() {
        System.out.println("Adding " + course.getName() + " to " + student + "'s cart.");
    }
}
