package streams.sample;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Filter
        System.out.println("// Filtered");
        List<Person> females = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.getGender()))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        // Sort
        System.out.println("// Sorted");
        people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getGender))
                .forEach(System.out::println);

        // Match
        System.out.println("// Match");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 18);
        System.out.println("All have age > 18? " + allMatch);

        boolean femaleExists = people.stream()
                .anyMatch(person -> Gender.FEMALE.equals(person.getGender()));
        System.out.println("Female exists?: " + femaleExists);

        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equalsIgnoreCase("houari"));
        System.out.println("Houari doesn't exists on the list? " + noneMatch);

        // Max / Min
        System.out.println("// Max / Min");
        Optional<Person> oldestPerson = people.stream()
                .max(Comparator.comparing(Person::getAge));
        oldestPerson.ifPresent(person -> System.out.println("Oldest one is: " + person));

        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(person -> System.out.println("Younger person is: " + person));

        // Group
        System.out.println("// Group");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        System.out.println("Males" + groupByGender.get(Gender.MALE));
        System.out.println("Females" + groupByGender.get(Gender.FEMALE));

        // example: get the younger female name
        System.out.print("Younger female name: ");
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .min(Comparator.comparing(Person::getAge))
                .map(Person::getName)
                .ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Houari", 24, Gender.MALE),
                new Person("Fatima", 50, Gender.FEMALE),
                new Person("Mohamed", 18, Gender.MALE),
                new Person("Aisha", 24, Gender.FEMALE)
        );
    }
}
