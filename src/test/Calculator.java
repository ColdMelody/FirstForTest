package test;

/**
 * Created by Bill on 2016/9/5.
 */
public class Calculator {
    @FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);
    }
    @FunctionalInterface
    interface CallBack<T>{
        T call();
    }

    private int operationBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
    private <T> T invoke(CallBack<T> c){
        return c.call();
    }

    public static void main(String... args) {
        Calculator calculator = new Calculator();
        System.out.println("40 + 2 = " + calculator.operationBinary(40, 2, (a, b) -> a + b));
        System.out.println(calculator.invoke(()->"DONE"));
    }
}
