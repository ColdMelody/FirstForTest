package headfirst.commandpattern;


/**
 * Created by Bill on 2016/8/15.
 */
public class Client {
    public static void main(String[] args){
        RemoteControl remoteControl=RemoteControl.getInstance();
        Light light=new Light();
        Stereo stereo=new Stereo();
        CeilingFan ceilingFan=new CeilingFan();
        LightOnCommand lightOnCommand=new LightOnCommand(light);
        LightOffCommand lightOffCommand=new LightOffCommand(light);
        StereoOnCommand stereoOnCommand=new StereoOnCommand(stereo);
        StereoOffCommand stereoOffCommand=new StereoOffCommand(stereo);
        CeilingFanLowCommand ceilingFanLowCommand=new CeilingFanLowCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand=new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHighCommand=new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand=new CeilingFanOffCommand(ceilingFan);
        remoteControl.setCommand(0,lightOnCommand,lightOffCommand);
        remoteControl.setCommand(1,stereoOnCommand,stereoOffCommand);
        remoteControl.setCommand(2,ceilingFanHighCommand,ceilingFanOffCommand);
        remoteControl.setCommand(3,ceilingFanMediumCommand,ceilingFanOffCommand);
        remoteControl.setCommand(4,ceilingFanLowCommand,ceilingFanOffCommand);
        remoteControl.onButtonPushed(0);
        remoteControl.offButtonPushed(0);
    }
}
