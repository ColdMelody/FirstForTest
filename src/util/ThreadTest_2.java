package util;

/**
 * Created by Administrator on 2016/4/21.
 *
 */
public class ThreadTest_2 extends Thread{
    private String name;
    private final Object prev;
    private final Object self;


    public ThreadTest_2(String name,Object prev,Object self){
        this.name=name;
        this.prev=prev;
        this.self=self;
    }
    @Override
    public void run(){
        int count=10;
        while (count>0){
            synchronized (prev){

                synchronized (self){

                    System.out.println(name);
                    count--;
                    self.notify();

                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Object A=new Object();
        Object B=new Object();
        Object C=new Object();
        ThreadTest_2 th1=new ThreadTest_2("A",C,A);
        ThreadTest_2 th2=new ThreadTest_2("B",A,B);
        ThreadTest_2 th3=new ThreadTest_2("C",B,C);
        th1.start();
        Thread.sleep(100);
        th2.start();
        Thread.sleep(100);
        th3.start();
        Thread.sleep(100);
    }
}
