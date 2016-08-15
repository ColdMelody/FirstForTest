package headfirst.commandpattern;

/**
 * Created by Bill on 2016/8/15.
 */
public class CeilingFanLowCommand implements Command {
    private CeilingFan ceilingFan;
    private CeilingFan.Status status;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        status = ceilingFan.getSpeed();
        ceilingFan.low();
    }

    @Override
    public void undo() {
        switch (status) {
            case HIGH:
                ceilingFan.high();
                break;
            case MEDIUM:
                ceilingFan.medium();
                break;
            case LOW:
                ceilingFan.low();
                break;
            case OFF:
                ceilingFan.off();
                break;
            default:
                break;
        }
    }
}
