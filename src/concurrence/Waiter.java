package concurrence;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Bill on 2016/7/15.
 */
public class Waiter implements Runnable{
    CountDownLatch latch=null;
    Waiter(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter Released");
    }
}
