package effectivejava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Bill on 2016/8/11.
 */
public class RunTests {
    public static void main(String[] args) throws Exception{
        int tests=0;
        int passed=0;
        Class testClass=Class.forName("Sample");
        for (Method m:testClass.getDeclaredMethods()){
            if (m.isAnnotationPresent(Test.class)){
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                }catch (InvocationTargetException wrappedExc){
                    Throwable exc=wrappedExc.getCause();
                    System.out.println(m+" failed: "+exc);
                }catch (Exception exc){
                    System.out.println("INVALID @Test: "+m);
                }

            }
        }
        System.out.printf("Passed: %d,Failed: %d%n",passed,tests-passed);
    }
}
