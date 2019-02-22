package cn.joim.jdk8.lambda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Base1 {

    /**
     * 基本语法：
     * (parameters) -> expression
     * (parameters) ->{ statements; }
     */
    public static void main(String[] args) {

        //1. 遍历.
        forEachBase();


        //2. 匿名类.
        anonymousBase();

        //3. 排序.
        sortBase();

    }

    private static void forEachBase() {

        String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        //jdk8之前
        for (String player : players) {
            System.out.print(player + "; ");
        }
        System.out.println();
        //Lambda
        players.forEach(player -> System.out.print(player + ";"));
        System.out.println();
        //方法引用
        players.forEach(System.out::print);
    }

    private static void anonymousBase() {

        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World!");
            }
        });
        //Lambda
        button.addActionListener((event) -> System.out.println("Hello World!"));
    }

    private static void sortBase() {

        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};


        // 以姓名来排序.
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Arrays.sort(players, (String o1, String o2) -> o1.compareTo(o2));

        //以姓来排序.
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });

        Arrays.sort(players, (String s1, String s2) -> (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" ")))));
    }
}
