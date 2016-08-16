package headfirst;

/**
 * Created by Bill on 2016/8/15.
 */
public class TemplatePattern extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("call primitiveOperation1");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("call primitiveOperation2");
    }

    @Override
    protected boolean hook() {
        return false;
    }
    public static void main(String[] args){
        AbstractClass template=new TemplatePattern();
        template.templateMethod();
    }
}
