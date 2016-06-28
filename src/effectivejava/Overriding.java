package effectivejava;

/**
 * Created by Bill on 2016/6/14.
 */
public class Overriding {
    public static void main(String[] args){
        Wine[] wines={new Wine(),new SparklingWine(),new Champange()};
        for (Wine wine:wines){
            System.out.println(wine.name());
        }
    }
}
class Wine{
    String name(){
        return "wine";
    }
}
class SparklingWine extends Wine{
    @Override
    String name(){
        return "sparkling wine";
    }
}
class  Champange extends SparklingWine{
    @Override
    String name() {
        return "Champange";
    }
}
