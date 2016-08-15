package headfirst;

/**
 * Created by Bill on 2016/8/15.
 */
public class SingleInstancePattern {
    public static SingleInstancePattern pattern;
    private SingleInstancePattern(){}
    // first
    public synchronized static SingleInstancePattern getPattern(){
        if (pattern==null){
            return new SingleInstancePattern();
        }
        return pattern;
    }
    // second
//    public static SingleInstancePattern pattern=new SingleInstancePattern();
//    public SingleInstancePattern getInstance(){
//        return pattern;
//    }
    // third
//    public volatile static SingleInstancePattern pattern;
//    public static SingleInstancePattern getInstance(){
//        if (pattern==null){
//            synchronized (SingleInstancePattern.class){
//                if (pattern==null){
//                    return new SingleInstancePattern();
//                }
//            }
//        }
//        return pattern;
//    }
}

