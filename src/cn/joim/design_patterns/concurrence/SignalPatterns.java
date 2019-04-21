package cn.joim.design_patterns.concurrence;

/**
 * 信号模式：
 * 实现了某一任务向另一任务通告某一事件的情形。
 * <p>
 * 实现这种模式最简单的方式是采用信号量或者互斥，使用Java语言的ReentranceLock类或者
 * Semaphore类即可。
 */
public class SignalPatterns {

    public static void main(String[] args) {
        trySignalPatterns();
    }

    private static void trySignalPatterns() {

        try {
            task1();

            Thread.sleep(3000);
            task2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Object objLock = new Object();

    private static void task1() {


        Thread t = new Thread(() -> {
            synchronized (objLock) {
                try {
                    objLock.wait();
                    System.out.println("handle t1");
                } catch (Exception exce) {
                    exce.printStackTrace();
                }
            }
        });
        t.start();
    }

    private static void task2() {
        Thread t = new Thread(() -> {
            synchronized (objLock) {
                synchronized (objLock) {
                    System.out.println("handle t2");
                    objLock.notify();
                }
            }
        });
        t.start();
    }
}
