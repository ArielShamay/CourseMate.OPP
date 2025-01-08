import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;

public class CourseRegistrationSystemTest {
    private RegistrationSystem registrationSystem;

    @Before
    public void setUp() {
        registrationSystem = RegistrationSystem.getInstance();
        registrationSystem.reset(); // Assuming you have a method to clear the system state for testing
    }

    // Test to ensure RegistrationSystem is a singleton
    @Test
    public void testSingleton() {
        RegistrationSystem anotherInstance = RegistrationSystem.getInstance();
        assertSame("RegistrationSystem should be singleton", registrationSystem, anotherInstance);
    }

    // Test creating and retrieving courses
    @Test
    public void testCreateAndRetrieveCourse() {
        Course course = CourseFactory.createCourse("mandatory", "Object Oriented Programming", 201, 100);
        registrationSystem.defineCourse(course);
        assertNotNull("Course should be defined", registrationSystem.getCourse(201));
        assertEquals("Course name should match", "Object Oriented Programming", registrationSystem.getCourse(201).getName());
    }

    // Test handling of duplicate courses
    @Test
    public void testNoDuplicateCourse() {
        Course course1 = CourseFactory.createCourse("elective", "Software Engineering", 202, 100);
        registrationSystem.defineCourse(course1);
        Course course2 = CourseFactory.createCourse("elective", "Advanced SE", 202, 100);
        registrationSystem.defineCourse(course2); // Try to redefine
        assertEquals("No duplicate course numbers allowed", "Software Engineering", registrationSystem.getCourse(202).getName());
    }

    // Test enrolling a student in a course
    @Test
    public void testEnrollStudent() {
        Student student = new Student("Alice", "000111", "Software Engineering");
        Course course = CourseFactory.createCourse("elective", "System Design", 203, 100);
        registrationSystem.defineCourse(course);
        student.enrollInCourse(course);
        assertTrue("Student should be enrolled", student.getCurrentCourses().contains(course));
    }

//    // Test enrollment limits (assuming an enrollment limit feature is added)
//    @Test
//    public void testEnrollmentLimit() {
//        Course course = CourseFactory.createCourse("seminar", "Microservices Architecture", 204, 100);
//        registrationSystem.defineCourse(course);
//        for (int i = 0; i < 100; i++) {
//            Student student = new Student("Student" + i, "ID" + i, "IT");
//            student.enrollInCourse(course);
//        }
//        Student extraStudent = new Student("John Doe", "010101", "IT");
//        try {
//            extraStudent.enrollInCourse(course);
//            fail("Should throw an exception when exceeding enrollment limit");
//        } catch (Exception e) {
//            assertEquals("Course full exception expected", "Course is full", e.getMessage());
//        }
//    }

    // Test notification system
    @Test
    public void testNotificationSystem() {
        Course course = CourseFactory.createCourse("seminar", "Database Systems", 205, 100);
        registrationSystem.defineCourse(course);
        CourseAvailabilityNotifier notifier = new CourseAvailabilityNotifier();
        Student student = new Student("Bob", "202020", "Computer Science");

        notifier.addObserver(student);
        notifier.notifyObservers(course);
        assertTrue("Student should be notified", student.getNotifications().contains("Database Systems available"));
    }

    // Testing command pattern for user actions
    @Test
    public void testCommandPattern() {
        Student student = new Student("Charlie", "303030", "History");
        Course course = CourseFactory.createCourse("mandatory", "World History", 206, 100);
        registrationSystem.defineCourse(course);

        student.addCourseToCart(course); // Directly invoking for simplicity
        assertTrue("Course should be in student's cart", student.getCoursesInCart().contains(course));
    }

    @After
    public void tearDown() {
        registrationSystem.reset(); // Clear the system state after each test
    }
}
