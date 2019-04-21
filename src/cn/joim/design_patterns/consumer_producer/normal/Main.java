package cn.joim.design_patterns.consumer_producer.normal;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * <b>Subscriber vs Publisher</>
 * SubmissionPublisher - Subscriber
 * 1. 生产者和消费者建立一种1对多的订阅关系；
 * 2. 生产者有新的Event生产完毕后，通知（回调）消费者；
 */
public class Main {

    public static void main(String[] args) {
        SubmissionPublisher<Event> publisher = new SubmissionPublisher<>();

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer("Consumer " + i);
            publisher.subscribe(consumer);
        }

        Producer system1 = new Producer(publisher, "System 1");
        Producer system2 = new Producer(publisher, "System 2");

        ForkJoinTask task1 = ForkJoinPool.commonPool().submit(system1);
        ForkJoinTask task2 = ForkJoinPool.commonPool().submit(system2);

        do {
            System.out.println("-------------------------");
            System.out.println("Main task1:" + task1.isDone());
            System.out.println("Main task2:" + task1.isDone());


            System.out.println("Publisher: MaximumLag: " + publisher.estimateMaximumLag());
            System.out.println("Publisher: Max Buffer Capacity: " + publisher.getMaxBufferCapacity());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception ex) {

            }
        } while (!task1.isDone() || !task2.isDone() ||
                publisher.estimateMaximumLag() > 0
        );
    }
}
