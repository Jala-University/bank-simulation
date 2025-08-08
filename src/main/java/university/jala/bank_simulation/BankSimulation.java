package university.jala.bank_simulation;

import university.jala.bank_simulation.model.Client;
import university.jala.bank_simulation.model.PriorityType;
import university.jala.bank_simulation.model.ServiceType;
import university.jala.bank_simulation.service.QueueManager;
import university.jala.bank_simulation.service.ServicePoint;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main class for bank simulation application.
 */
public class BankSimulation {
    private static final int CASHIERS = 2;
    private static final int PLATFORMS = 1;
    private static final int TOTAL_CLIENTS = 20;

    public static void main(String[] args) {
        QueueManager queueManager = new QueueManager();
        CountDownLatch latch = new CountDownLatch(TOTAL_CLIENTS);
        ExecutorService executor = Executors.newFixedThreadPool(CASHIERS + PLATFORMS);

        // Create service points
        for (int i = 1; i <= CASHIERS; i++) {
            executor.execute(new ServicePoint("Caja" + i, queueManager, true, latch));
        }
        for (int i = 1; i <= PLATFORMS; i++) {
            executor.execute(new ServicePoint("Plataforma" + i, queueManager, false, latch));
        }

        // Create and add clients
        List<Client> clients = generateClients();
        for (Client client : clients) {
            queueManager.addClient(client);
            System.out.println(client.getId() + ", en espera");
        }

        try {
            latch.await();
            executor.shutdownNow();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static List<Client> generateClients() {
        return List.of(
                // First 6 clients from example
                new Client("c1", ServiceType.CASHIER, PriorityType.NORMAL, 500),
                new Client("c2", ServiceType.PLATFORM, PriorityType.NORMAL, 500),
                new Client("c3", ServiceType.CASHIER, PriorityType.NORMAL, 500),
                new Client("c4", ServiceType.CASHIER, PriorityType.ELDERLY, 500),
                new Client("c5", ServiceType.PLATFORM, PriorityType.PREGNANT, 500),
                new Client("c6", ServiceType.CASHIER, PriorityType.NORMAL, 500),

                // Additional 14 clients
                new Client("c7", ServiceType.PLATFORM, PriorityType.DISABLED, 700),
                new Client("c8", ServiceType.CASHIER, PriorityType.NORMAL, 600),
                new Client("c9", ServiceType.PLATFORM, PriorityType.ELDERLY, 800),
                new Client("c10", ServiceType.CASHIER, PriorityType.NORMAL, 550),
                new Client("c11", ServiceType.PLATFORM, PriorityType.NORMAL, 650),
                new Client("c12", ServiceType.CASHIER, PriorityType.PREGNANT, 750),
                new Client("c13", ServiceType.PLATFORM, PriorityType.DISABLED, 500),
                new Client("c14", ServiceType.CASHIER, PriorityType.NORMAL, 600),
                new Client("c15", ServiceType.PLATFORM, PriorityType.ELDERLY, 700),
                new Client("c16", ServiceType.CASHIER, PriorityType.NORMAL, 550),
                new Client("c17", ServiceType.PLATFORM, PriorityType.PREGNANT, 650),
                new Client("c18", ServiceType.CASHIER, PriorityType.NORMAL, 800),
                new Client("c19", ServiceType.PLATFORM, PriorityType.DISABLED, 500),
                new Client("c20", ServiceType.CASHIER, PriorityType.ELDERLY, 700)
        );
    }
}