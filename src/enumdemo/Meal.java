package enumdemo;

/**
 * Created by Bill on 2016/8/26.
 */
public class Meal {
    public static void main(String[] args){
        for (int i=0;i<5;i++){
            for (Course c:Course.values()){
                Food f=c.randomSelection();
                System.out.println(f);
            }
            System.out.println("----");
        }
    }
}
