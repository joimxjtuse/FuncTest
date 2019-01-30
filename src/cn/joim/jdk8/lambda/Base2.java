package cn.joim.jdk8.lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Lambda与Stream结合
 */
public class Base2 {

    private static List<Person> javaProgrammers;

    private static List<Person> phpProgrammers;

    private static void initPersonList() {

        javaProgrammers = new ArrayList<>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
    }

    public static void main(String[] args) {

        initPersonList();

        forEachNamePrint();

        forEachAddSalary();

    }


    private static void forEachNamePrint() {
        System.out.println("\nShow programmers names:");

        javaProgrammers.forEach(person -> System.out.printf("%s %s;", person.getFirstName(), person.getLastName()));
        System.out.println();

        phpProgrammers.forEach(person -> System.out.printf("%s %s;", person.getFirstName(), person.getLastName()));
    }

    private static void forEachAddSalary() {

        javaProgrammers.forEach(person -> person.setSalary((int) (person.getSalary() * 1.5));

        Consumer<Person> consumer = phpProgrammer -> phpProgrammer.setSalary((int) (phpProgrammer.getSalary() * 1.5));
        phpProgrammers.forEach(consumer);

    }
}
