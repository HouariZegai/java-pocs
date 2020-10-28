package combinatorpattern;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate birthDate;

    public Customer(String name, String email, String phoneNumber, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
