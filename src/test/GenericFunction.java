package test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bill on 2016/10/19.
 * 一个递归泛型参数和通配符来对泛型参数做出限制
 * 一般递归泛型参数用于Comparable和Comparator
 */
public class GenericFunction {
    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }
    public static void main(String...args){
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<Integer> list=new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add(i);
        }
        int result=max(list);
        System.out.println(result);
    }
}
