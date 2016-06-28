package util;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/13.
 *
 */
class Person implements Serializable{
    private String name;
    private int age;
    Person(){}

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return name + ":" + age;
    }
}
