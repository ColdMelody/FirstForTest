package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bill on 2016/9/6.
 */
public class OuterClass {
//    int a=0;
//    OuterClass(){
//        StaticNestedClass.b++;
//    }
//    void test(){
//        a=StaticNestedClass.b;
//        System.out.println(a);
//    }
//    static class StaticNestedClass{
//        static int b=10;
//    }
//    class InnerClass{
//        int c=StaticNestedClass.b;
//    }
    public static void main(String... args){
//        OuterClass outer=new OuterClass();
//        outer.test();
        Map<String,String> map=new HashMap<>();
        map.put("1","10");
        map.put("2","14");
        map.put("2","sd");
        System.out.println(map);
        map.clear();
        System.out.println(map);
        map.put("3","asd");
        System.out.println(map);
        System.out.println(50*1024*1024);
        System.out.println(50<<20);
        OuterClass o=new OuterClass();
        System.out.println(o.getClass().getSimpleName());
    }
}
