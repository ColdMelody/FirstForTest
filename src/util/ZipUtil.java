package util;



import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bill on 2016/6/24.
 */
public class ZipUtil {
    public static void main(String[] args){
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);
        list.forEach(System.out::println);
        Consumer<String> stringConsumer = System.out::println;
    }
}
