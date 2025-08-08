package university.jala.bank_simulation.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    @Test
    public void testClientComparison() {
        Client normal1 = new Client("c1", ServiceType.CASHIER, PriorityType.NORMAL, 500);
        Client normal2 = new Client("c2", ServiceType.PLATFORM, PriorityType.NORMAL, 500);
        Client pregnant = new Client("c3", ServiceType.CASHIER, PriorityType.PREGNANT, 500);
        Client elderly = new Client("c4", ServiceType.PLATFORM, PriorityType.ELDERLY, 500);

        // Priority clients should come before normal clients
        assertTrue(pregnant.compareTo(normal1) < 0, "Pregnant should have higher priority than normal");
        assertTrue(elderly.compareTo(normal2) < 0, "Elderly should have higher priority than normal");

        // Earlier sequence number comes first for same priority
        assertTrue(normal1.compareTo(normal2) < 0, "c1 should come before c2 in FIFO order");
    }
}