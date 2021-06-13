package ro.fasttrackit.curs17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PersonServiceTest {

    @Test
    @DisplayName("WHEN majorPerson() THEN return all the major persons")
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
                new Person("Radulescu", "Nicoleta", 75, "Oradea")
        ));
    }

    private PersonService populateService() {
        return new PersonService(List.of(
                new Person("Popescu", "Andrei", 16, "Oradea"),
                new Person("Bitman", "Dan", 50, "Oradea"),
                new Person("Popa", "Adrian", 43, "Cluj"),
                new Person("Darie", "Emanuel", 10, "Cluj"),
                new Person("Radulescu", "Nicoleta", 75, "Oradea")
        ));
    }
}