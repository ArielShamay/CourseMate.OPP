//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RegistrationIntegrationTest {
//
//    @Test
//    public void testCourseNotification() {
//        RegistrationSystem system = RegistrationSystem.getInstance();
//        Course course = CourseFactory.createCourse("mandatory", "Data Structures", 202);
//        system.defineCourse(course);
//
//        // Assuming there's a method to add and notify observers
//        CourseAvailabilityNotifier notifier = new CourseAvailabilityNotifier();
//        TestObserver observer = new TestObserver();
//        notifier.addObserver(observer);
//
//        // Simulate course becoming available
//        notifier.notifyObservers(course);
//        assertEquals("Data Structures", observer.getNotifiedCourse().getName());
//    }
//
//    private class TestObserver implements CourseObserver {
//        private Course notifiedCourse;
//
//        @Override
//        public void update(Course course) {
//            this.notifiedCourse = course;
//        }
//
//        public Course getNotifiedCourse() {
//            return notifiedCourse;
//        }
//    }
//}
