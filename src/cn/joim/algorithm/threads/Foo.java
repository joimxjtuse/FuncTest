package cn.joim.algorithm.threads;


/**
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Foo {

    public Foo() {

    }


    private Object objLock2 = new Object();

    private Object obbLock3 = new Object();

    private int nCount = 1;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        nCount = 2;
        synchronized (objLock2) {
            objLock2.notifyAll();
        }


    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (nCount != 2) {
            synchronized (objLock2) {
                objLock2.wait();
            }

        }
        printSecond.run();
        nCount = 3;
        synchronized (obbLock3) {
            obbLock3.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (nCount != 3) {
            synchronized (obbLock3) {
                obbLock3.wait();
            }

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
