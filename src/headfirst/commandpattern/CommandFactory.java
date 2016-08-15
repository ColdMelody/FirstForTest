package headfirst.commandpattern;

import com.sun.xml.internal.txw2.IllegalSignatureException;

/**
 * Created by Bill on 2016/8/15.
 */
public class CommandFactory {
    String command;
    private static Light light;
    private static Stereo stereo;
    private static CeilingFan ceilingFan;

    public CommandFactory() {
    }

    static {
        light = new Light();
        stereo = new Stereo();
        ceilingFan = new CeilingFan();
    }

    public Command getLightCommand(String s) {
        if (s == null) throw new IllegalSignatureException("para can not be null");
        if (s.equals("on"))
            return new LightOnCommand(light);
        else if (s.equals("off"))
            return new LightOffCommand(light);
        else throw new IllegalSignatureException("Illegal para");
    }


    public Stereo getStereo() {
        return stereo;
    }
}
