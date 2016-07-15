package concurrence;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Bill on 2016/7/15.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();
        Thread.sleep(4000);
    }
}
