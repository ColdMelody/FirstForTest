package headfirst.commandpattern;


/**
 * Created by Bill on 2016/8/15.
 */
public class CeilingFan {
    public enum Status{
        OFF,
        LOW,
        MEDIUM,
        HIGH
    }
    Status status;
//    String location;
    public CeilingFan(){
//        this.location=location;
        status=Status.OFF;
    }
    public void high(){
        status=Status.HIGH;
    }
    public void medium(){
        status=Status.MEDIUM;
    }
    public void low(){
        status=Status.LOW;
    }
    public void off(){
        status=Status.OFF;
    }
    public Status getSpeed(){
        return status;
    }
}
