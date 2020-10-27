package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Normal Java function
        Customer customer = new Customer("Mohamed", "1234");
        greetConsumer(customer);

        // Consumer functional interface
        greetCustomerConsumer.accept(customer);

        // BiConsumer functional interface (takes 2 argument)
        greetCustomerBiConsumer.accept(customer, false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " + customer.name + " thanks for registering the phone " + customer.phone);

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhone) -> System.out.println("Hello " + customer.name + " thanks for registering the phone " + (showPhone ? customer.phone : "*****"));

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
