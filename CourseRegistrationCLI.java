import java.util.Scanner;
import java.util.Map;

public class CourseRegistrationCLI {
    private Scanner scanner;
    private RegistrationSystem registrationSystem;

    public CourseRegistrationCLI() {
        this.scanner = new Scanner(System.in);
        this.registrationSystem = RegistrationSystem.getInstance(); // Ensuring singleton instance
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nCourse Registration System");
            System.out.println("1. Define a course");
            System.out.println("2. Enroll in a course");
            System.out.println("3. Show existing courses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    defineCourse();
                    break;
                case 2:
                    enrollInCourse();
                    break;
                case 3:
                    showExistingCourses();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void defineCourse() {
        System.out.print("Enter course type (Seminar/Elective/Mandatory): ");
        String type = scanner.next();
        System.out.print("Enter course name: ");
        String name = scanner.next();
        System.out.print("Enter course number: ");
        int courseNumber = scanner.nextInt();
        System.out.print("Enter course maxEnrollment: ");
        int maxEnrollment = scanner.nextInt();

        Course course = CourseFactory.createCourse(type, name, courseNumber, maxEnrollment);
        registrationSystem.defineCourse(course);
        System.out.println("Course defined successfully.");
    }

    private void enrollInCourse() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        String studentID = scanner.next();
        System.out.print("Enter major: ");
        String major = scanner.next();
        System.out.print("Enter course number to enroll in: ");
        int courseNumber = scanner.nextInt();

        Student student = new Student(name, studentID, major);
        Course course = registrationSystem.getCourse(courseNumber);
        if (course != null) {
            student.enrollInCourse(course);
            System.out.println("Enrollment successful.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private void showExistingCourses() {
        System.out.println("Existing Courses:");
        Map<Integer, Course> courses = registrationSystem.getCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses defined yet.");
        } else {
            for (Course course : courses.values()) {
                System.out.println("Course Number: " + course.getCourseNumber() + ", Course Name: " + course.getName());
            }
        }
    }

    public static void main(String[] args) {
        CourseRegistrationCLI cli = new CourseRegistrationCLI();
        cli.start();
    }
}
