package effectivejava;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by Bill on 2016/6/15.
 */
public class ComparatorBox {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : (o1.equals(o2) ? 0 : 1);
            }
        };
        System.out.println(comparator.compare(42, 42));
    }
}
