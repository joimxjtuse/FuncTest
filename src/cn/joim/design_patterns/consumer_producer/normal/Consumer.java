package cn.joim.design_patterns.consumer_producer.normal;

import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;

public class Consumer implements Flow.Subscriber<Event> {

    String name;
    Flow.Subscription subscription;

    public Consumer(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(Event item) {

        showMessage("An event has arrived: " +
                item.getName() +
                " : " + item.getCreateDate() +
                " : " + item.getMessage());
        // request next event.
        subscription.request(1);
        processEvent(item);
    }

    private void processEvent(Event event) {
        int number = new Random().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable throwable) {

        showMessage("An error has occurred");
    }

    @Override
    public void onComplete() {

        showMessage("No more events.");
    }

    private void showMessage(String message) {
        System.out.println(message);
    }
}
