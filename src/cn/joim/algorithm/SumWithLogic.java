package cn.joim.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试被问了一个很基础的算法题，逻辑运算实现加减法；
 * 想了半天没有想出来，回去整理了下，复习下：
 * a + b = a^b
 * <p>
 * a - b = (a^b) << 1
 */
public class SumWithLogic {


    /**
     * a + b  = (a^b) + (a&b) << 1
     * a = 10, b = 9
     * a^b : 3
     * 1010
     * ^ 1001
     * --------
     * 0011
     * a&b : 8
     * 1010
     * & 1001
     * --------
     * 1000
     * (a&b)<< 1 = 10000 = 16
     */
    private static int sum(int a, int b) {
        if (b == 0) {
            return a;
        } else if (a == 0) {
            return b;
        }
        return sum(a ^ b, (a & b) << 1);
    }

    private static int minus(int a, int b) {
        return sum(a, -b);
    }

    public static void main(String[] args) {

        int i = 0;
        List<Long> listMath = new LinkedList<>();
        List<Long> listLogic = new LinkedList<>();

        while (i < 2000) {

            int a = 10;
            int b = 9;
            //不使用第三个变量实现a与b的交换.
            long beginTime = System.nanoTime();
            a = a - b;//1
            b = b + a; // 10
            a = b - a;
            long endTime = System.nanoTime();
            System.out.println("with math, a = " + a + " ; b = " + b + " ; cost : " + (endTime - beginTime));
            listMath.add((endTime - beginTime));

            a = 10;
            b = 9;
            beginTime = System.nanoTime();
            a = minus(a, b);
            b = sum(b, a);
            a = minus(b, a);
            endTime = System.nanoTime();
            System.out.println("with logic, a = " + a + " ; b = " + b + " ; cost : " + (endTime - beginTime));
            listLogic.add((endTime - beginTime));
            i++;
        }

        System.out.println("with math sum , average time :" + calcAvrage(listMath)
                + " ; with logic sum, average time : " + calcAvrage(listLogic));
    }

    private static long calcAvrage(List<Long> list) {
        return (long) (list.stream().mapToLong((item) -> item).summaryStatistics().getAverage());
    }
}
