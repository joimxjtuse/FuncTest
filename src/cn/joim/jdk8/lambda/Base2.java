package cn.joim.jdk8.lambda;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        /**
         * use one 'filter'.
         * */
        filterOne();

        /**
         * use more 'filter'.
         * */
        filerMore();

        /**
         * use 'limit'.
         * */
        limitResult();

        /**
         * use 'sort'.
         * */
        sort();

        /**
         * use 'min' & 'max'.
         * */
        minAndMax();

        /**
         * use 'map'.
         *
         * */
        map();

        /**
         * use 'parallelStream'.
         *
         * 将任务分为多个小任务分而治之; 机制:ForkJoinPool
         * */
        parallelStream();

        /**
         * use 'summary' 'statistics'.
         *
         * 获取6流中的各种汇总数据， 比如获取最大值，最小值，平均值等。
         * */
        obtainVariousSummaryData();
    }


    private static void forEachNamePrint() {
        System.out.println("\nShow programmers names:");

        javaProgrammers.forEach(person -> System.out.printf("%s %s;", person.getFirstName(), person.getLastName()));
        System.out.println();

        phpProgrammers.forEach(person -> System.out.printf("%s %s;", person.getFirstName(), person.getLastName()));
    }

    private static void forEachAddSalary() {

        javaProgrammers.forEach(person -> person.setSalary((int) (person.getSalary() * 1.5)));

        Consumer<Person> consumer = phpProgrammer -> phpProgrammer.setSalary((int) (phpProgrammer.getSalary() * 1.5));
        phpProgrammers.forEach(consumer);
    }

    private static void filterOne() {
        //过滤除PHP程序员薪水多余1500.
        System.out.println("\nShow PHP programmers that earn more than $1,400:");
        phpProgrammers.stream().filter(phper -> phper.getSalary() > 1500)
                .forEach(programmer -> System.out.printf("%s %s;", programmer.getFirstName(), programmer.getLastName()));
    }

    private static void filerMore() {
        /**
         * 定义多个过滤规则.
         * */
        Predicate<Person> ageFilter = person -> person.getAge() > 25;
        Predicate<Person> salaryFilter = person -> person.getSalary() > 1400;
        Predicate<Person> agenderFilter = person -> "female".equals(person.getGender());

        System.out.println("\nShow female PHP programmers that earn more than $1,400 and are older than 24 years:");
        phpProgrammers.stream()
                .filter(salaryFilter)
                .filter(ageFilter)
                .forEach(phper -> System.out.printf("%s %s; ", phper.getFirstName(), phper.getLastName()));

        System.out.println("\nShow female Java programmers older than 24 years:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(ageFilter)
                .forEach(javaer -> System.out.printf("%s %s; ", javaer.getFirstName(), javaer.getLastName()));
    }

    private static void limitResult() {

        System.out.println("\nShow first 3 Java programmers:");
        javaProgrammers.stream().limit(3)
                .forEach(javaer -> System.out.printf("%s %s; ", javaer.getFirstName(), javaer.getLastName()));

        System.out.println("\nShow first 3 female Java programmers:");
        javaProgrammers.stream()
                .filter(person -> "female".equals(person.getGender()))
                .limit(3)
                .forEach(javaer -> System.out.printf("%s %s; ", javaer.getFirstName(), javaer.getLastName()));

    }

    private static void sort() {

        System.out.println("\nSort and show the first 5 Java programmers by name:");
        List<Person> sortedJavaProgrammers =
                javaProgrammers.stream()
                        .sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                        .limit(5)
                        .collect(Collectors.toList());
        sortedJavaProgrammers.forEach(javaer -> System.out.printf("%s %s; ", javaer.getFirstName(), javaer.getLastName()));

        System.out.println("\nSort and show Java programmers by salary:");
        sortedJavaProgrammers = javaProgrammers.stream()
                .sorted((p1, p2) -> p1.getSalary() - p2.getSalary())
                .collect(Collectors.toList());
        sortedJavaProgrammers.forEach(javaer -> System.out.printf("%s %s; ", javaer.getFirstName(), javaer.getLastName()));
    }

    private static void minAndMax() {

        Comparator<Person> salaryComparator = ((p1, p2) -> (p1.getSalary() - p2.getSalary()));

        System.out.println("\nGet the lowest Java programmer salary:");
        Person person = javaProgrammers.stream()
                .min(salaryComparator)
                .get();
        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());


        System.out.println("Get the highest Java programmer salary:");

        person = javaProgrammers.stream().max(salaryComparator)
                .get();
        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());
    }

    private static void map() {

        System.out.println("\nGet PHP programmers first name to String:");
        String phpDevelopers = phpProgrammers.stream()
                .map(p -> p.getFirstName())
                .collect(Collectors.joining("; "));
        System.out.println(phpDevelopers);

        System.out.println("\nGet Java programmers first name to Set:");
        Set<String> set = javaProgrammers.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());

        System.out.println("\nGet Java programmers last name to TreeSet:");

        TreeSet<String> treeSet = javaProgrammers.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private static void parallelStream() {
        System.out.println("\nCalculate total money spent for paying Java programmers:");
        long begin = System.currentTimeMillis();
        int sum = javaProgrammers.parallelStream()
                .mapToInt(Person::getSalary)
                .sum();
        long end = System.currentTimeMillis();

        long parallel = end - begin;

        begin = System.currentTimeMillis();
        sum = javaProgrammers.stream().mapToInt(Person::getSalary)
                .sum();
        end = System.currentTimeMillis();

        long serial = end - begin;
        System.out.println("with serial, cost " + serial + " ms, with parallel, cost " + parallel + " ms.");
    }

    private static void obtainVariousSummaryData() {

        //Get count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics intSummaryStatistics = numbers.stream()
                .mapToInt(item -> item)
                .summaryStatistics();

        System.out.println("Highest number in List : " + intSummaryStatistics.getMax());
        System.out.println("Lowest number in List : " + intSummaryStatistics.getMin());
        System.out.println("Sum of all numbers : " + intSummaryStatistics.getSum());
        System.out.println("Average of all numbers : " + intSummaryStatistics.getAverage());

    }
}
