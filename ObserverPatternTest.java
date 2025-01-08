import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverPatternTest {

    @Test
    public void testObserverNotification() {
        CourseAvailabilityNotifier notifier = new CourseAvailabilityNotifier();
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();
        notifier.addObserver(observer1);
        notifier.addObserver(observer2);

        Course course = new Seminar("Advanced Programming", 104, 100);
        notifier.notifyObservers(course);

        assertEquals("Advanced Programming", observer1.getNotifiedCourse().getName(),
                "Observer1 did not receive the correct course notification.");
        assertEquals("Advanced Programming", observer2.getNotifiedCourse().getName(),
                "Observer2 did not receive the correct course notification.");
    }

    private class TestObserver implements CourseObserver {
        private Course notifiedCourse;

        @Override
        public void update(Course course) {
            this.notifiedCourse = course;
        }

        public Course getNotifiedCourse() {
            return notifiedCourse;
        }
    }
}
