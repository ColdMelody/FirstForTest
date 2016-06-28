package util;

/**
 * Created by Administrator on 2016/4/21.
 */
public class ThreadTest extends Thread{
    private String name;


    public ThreadTest(String name){
        this.name=name;
    }
    @Override
    public void run(){
        System.out.println(name+" Runable");
        for (int i=0;i<5;i++){
            System.out.println(name+" Running");
//            System.out.println(name+": "+i);
            try {
                Thread.sleep((long) (Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" Running");
        ThreadTest th1=new ThreadTest("A");
        ThreadTest th2=new ThreadTest("B");
        th1.setPriority(Thread.MAX_PRIORITY);
        th2.setPriority(Thread.MIN_PRIORITY);
        th1.start();
        th2.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end");
//        new Thread(th,"A").setPriority(Thread.MAX_PRIORITY).start();
//        new Thread(th,"B").start();
//        new Thread(th,"C").start();
    }

}
