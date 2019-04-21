package cn.joim.design_patterns.consumer_producer.normal;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    SubmissionPublisher publisher;
    String name;

    public Producer(SubmissionPublisher publisher, String name) {
        this.publisher = publisher;
        this.name = name;
    }

    @Override
    public void run() {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            publisher.submit(new Event(
                    "Event NO. : " + i,
                    name,
                    new Date()
            ));

            int number = random.nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(number);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
