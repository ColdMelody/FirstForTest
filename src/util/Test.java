package util;

public class Test {
    public static void main(String... args) {
        Thread t = new Thread(() -> {
            System.out.println("Thread is run");
        });
        t.start();
        System.out.println(System.getProperty("java.vm.version"));
    }
}

