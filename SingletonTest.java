import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

    @Test
    public void testSingletonInstance() {
        RegistrationSystem firstInstance = RegistrationSystem.getInstance();
        RegistrationSystem secondInstance = RegistrationSystem.getInstance();
        assertSame(firstInstance, secondInstance, "Different instances are created, not following Singleton pattern.");
    }
}
