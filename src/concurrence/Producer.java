package concurrence;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Bill on 2016/7/14.
 */
public class Producer implements Runnable {

    BlockingQueue<String> queue=null;
    Producer(BlockingQueue<String> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(2000);
            queue.put("2");
            Thread.sleep(2000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
