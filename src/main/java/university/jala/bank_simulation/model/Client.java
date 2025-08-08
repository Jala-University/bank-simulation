package university.jala.bank_simulation.model;

import java.util.concurrent.atomic.AtomicLong;

public class Client implements Comparable<Client> {
    private static final AtomicLong SEQUENCE = new AtomicLong(0);

    private final String id;
    private final ServiceType serviceType;
    private final PriorityType priority;
    private final int serviceTime;
    private final long sequenceNumber;

    public Client(String id, ServiceType serviceType, PriorityType priority, int serviceTime) {
        this.id = id;
        this.serviceType = serviceType;
        this.priority = priority;
        this.serviceTime = serviceTime;
        this.sequenceNumber = SEQUENCE.getAndIncrement();
    }

    public String getId() {
        return id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public PriorityType getPriority() {
        return priority;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public long getSequenceNumber() {
        return sequenceNumber;
    }

    @Override
    public int compareTo(Client other) {
        // Compare by priority value (higher priority first)
        int priorityComparison = Integer.compare(
                other.priority.getPriorityValue(),
                this.priority.getPriorityValue()
        );

        if (priorityComparison != 0) {
            return priorityComparison;
        }

        // For same priority, earlier sequence number comes first
        return Long.compare(this.sequenceNumber, other.sequenceNumber);
    }

    @Override
    public String toString() {
        return id;
    }
}