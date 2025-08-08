package university.jala.bank_simulation.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityTypeTest {
    @Test
    public void testPriorityValues() {
        assertTrue(PriorityType.PREGNANT.isPriority());
        assertTrue(PriorityType.ELDERLY.isPriority());
        assertTrue(PriorityType.DISABLED.isPriority());
        assertFalse(PriorityType.NORMAL.isPriority());
    }
}