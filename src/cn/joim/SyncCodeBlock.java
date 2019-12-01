package cn.joim;

import java.util.concurrent.TimeUnit;

public class SyncCodeBlock {

    public int i;

    public void syncTask() {
        //同步代码库
        synchronized (this) {
            i++;
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(runnable);
        t.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception exce) {
            //exce.printStackTrace();
        }
        t.interrupt();
        System.out.println("thread state: " + t.isInterrupted());

    }

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
//                Thread.sleep(3000);
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("continue handle");
                }
                System.out.println("thread isInterrupted: " + Thread.currentThread().isInterrupted());
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("thread exception occurs.");
            }
            System.out.println("thread complete.");

        }
    };
}
