package headfirst.commandpattern;

/**
 * Created by Bill on 2016/8/15.
 */
public class LightOffCommand implements Command{
    private Light light;
    LightOffCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
