package test;

/**
 * Created by Bill on 2016/8/2.
 */
public enum  NetworkEnum {
    NO_CACHE(1),
    NO_STROKE(1<<1),
    OFFLINE(1<<2);
    final int index;
    NetworkEnum(int index){
        this.index=index;
    }
    public static void main(String[] args){
        System.out.println(NO_CACHE.index);
        System.out.println(NO_STROKE.index);
        System.out.println(OFFLINE.index);
    }
}
