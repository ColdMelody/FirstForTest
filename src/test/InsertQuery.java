package test;

import java.util.Arrays;

/**
 * Created by Bill on 2016/7/25.
 */
public class InsertQuery {

    private static void query(int[] ts) {
        if (ts.length <= 2) {
            throw new UnsupportedOperationException();
        }
        for (int j = 1; j < ts.length; j++) {
            int key = ts[j];
            int position = j;
            for (int i = j - 1; i >= 0; i--) {
                if (ts[i] > key) {
                    ts[i + 1] = ts[i];
                    position -= 1;
                } else break;
            }
            ts[position] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 76, 3, 587, -42, 45, 372, -12};
        System.out.println(Arrays.toString(array));
        query(array);
        System.out.println(Arrays.toString(array));
    }
}
