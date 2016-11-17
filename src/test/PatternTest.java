package test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bill on 2016/9/26.
 */
public class PatternTest {
    private boolean test(String number) {
        Pattern p1 = Pattern.compile("[\\d]{1,3}");
        Pattern p2 = Pattern.compile("0.[\\d]{1,2}");
        Pattern p3 = Pattern.compile("[\\d]{1,2}%");
        Pattern p4 = Pattern.compile("[\\d]{1,3}\\.0");
        Matcher m1 = p1.matcher(number);
        Matcher m2 = p2.matcher(number);
        Matcher m3 = p3.matcher(number);
        Matcher m4 = p4.matcher(number);
        boolean m = m1.matches() || m2.matches() || m3.matches() || m4.matches();
        return m;
    }

    private float get(String number) {
        if (number.equals("")) return 0;
        String n = number.substring(0, number.length() - 1);
        float f = Float.parseFloat(n);
        return f / 100;
    }

    private float getF(String num) {
        NumberFormat format = NumberFormat.getInstance();
        Number n=null;
        try {
            n=format.parse(num);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert n != null;
        return Float.parseFloat(n.toString())/100;
    }

    public static void main(String... args) {
        PatternTest test = new PatternTest();
        System.out.println(test.get("150.5%"));
        System.out.println(test.getF("150%"));
        System.out.println(test.test("11.00"));
        System.out.println(test.test("11."));
        System.out.println(test.test("1110"));
        System.out.println(test.test("11"));
        System.out.println(test.test("1542"));
        System.out.println(test.test("0.11"));
        System.out.println(test.test("0.513"));
        System.out.println(test.test("0.1"));
        System.out.println(test.test("150%"));
        System.out.println(test.test("15%"));
    }
}
