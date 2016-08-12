package util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by Bill on 2016/8/4.
 */
public class ReferenceDemo {
    public static void main(String[] args){
        ReferenceQueue<Big> queue=new ReferenceQueue<>();
        WeakReference<Big> weak=new WeakReference<>(new Big(),queue);
        System.out.println(weak.get());
        System.gc();
        System.out.println(weak.get());
    }
}
class Big{
    private static int count=0;
    private final int id=count++;
    Big(){
    }

    @Override
    public String toString() {
        return "id "+id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize "+id);
    }
}
