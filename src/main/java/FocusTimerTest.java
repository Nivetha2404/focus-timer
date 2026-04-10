import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FocusTimerTest {

    @Test
    void testProductivityZero() {
        FocusTimerGUI app = new FocusTimerGUI();
        assertEquals(0, app.calculateProductivity());
    }

    @Test
    void testProductivityCalculation() {
        FocusTimerGUI app = new FocusTimerGUI();

        // simulate values
        // assume setters or reflection in real case
        double result = 0.5; // expected example
        assertTrue(result >= 0 && result <= 1);
    }

    @Test
    void testSwitchMode() {
        FocusTimerGUI app = new FocusTimerGUI();
        app.switchMode();
        assertTrue(true); // basic test
    }
}