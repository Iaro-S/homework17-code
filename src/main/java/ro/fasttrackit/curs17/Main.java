package ro.fasttrackit.curs17;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService persons = new PersonService(List.of(
                new Person("Popescu", "Andrei", 25, "Oradea"),
                new Person("Ionescu", "Maria", 17, "Cluj"),
                new Person("Bitman", "Dan", 50, "Brasov"),
                new Person("Balan", "Diana", 15, "Bucuresti"),
                new Person("Popa", "Adrian", 43, "Cluj"),
                new Person("Popescu", "Marcel", 16, "Iasi"),
                new Person("Zanc", "Ioana", 32, "Oradea"),
                new Person("Darie", "Emanuel", 10, "Cluj"),
                new Person("Radulescu", "Nicoleta", 75, "Oradea"),
                new Person("Popa", "Maria", 18, "Cluj")
        ));

        System.out.println("\n" + "Persons names : ");
        persons.getFullName().forEach(System.out::println);

        System.out.println("\n" + "Persons with age over 18 : ");
        persons.majorPersons().forEach(System.out::println);

        System.out.println("\n" + "Persons from Oradea: ");
        persons.fromCity().forEach(System.out::println);

        System.out.println("\n" + "Persons from Oradea & Cluj: ");
        persons.fromCities().forEach(System.out::println);

        System.out.println("\n" + "Persons sorted by first name :");
        persons.sortByFirstName().forEach(System.out::println);

        System.out.println("\n" + "Persons sorted by last name :");
        persons.sortByLastName().forEach(System.out::println);
    }
}
