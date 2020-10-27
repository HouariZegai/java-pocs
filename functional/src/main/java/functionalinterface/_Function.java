package functionalinterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10);
        System.out.println(addBy1AndThenMultiplyBy10.apply(2));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }
}
