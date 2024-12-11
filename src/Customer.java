
public class Customer {

    private String customerId;
    private String name;

    Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    @SuppressWarnings("override")
    public String toString() {
        return "customer: {" + "\n"
                + "name: " + name + "\n"
                + "customer_id: " + customerId + "\n"
                + "}";
    }
}
