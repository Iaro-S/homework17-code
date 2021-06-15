package ro.fasttrackit.curs17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(Collection<Person> persons) {
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }

    public List<String> getFullName() {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(toList());
    }

    public List<Person> majorPersons() {
        return persons.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(toList());
    }

    public List<Person> fromCity() {
        return persons.stream()
                .filter(person -> person.getCity().equalsIgnoreCase("Oradea"))
                .collect(toList());
    }

    public List<Person> fromCities() {
        return persons.stream()
                .filter(person -> person.getCity().equalsIgnoreCase("Oradea") || person.getCity().equalsIgnoreCase("Cluj"))
                .collect(toList());
    }

    public List<String> firstNamesCapitalized() {
        return persons.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(toList());
    }

    public List<String> lastNameAbbreviated() {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName().charAt(0) + ".")
                .collect(toList());
    }

    public List<Person> ageBetween() {
        return persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 60)
                .collect(toList());
    }

    public List<Person> firstNameWithA() {
        return persons.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .collect(toList());
    }

    public List<String> uniqueFirstName() {
        return persons.stream()
                .map(Person::getFirstName).distinct()
                .collect(toList());
    }

    public List<Person> sortByFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(toList());
    }

    public List<Person> sortByLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(toList());
    }

    public List<Person> multiCriteriaSort() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Comparator.comparing(Person::getLastName)
                                .thenComparing(Person::getAge)))
                .collect(toList());
    }
}

