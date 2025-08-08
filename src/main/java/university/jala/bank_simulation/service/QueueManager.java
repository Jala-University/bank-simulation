package university.jala.bank_simulation.service;

import university.jala.bank_simulation.model.Client;
import university.jala.bank_simulation.model.ServiceType;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Manages client queues for different service types.
 */
public class QueueManager {
    private final BlockingQueue<Client> cashierQueue = new PriorityBlockingQueue<>();
    private final BlockingQueue<Client> platformQueue = new PriorityBlockingQueue<>();

    public void addClient(Client client) {
        if (client.getServiceType() == ServiceType.CASHIER) {
            cashierQueue.add(client);
        } else {
            platformQueue.add(client);
        }
    }

    public Client getNextCashierClient() throws InterruptedException {
        return cashierQueue.take();
    }

    public Client getNextPlatformClient() throws InterruptedException {
        return platformQueue.take();
    }

    public boolean hasCashierClients() {
        return !cashierQueue.isEmpty();
    }

    public boolean hasPlatformClients() {
        return !platformQueue.isEmpty();
    }
}