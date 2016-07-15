package concurrence;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Bill on 2016/7/14.
 */
public class Consumer implements Runnable{
    BlockingQueue<String> queue=null;
    Consumer(BlockingQueue<String> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
