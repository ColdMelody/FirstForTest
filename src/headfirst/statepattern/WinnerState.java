package headfirst.statepattern;

/**
 * Created by Bill on 2016/8/16.
 */
public class WinnerState implements State {
    GumballMachine gumballMachine;
    public WinnerState(GumballMachine gumballMachine){
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
        System.out.println("YOU ARE A WINNER!");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount()==0)
            gumballMachine.setState(gumballMachine.getSoldOutState());
        else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount()>0)
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            else {
                System.out.println("Oops,out of gumballs");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
