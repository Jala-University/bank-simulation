package university.jala.bank_simulation.service;

import university.jala.bank_simulation.model.Client;

import java.util.concurrent.CountDownLatch;

/**
 * Represents a service point that attends clients.
 */
public class ServicePoint implements Runnable {
    private final String name;
    private final QueueManager queueManager;
    private final boolean isCashier;
    private final CountDownLatch latch;

    public ServicePoint(String name, QueueManager queueManager,
                        boolean isCashier, CountDownLatch latch) {
        this.name = name;
        this.queueManager = queueManager;
        this.isCashier = isCashier;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Client client = isCashier ?
                        queueManager.getNextCashierClient() :
                        queueManager.getNextPlatformClient();

                System.out.println(client + ", en atención " + name);

                // Simulate service time
                Thread.sleep(client.getServiceTime());

                System.out.println(client + ", servido");
                latch.countDown();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}