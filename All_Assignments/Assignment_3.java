import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

// A custom subscriber class that requests one item at a time.
class MySubscriber<T> implements Flow.Subscriber<T> {
    private Flow.Subscription subscription;
    private final String name;

    public MySubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println(name + ": Subscribed. Requesting the first item.");
        subscription.request(1); // Request the first item
    }

    @Override
    public void onNext(T item) {
        System.out.println(name + ": Received item -> " + item);
        subscription.request(1); // Request the next item
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + ": Error occurred -> " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + ": All items received. Completed.");
    }
}

public class PublisherSubscriberDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("JAYA SURYA S");
        System.out.println("2117240070126");
        System.out.println("----------------");
        System.out.println("Starting Publisher/Subscriber demo...");

        // 1. Create a Publisher using SubmissionPublisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // 2. Create one or more Subscribers
        MySubscriber<String> subscriber1 = new MySubscriber<>("Subscriber-1");
        MySubscriber<String> subscriber2 = new MySubscriber<>("Subscriber-2");

        // 3. Register the subscribers with the publisher
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        System.out.println("Subscribers are now registered.");

        // 4. Publish items
        String[] items = {"Java", "Python", "C++", "JavaScript", "Go"};
        for (String item : items) {
            System.out.println("Publisher submitting: " + item);
            publisher.submit(item);
            TimeUnit.MILLISECONDS.sleep(100); // Wait briefly to observe the flow
        }

        // 5. Close the publisher to signal completion
        publisher.close();

        // Wait for subscribers to finish processing
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Demo finished.");
    }
}
