package enumdemo;

import static enumdemo.Enums.random;
/**
 * Created by Bill on 2016/8/26.
 */
public class RandomTest {
    public static void main(String[] args){
        for (int i=0;i<10;i++){
            System.out.println(random(Activity.class)+" ");
        }
    }
}
enum Activity{
    BUTTON,TEXTVIEW,FRAGMENT,EDITTEXT
}
