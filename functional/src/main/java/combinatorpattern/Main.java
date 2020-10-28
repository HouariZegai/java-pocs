package combinatorpattern;

import java.time.LocalDate;
import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Houari", "engzegai@gmail.com", "21370000000000", LocalDate.of(1996, 11, 17));

        //System.out.println("Is customer valid?: " + new CustomerValidatorService().isValid(customer));

        // Using combinator pattern
        ValidationResult validationResult = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult()).apply(customer);

        System.out.println(validationResult);
        if(validationResult != ValidationResult.SUCCESS) {
            throw new IllegalStateException(validationResult.name());
        }
    }
}
