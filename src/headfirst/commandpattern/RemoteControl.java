package headfirst.commandpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 2016/8/15.
 */
public class RemoteControl {
    private List<Command> ons;
    private List<Command> offs;
    private Command undoCommand;
    private volatile static RemoteControl control;
    private RemoteControl(){
        ons=new ArrayList<>();
        offs=new ArrayList<>();
        Command noCommand=new NoCommand();
        for (int i=0;i<10;i++){
            ons.add(i,noCommand);
            offs.add(i,noCommand);
        }
        undoCommand=noCommand;
    }
    public static RemoteControl getInstance(){
        if (control==null){
            synchronized (RemoteControl.class){
                if (control==null){
                    return new RemoteControl();
                }
            }
        }
        return control;
    }
    void setCommand(int index, Command onCommand, Command offCommand){
        ons.set(index,onCommand);
        offs.set(index,offCommand);
    }
    public void onButtonPushed(int index){
        ons.get(index).execute();
        undoCommand=ons.get(index);
    }
    public void offButtonPushed(int index){
        offs.get(index).execute();
        undoCommand=offs.get(index);
    }
    public void undoButtonPushed(){
        undoCommand.undo();
    }
    public void removeCommand(int index){
        ons.remove(index);
        offs.remove(index);
    }
}
