package cn.joim.jdk8.stream;


import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Anagrams {

    public static void main(String[] args) throws IOException {

        // print all large anagram groups in adictionary iteratively.
        print1(args);

        print2(args);
    }

    private static void print1(String[] args) throws IOException {

        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        groups.values().forEach(group -> {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
            }
        });
    }

    static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    private static void print2(String[] args) throws IOException {

//        Path dictionary = Paths.get(args[0]);
//        int minGroupSize = Integer.parseInt(args[1]);
//
//        try (Stream<String> words = Files.lines(dictionary)) {
//            words.collect(
//                    groupingBy(word -> alphabetize(word)))
//                    .values().stream()
//                    .filter(group -> group.size() >= minGroupSize)
//                    .forEach(g -> System.out.println(g.size() + ": " + g));
//        }
    }

//    private static Collector groupingBy(String word) {
//        return null;
//    }
}
