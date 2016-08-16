package headfirst.statepattern;


/**
 * Created by Bill on 2016/8/16.
 */
public class GumballMachine{
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State winnerState;
    private State state=soldOutState;
    private int count =0;
    public GumballMachine(int numberGumballs){
        soldOutState=new SoldOutState(this);
        noQuarterState=new NoQuarterState(this);
        hasQuarterState=new HasQuarterState(this);
        soldState=new SoldState(this);
        winnerState=new WinnerState(this);
        this.count=numberGumballs;
        if (numberGumballs>0)
            state=noQuarterState;
    }
    void insertQuarter(){
        state.insertQuarter();
    }
    void ejectQuarter(){
        state.ejectQuarter();
    }
    void turnCrank(){
        state.turnCrank();
        state.dispense();
    }
    void setState(State state){
        this.state=state;
    }
    void releaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if (count!=0){
            count=count-1;
        }
    }
    State getSoldOutState(){
        return soldOutState;
    }
    State getSoldState(){
        return soldState;
    }
    State getNoQuarterState(){
        return noQuarterState;
    }
    State getHasQuarterState(){
        return hasQuarterState;
    }
    State getWinnerState(){
        return winnerState;
    }
    State getState(){
        return state;
    }
    int getCount(){
        return count;
    }

    @Override
    public String toString() {
        return "There is "+count+" gumballs left";
    }
}
