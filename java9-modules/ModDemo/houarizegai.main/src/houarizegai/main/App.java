package houarizegai.main;

import houarizegai.util.Calculator;

public class App {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        System.out.println(result);
    }

}
