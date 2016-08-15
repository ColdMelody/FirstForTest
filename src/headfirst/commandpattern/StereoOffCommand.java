package headfirst.commandpattern;

/**
 * Created by Bill on 2016/8/15.
 */
public class StereoOffCommand implements Command {
    Stereo stereo;
    StereoOffCommand(Stereo stereo){
        this.stereo=stereo;
    }
    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(10);
    }
}
