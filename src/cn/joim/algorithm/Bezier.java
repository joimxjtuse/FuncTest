package cn.joim.algorithm;

/**
 * B(t) = C(n,i) Pi (1 - t)^(n - i) (t)^(i), t = [0, 1];
 * <p>
 * n是阶数，一阶的时候是线性方程，阶数是 确定点的个数- 1.
 * <p>
 * i是表示所有点的序列索引，即P0, P1, P2,...;
 * <p>
 * P标识点的坐标(x, y);
 * <p>
 * t表示时间变量，并且介于0， 1 之间，可以等于0 和1;
 * <p>
 */
public class Bezier {

    private static class Point {

        double x;
        double y;
    }

    private static void bezier(Point[] pointArrs, double t) {

        int i, n = pointArrs.length - 1;
        double x = 0.0, y = 0.0;
        for (i = 0; i < n; i++) {
            x += fn(pointArrs[i].x, n, i, t);

            y += fn(pointArrs[i].y, n, i, t);

        }
        System.out.println(" x = " + x + " ; y = " + y);

    }

    private static double fn(double p, int n, int i, double t) {

        return arrangement(n, i) * p * Math.pow(1 - t, n - i) * Math.pow(t, i);

    }

    private static int arrangement(int n, int i) {

        return factorial(n) / (factorial(n - i) * factorial(i));
    }

    private static int factorial(int n) {
        if (n >= Integer.MAX_VALUE || n <= 0) {
            return 1;
        }
        int s = 1;
        while (n != 0) {
            s *= n--;
        }
        return s;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        Point[] pointArrs = new Point[10];
        Point tmpPoint = null;
        for (int i = 0; i < pointArrs.length; i++) {

            tmpPoint = new Point();
            tmpPoint.x = 1 + (Math.random() * 100);
            tmpPoint.y = 1 + (Math.random() * 100);
            pointArrs[i] = tmpPoint;
        }
        for (double t = 0; t < 1.0; t += 0.001) {

            bezier(pointArrs, t);
        }

        final Thread t3 = new Thread(() -> {
            try {
//                System.out.println("start t2");
//                Thread.currentThread().join(6000);
//                System.out.println("name : t2");

                long beginTime = System.currentTimeMillis();
                System.out.println("start : t3");
                Thread.sleep(1000);
                long endTime = System.currentTimeMillis();
                System.out.println("end : t3, cost : " + (endTime - beginTime));
            } catch (Exception ex) {

            }
        }, "t3");

        final Thread t1 = new Thread(() -> {

//            a();
            try {
                System.out.println("start t1");

                t3.join(3000);
                System.out.println("end : t1");
//            Thread.sleep(2000);
            } catch (Exception ex) {

            }


        }, "t1");

        final Thread t2 = new Thread(() -> {
            try {
                System.out.println("start t2");
                t3.join(6000);
                System.out.println("end : t2");

//            Thread.sleep(2000);
            } catch (Exception ex) {

            }
        }, "t2");

        t3.start();
        t1.start();
        t2.start();

    }

    static Object objLock = new Object();

    private static void a() {

        synchronized (objLock) {
            try {
                System.out.println("thread before :" + Thread.currentThread().getName());
                for (int i = 0; i < 10000000; i++) {

                }
//                a();
                objLock.wait(getWaitTime(Thread.currentThread().getName()));
                System.out.println("thread after :" + Thread.currentThread().getName());
            } catch (Exception ex) {

            }

        }

    }

    private static int getWaitTime(String tname) {
        return tname.equals("t1") ? 5000 : 3500;
    }

}
