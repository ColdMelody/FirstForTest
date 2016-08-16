package headfirst;

/**
 * Created by Bill on 2016/8/15.
 * <p>模板模式的代码样板，当然，很多地方的模板和这个样板不一样，这里只是示例。
 * <p>模板是使用继承来使用，所以用抽象类，和策略不同，策略使用的是组合。
 * <p>工厂模式是模板的一个特殊版本。
 * <p>还有一个很有意思的是模板中的钩子，一个模板中可能有很多钩子。
 */
abstract class AbstractClass {
    //这个是算法的流程，子类时没办法修改的
    final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        if (hook())
            concreteOperation();
    }

    //这两个是算法的实现，有子类自己去实现
    protected abstract void primitiveOperation1();

    protected abstract void primitiveOperation2();

    //算法流程的一部分，子类时没办法修改的
    private void concreteOperation() {
        System.out.println("call concreteOperation");
    }

    //这是一个钩子，用于子类向超类插入代码，或者控制超类中算法的流程
    protected boolean hook() {
        return true;
    }
}
