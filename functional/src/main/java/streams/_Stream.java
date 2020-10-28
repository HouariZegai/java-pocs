package streams;

import static streams._Stream.Gender.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Houari", MALE),
                new Person("Fatima", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Mohamed", MALE)
        );

        // Get only genders
        Set<Gender> genders = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());
        genders.forEach(System.out::println);

        System.out.println("Names length:");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean containsOnlyMales = people.stream()
                .allMatch(person -> MALE.equals(person.gender));
        System.out.println("List contains only males?: " + containsOnlyMales);

        boolean isContainsFemale = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));
        System.out.println("Contains female?: " + isContainsFemale);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
