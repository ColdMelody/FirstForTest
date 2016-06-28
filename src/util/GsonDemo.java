package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */
public class GsonDemo {
    private Gson gson = new Gson();
    private List list = new ArrayList<Person>();

    public void toGson() {
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName("dog" + i);
            p.setAge(i * 5);
            list.add(p);
        }
//        util.Person p=new util.Person();
//        p.setName("bill");
//        p.setAge(24);
//        System.out.println(p.toString());
        String str = gson.toJson(list);
        System.out.println(str);
        List<Person> lists = gson.fromJson(str, new TypeToken<List<Person>>() {
        }.getType());
        for (Person pp : lists) {
            System.out.println(pp.toString());
        }
//        util.Person pp=gson.fromJson(str,util.Person.class);
//        System.out.println(pp.toString());
    }

    public static void main(String[] args) {
        GsonDemo gs = new GsonDemo();
        gs.toGson();
    }

}
