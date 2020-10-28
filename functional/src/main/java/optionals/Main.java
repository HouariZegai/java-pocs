package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> getDefaultStringValueSupplier = () -> "default value";

        Object value = Optional.ofNullable(null)
                .orElseGet(getDefaultStringValueSupplier);
        System.out.println(value);

        Object v2 = Optional.ofNullable("hello")
                .orElseThrow(IllegalStateException::new);
        System.out.println(v2);

        Optional.ofNullable("med@houarizegai.org")
                .ifPresent(System.out::println);

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email), () -> System.out.println("Cannot send email"));

    }
}
