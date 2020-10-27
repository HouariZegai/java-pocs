package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        String mohamedPhone = "0770000000";
        // Without predicate
        System.out.println(isPhoneNumberValid(mohamedPhone));

        // Using predicate
        System.out.println(isPhoneNumberValidPredicate.test(mohamedPhone));

        // Combine two predicate
        System.out.println("Is phone number valid and contains number 3 = " + isPhoneNumberValidPredicate.and(containsNumber3Predicate).test(mohamedPhone));
        System.out.println("Is phone number valid or contains number 3 = " + isPhoneNumberValidPredicate.or(containsNumber3Predicate).test(mohamedPhone));

        System.out.println(containsSpecificNumberPredicate.test("0779523000", "2"));
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("0") && phoneNumber.length() == 10;
    static Predicate<String> containsNumber3Predicate = phoneNumber -> phoneNumber.contains("5");
    static BiPredicate<String, String> containsSpecificNumberPredicate = (phoneNumber, number) -> phoneNumber.contains(number);

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("0") && phoneNumber.length() == 10;
    }
}
