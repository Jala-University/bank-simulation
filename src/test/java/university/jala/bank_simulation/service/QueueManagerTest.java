package university.jala.bank_simulation.service;

import university.jala.bank_simulation.model.Client;
import university.jala.bank_simulation.model.PriorityType;
import university.jala.bank_simulation.model.ServiceType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueManagerTest {
    @Test
    public void testQueueManagement() throws InterruptedException {
        QueueManager manager = new QueueManager();
        Client cashClient = new Client("c1", ServiceType.CASHIER, PriorityType.NORMAL, 500);
        Client platformClient = new Client("c2", ServiceType.PLATFORM, PriorityType.NORMAL, 500);

        manager.addClient(cashClient);
        manager.addClient(platformClient);

        assertTrue(manager.hasCashierClients());
        assertTrue(manager.hasPlatformClients());
        assertEquals(cashClient, manager.getNextCashierClient());
        assertEquals(platformClient, manager.getNextPlatformClient());
    }
}