package effectivejava;

/**
 * Created by Bill on 2016/6/15.
 */
public class BoxMakeSlowProgram {
    public static void main(String[] args){
        long sum=0;
        for (long i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}
