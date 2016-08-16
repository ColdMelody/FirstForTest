package headfirst.statepattern;

/**
 * Created by Bill on 2016/8/16.
 */
public class SoldOutState implements State{
    private GumballMachine gumballMachine;
    SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine=gumballMachine;
    }
    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
