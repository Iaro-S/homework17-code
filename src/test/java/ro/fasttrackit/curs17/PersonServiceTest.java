package ro.fasttrackit.curs17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PersonServiceTest {

    @Test
    @DisplayName("WHEN multiCriteriaSort() is used THEN return list of persons sorted by first name, last name and then age")
    void multiCriteriaSort() {
        //SETUP
        PersonService service = new PersonService(List.of(
                new Person("Popescu", "Maria", 35, "Oradea"),
                new Person("Popescu", "Ion", 25, "Oradea"),
                new Person("Popescu", "Andrei", 25, "Oradea"),
                new Person("Popescu", "Maria", 57, "Oradea"),
                new Person("Popescu", "Maria", 16, "Oradea"),
                new Person("Popescu", "Ion", 19, "Oradea")
        ));
        //RUN
        List<Person> result = service.multiCriteriaSort();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                new Person("Popescu", "Andrei", 25, "Oradea"),
                new Person("Popescu", "Ion", 19, "Oradea"),
                new Person("Popescu", "Ion", 25, "Oradea"),
                new Person("Popescu", "Maria", 16, "Oradea"),
                new Person("Popescu", "Maria", 35, "Oradea"),
                new Person("Popescu", "Maria", 57, "Oradea")
        ));
    }

    @Test
    @DisplayName("WHEN uniqueFirstName() is used THEN return list list of unique first names")
    void uniqueFirstName() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<String> result = service.uniqueFirstName();
        //ASSERT
        assertThat(result).isEqualTo(List.of("Popa", "Bitman", "Anghel", "Radulescu"));

    }

    @Test
    @DisplayName("WHEN firstNameWithA() is used THEN return list of persons having first name starting with A")
    void firstNameWithA() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<Person> result = service.firstNameWithA();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                new Person("Anghel", "Emanuel", 10, "Brasov")
        ));
    }

    @Test
    @DisplayName("WHEN ageBetween() is used THEN return persons with age between 18 and 60")
    void ageBetween() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<Person> result = service.ageBetween();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Popa", "Adrian", 43, "Cluj")
        ));
    }

    @Test
    @DisplayName("WHEN lastNameAbbreviated() is used THEN return persons first name and last name abbreviated")
    void lastNameAbbreviated() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<String> result = service.lastNameAbbreviated();
        //ASSERT
        assertThat(result).isEqualTo(List.of("Popa A.", "Bitman D.", "Popa A.", "Anghel E.", "Radulescu N."));
    }

    @Test
    @DisplayName("WHEN firstNamesCapitalized() is used THEN return first name of persons CAPITALIZED")
    void firstNamesCapitalized() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<String> result = service.firstNamesCapitalized();
        //ASSERT
        assertThat(result).isEqualTo(List.of("POPA", "BITMAN", "POPA", "ANGHEL", "RADULESCU"));
    }

    @Test
    @DisplayName("WHEN getFullName() is used THEN return first and last name of persons")
    void fullname() {
        //SETUP
        PersonService service = populateService();
        //RUN
        List<String> result = service.getFullName();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                "Popa Andrei",
                "Bitman Dan",
                "Popa Adrian",
                "Anghel Emanuel",
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
                new Person("Popa", "Andrei", 16, "Oradea"),
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
                new Person("Popa", "Andrei", 16, "Oradea"),
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
                new Person("Popa", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi")
        ));
        //RUN
        List<Person> result = service.sortByFirstName();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Popa", "Andrei", 16, "Oradea"),
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
                new Person("Popa", "Andrei", 16, "Oradea")
        ));
        //RUN
        List<Person> result = service.sortByLastName();
        //ASSERT
        assertThat(result).isEqualTo(List.of(
                new Person("Popa", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi")
        ));

    }

    private PersonService populateService() {
        return new PersonService(List.of(
                new Person("Popa", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Popa", "Adrian", 43, "Cluj"),
                new Person("Anghel", "Emanuel", 10, "Brasov"),
                new Person("Radulescu", "Nicoleta", 75, "Iasi")
        ));
    }
}