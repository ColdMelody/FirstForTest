package test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Bill on 2016/8/24.
 */
public class MethodTest {
    public static void main(String[] args) {
//        Map<String,Class<?>> map=new HashMap<>();
//        Class<?> c1=Integer.class;
//        Class<?> c2=map.put("0",c1);
//        System.out.println(c2==null || c2.isAssignableFrom(c1));
        try {
            InsertQuery query = new InsertQuery();
            int[] parm = {1, 2, 3, 4, 45, 14, 45};
            Method method = InsertQuery.class.getDeclaredMethod("queryOut", parm.getClass());
            method.invoke(query, (Object) parm);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("0", "1");
        System.out.println(map);
        map.clear();
        System.out.println(map);
    }
}
