package enumdemo;


/**
 * Created by Bill on 2016/8/26.
 * 枚举的枚举
 */
public enum  Course {
    APPETIER(Food.Appetizer.class),
    DESSERT(Food.Dessert.class),
    MAINCOURSE(Food.MainCourse.class),
    COFFEE(Food.Coffee.class);
    private Food[] foods;
    private Course(Class<? extends Food> kind){
        foods=kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(foods);
    }

}
