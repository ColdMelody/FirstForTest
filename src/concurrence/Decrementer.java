package concurrence;

import java.util.concurrent.CountDownLatch;


/**
 * Created by Bill on 2016/7/15.
 */
public class Decrementer implements Runnable{
    CountDownLatch latch=null;
    Decrementer(CountDownLatch latch){
        this.latch=latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            latch.countDown();
            Thread.sleep(1000);
            latch.countDown();
            Thread.sleep(1000);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
