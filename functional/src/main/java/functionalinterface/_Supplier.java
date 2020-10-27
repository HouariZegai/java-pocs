package functionalinterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());

        // Using supplier
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:3306/my_db";

    static String getDBConnectionUrl() {
        return "jdbc://localhost:3306/my_db";
    }
}
