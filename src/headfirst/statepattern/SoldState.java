package headfirst.statepattern;

/**
 * Created by Bill on 2016/8/16.
 */
public class SoldState implements State {
    private GumballMachine gumballMachine;
    SoldState(GumballMachine gumballMachine){
        this.gumballMachine=gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println();
    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount()>0)
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        else{
            System.out.println("Oops,out of gumballs");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
