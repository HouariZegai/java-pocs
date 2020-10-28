package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Houari", "engzegai@gmail.com", "+21370000000000", LocalDate.of(1996, 11, 17));

        System.out.println("Is customer valid?: " + new CustomerValidatorService().isValid(customer));
    }
}
