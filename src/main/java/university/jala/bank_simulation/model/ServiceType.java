package university.jala.bank_simulation.model;

/**
 * Types of services available at the bank.
 */
public enum ServiceType {
    CASHIER("Caja"),
    PLATFORM("Plataforma");

    private final String displayName;

    ServiceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}