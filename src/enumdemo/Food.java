package enumdemo;

/**
 * Created by Bill on 2016/8/26.
 * enum无法继承，所以定义接口来实现枚举的分组
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD,SOUP,SPRING_ROLLS
    }
    enum MainCourse implements Food{
        LASAGBE,BUURRITO,PAD_THAI
    }
    enum Dessert implements Food{
        TIRAMISU,GELATO,FRULT
    }
    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,LATIE,TEA
    }
}
