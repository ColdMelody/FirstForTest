package headfirst.statepattern;

/**
 * Created by Bill on 2016/8/16.
 */
public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
