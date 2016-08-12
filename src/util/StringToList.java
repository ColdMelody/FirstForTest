package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bill on 2016/8/2.
 */
public class StringToList {
    private List<String> getStrList(String str) {
        return new ArrayList<>(Arrays.asList(str.split("\\("+"or"+"\\)")));
    }

    public static void main(String[] args) {
        StringToList get = new StringToList();
        List<String> list = get.getStrList("字符串");
        System.out.println(list);
    }
}
