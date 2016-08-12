package util;

/**
 * Created by Bill on 2016/4/25.
 * 参数很多的时候，最好用Builder Pattern
 */
public class BuilderTest {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private static class Builder{
        private final int servingSize;
        private final int servings;

        private int calories=0;
        private int fat=0;
        private int sodium=0;
        private int carbohydrate=0;
        Builder(int servingSize, int servings){
            this.servingSize=servingSize;
            this.servings=servings;
        }

        Builder setCalories(int val){
            calories=val;
            return this;
        }
        Builder setFat(int val){
            fat=val;
            return this;
        }
        Builder setSodium(int val){
            sodium=val;
            return this;
        }
        Builder setCarbohydrate(int val){
            carbohydrate=val;
            return this;
        }
        BuilderTest build(){
            return new BuilderTest(this);
        }
    }
    private BuilderTest(Builder builder){
        servingSize=builder.servingSize;
        servings=builder.servings;
        calories=builder.calories;
        fat=builder.fat;
        sodium=builder.sodium;
        carbohydrate=builder.carbohydrate;
    }
    public String toString(){
        return "servingSize "+servingSize+" servings "+servings+" calories "+calories+" fat "+fat+" sodium "+sodium+" carbohydrate "+carbohydrate;
    }
    public static void main(String[] args){
        BuilderTest builderTest=new BuilderTest.Builder(10,12).setCalories(1).setCarbohydrate(10).setFat(78).setSodium(45).build();
        System.out.print(builderTest.toString());
    }
}
