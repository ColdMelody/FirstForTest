package headfirst.commandpattern;

/**
 * Created by Bill on 2016/8/15.
 */
public class StereoOnCommand implements Command {
    private Stereo stereo;
    StereoOnCommand(Stereo stereo){
        this.stereo=stereo;
    }
    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
