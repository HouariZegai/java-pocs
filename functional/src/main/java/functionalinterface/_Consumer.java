package functionalinterface;

import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Normal Java function
        Customer customer = new Customer("Mohamed", "1234");
        greetConsumer(customer);

        // Consumer functional interface
        greetConsumerCustomer.accept(customer);
    }

    static Consumer<Customer> greetConsumerCustomer = customer -> System.out.println("Hello " + customer.name + " thanks for registering the phone " + customer.phone);

    static void greetConsumer(Customer customer) {
        System.out.println("Hello " + customer.name + " thanks for registering the phone " + customer.phone);
    }

    static class Customer {
        private String name;
        private String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
