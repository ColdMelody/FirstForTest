package concurrence;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Bill on 2016/7/15.
 */
public class CyclicBarrierRunnable implements Runnable {

    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier1");
            barrier1.await();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier2");
            barrier2.await();
            System.out.println(Thread.currentThread().getName() + " done!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
