import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseName = name -> {
            if(name.isBlank()) throw new IllegalArgumentException("Argument is blank");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseNameAge = (name, age) -> {
            if(name.isBlank()) throw new IllegalArgumentException("Argument is blank");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("Zegai"));
        System.out.println(upperCaseNameAge.apply("Zegai", 24));
    }
}
