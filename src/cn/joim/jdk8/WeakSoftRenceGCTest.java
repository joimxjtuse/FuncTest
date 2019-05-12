package cn.joim.jdk8;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakSoftRenceGCTest {

    private static ReferenceQueue<Object> rq = new ReferenceQueue<Object>();

    public static void main(String[] args) {
        Object obj = new Object();
        WeakReference<Object> wr = new WeakReference<>(obj, rq);
        System.out.println("before GC, queue state: " + rq.poll() != null);
        System.out.println("before GC, reference state: " + wr.get() != null);
        obj = null;
        Runtime.getRuntime().gc();
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.runFinalization();
//        System.gc();
        System.out.println("after GC,reference state: " + wr.get() != null);//false，这是因为WeakReference被回收
        System.out.println("after GC,queue state: " + rq.poll() != null);
    }
}
