package functional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> data = Arrays.asList("Houari", "Mohamed", "Omar", "Fares", "Abdellah", "Abdelkader", "Karim", "Ibrahim", "Nacer");

        // filter
        System.out.println("Filter:");
        data.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);

        // map
        System.out.println("\nMap:");
        data.stream()
                .mapToInt(name -> name.length())
                .forEach(numLetters -> System.out.println(numLetters));

        // collect
        Map<Character, List<String>> groupings = data.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        groupings.forEach((firstLetter, names) -> {
            System.out.println(firstLetter + ": " + names);
        });
    }
}
