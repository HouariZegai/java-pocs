package streams.sample;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Filter
        List<Person> females = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.getGender()))
                .collect(Collectors.toList());
        females.forEach(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Houari", 24, Gender.MALE),
                new Person("Fatima", 50, Gender.FEMALE),
                new Person("Mohamed", 39, Gender.MALE),
                new Person("Aisha", 10, Gender.FEMALE)
        );
    }
}
