package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Bill on 2016/5/9.
 */
interface Opreate {
    void operateMethod1();

    void operateMethod2();

    void operateMethod3();
}

class OperateImpl implements Opreate {

    @Override
    public void operateMethod1() {
        System.out.println("Invoke operateMethod1");
        sleep(110);
    }

    @Override
    public void operateMethod2() {
        System.out.println("Invoke operateMethod2");
        sleep(120);
    }

    @Override
    public void operateMethod3() {
        System.out.println("Invoke operateMethod3");
        sleep(130);
    }

    private static void sleep(long millSeconds) {
        try {
            Thread.sleep(millSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TimingInvocationHandler implements InvocationHandler {

    private Object target;


    TimingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = method.invoke(target, args);
        System.out.println(method.getName() + " cost time is:" + (System.currentTimeMillis() - start));
        return obj;
    }

}

class Main {
    public static void main(String[] args) {
        // create proxy instance
        TimingInvocationHandler timingInvocationHandler = new TimingInvocationHandler(new OperateImpl());
        Opreate operate = (Opreate) Proxy.newProxyInstance(Opreate.class.getClassLoader(), new Class[]{Opreate.class},
                timingInvocationHandler);

        // call method of proxy instance
        operate.operateMethod1();
        System.out.println();
        operate.operateMethod2();
        System.out.println();
        operate.operateMethod3();
    }
}