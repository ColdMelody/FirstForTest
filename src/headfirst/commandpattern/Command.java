package headfirst.commandpattern;

/**
 * Created by Bill on 2016/8/15.
 */
public interface Command {
    void execute();
    void undo();
}
