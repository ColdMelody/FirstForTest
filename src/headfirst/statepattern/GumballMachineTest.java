package headfirst.statepattern;

/**
 * Created by Bill on 2016/8/16.
 */
public class GumballMachineTest {
    public static void main(String[] args){
        GumballMachine gumballMachine=new GumballMachine(5);
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }
}
