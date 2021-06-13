package ro.fasttrackit.curs17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PersonServiceTest {

    @Test
    @DisplayName("WHEN getFullName() is used THEN return first and last name of persons")
    void fullname() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<String> result = service.getFullName();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                "Popescu Andrei",
                "Bitman Dan",
                "Popa Adrian",
                "Darie Emanuel",
                "Radulescu Nicoleta"
        ));
    }

    @Test
    @DisplayName("WHEN fromCity() is used THEN return persons from Oradea")
    void fromOradea() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<Person> result = service.fromCity();
        //ASSERT
        assertThat(result).hasSize(2);
        assertThat(result).isEqualTo(List.of(
                new Person("Popescu", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea")
        ));
    }

    @Test
    @DisplayName("WHEN fromCities() is used THEN return persons from Oradea and Cluj")
    void fromOradeaAndCluj() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<Person> result = service.fromCities();
        //ASSERT
        assertThat(result).hasSize(3);
        assertThat(result).isEqualTo(List.of(
                new Person("Popescu", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Popa", "Adrian", 43, "Cluj")
        ));
    }

    @Test
    @DisplayName("WHEN majorPerson() is used THEN return all the major persons")
    void major() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<Person> result = service.majorPersons();
        //ASSERT
        assertThat(result).hasSize(3);
        assertThat(result).isEqualTo(List.of(
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Popa", "Adrian", 43, "Cluj"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi")
        ));
    }

    @Test
    @DisplayName("WHEN sortByFirstName() is used THEN return list of persons sorted by first name")
    void sortFirstName() {
        //SETUP
        PersonService service = new PersonService(List.of(
                new Person("Popescu", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi")
        ));
        //RUN
        List<Person> result = service.sortByFirstName();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Popescu", "Andrei", 16, "Oradea"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi")
        ));

    }

    @Test
    @DisplayName("WHEN sortByLastName() is used THEN return list of persons sorted by last name")
    void sortLastName() {
        //SETUP
        PersonService service = new PersonService(List.of(
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi"),
                new Person("Popescu", "Andrei", 16, "Oradea")
        ));
        //RUN
        List<Person> result = service.sortByLastName();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                new Person("Popescu", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi")
        ));

    }

    private PersonService populateService() {
        return new PersonService(List.of(
                new Person("Popescu", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Popa", "Adrian", 43, "Cluj"),
                new Person("Darie", "Emanuel", 10, "Brasov"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi")
        ));
    }
}