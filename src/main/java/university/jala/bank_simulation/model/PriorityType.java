package university.jala.bank_simulation.model;

/**
 * Priority levels for bank clients.
 */
public enum PriorityType {
    PREGNANT("Gestante", 1),
    ELDERLY("Adulto Mayor", 1),
    DISABLED("Discapacitado", 1),
    NORMAL("Normal", 0);

    private final String displayName;
    private final int priorityValue;

    PriorityType(String displayName, int priorityValue) {
        this.displayName = displayName;
        this.priorityValue = priorityValue;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public boolean isPriority() {
        return priorityValue > 0;
    }
}