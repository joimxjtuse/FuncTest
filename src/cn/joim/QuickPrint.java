package cn.joim;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickPrint {

    /**
     * 面试中提到打印一串"abababab...."这样的字符串，长度为100，
     * 怎么样打印是最快的.
     * <p>
     * 测试了三种情况：串行，双线程互相等待和多线程分治，结果是：
     * 串行是最优的解决方案。我推测面试官想提问的该是：
     * 双线程互相等待怎么设计。
     * <p>
     * 不过，从"最快"的问题，我想到了曾经看过的一本并发编程实践的书籍，
     * 想去通过并发去实现一个功能，一个合理的办法是先实现串行，然后在此基础上
     * 再去优化，这才是个合理的实践步骤，当可以有效的验证到并行确实是可以优于
     * 串行的时候才是值得的，否则就是画蛇添足了。
     */
    public static void main(String[] args) {

        simplePrint();

        realPrint();

        joimPrint();

    }

    private static void simplePrint() {
        long begin = System.nanoTime();

        String AB = "AB";

        for (int i = 0; i < 50; i++) {
            justPrint(AB);
        }
        long end = System.nanoTime();
        System.out.println("\n use simple method, cost : " + (end - begin) + " ns.");

    }

    static final int THREADHOLD = Runtime.getRuntime().availableProcessors();

    static final CountDownLatch joimCountDown = new CountDownLatch(THREADHOLD);

    private static void joimPrint() {
        long begin = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new PrintTask(0, 50));

        try {
            joimCountDown.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        long end = System.nanoTime();

        System.out.println("\njoim print cost : " + (end - begin) + " ns");

    }


    private static class PrintTask extends RecursiveAction {

        int start, end;

        public PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            String AB = "AB";
            if (end - start <= 50 / THREADHOLD) {
                for (int i = start; i < end; i++) {
                    justPrint(AB);
                }
                joimCountDown.countDown();

            } else {
                int middle = (start + end) / 2;
                PrintTask left = new PrintTask(start, middle);
                PrintTask right = new PrintTask(middle, end);
                //并行执行两个“小任务”
                left.fork();
                right.fork();
            }

        }
    }

    static volatile boolean bPrintB = false;

    private static void realPrint() {

        final CountDownLatch countDownLatch = new CountDownLatch(2);

        long beginTime = System.nanoTime();
        Thread printA = new Thread(() -> {

            try {

                int count = 0;
                String A = "A";

                while (count < 50) {
                    if (!bPrintB) {
                        justPrint(A);
                        count++;
                        bPrintB = true;
                    }
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
            countDownLatch.countDown();


        }, "print-A");
        printA.start();

        Thread printB = new Thread(() -> {
            try {
                String B = "B";
                int count = 0;
                while (count < 50) {
                    if (bPrintB) {
                        justPrint(B);
                        count++;
                        bPrintB = false;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            countDownLatch.countDown();


        }, "print-B");
        printB.start();
        try {
            countDownLatch.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("\n total cost : " + (endTime - beginTime) + " ns.");

    }

    private static void justPrint(String str) {

        System.out.print(str);
    }
}
