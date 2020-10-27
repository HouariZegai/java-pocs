package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        // Function takes 1 argument and produce 1 result
        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(2));

        // BiFunction takes 2 argument and produce 1 result
        System.out.println(incrementBy1AndMultiplyBiFunction.apply(3, 5));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementBy1AndMultiplyBiFunction = (number, numToMultiplyBy) -> (number + 1) * numToMultiplyBy;

    static int incrementByOne(int number) {
        return number + 1;
    }
}
