package test;

/**
 * Created by Bill on 2016/8/24.
 */
public abstract class AbstractSuperClass implements TestInterface {
    public String set(){
        init();
        mMethod();
        setResult();
        return null;
    }
    abstract void mMethod();
    private void init(){}
    private void setResult(){}
}
