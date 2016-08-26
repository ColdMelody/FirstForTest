package enumdemo;

/**
 * Created by Bill on 2016/8/26.
 * enum中的每一个值都是自身的一个实例
 */
public enum OzWitch {
    WEST("west"),
    NORTH("north"),
    EAST("east"),
    SOUTH("south");
    private String description;
    public String getDescription(){
        return description;
    }
    OzWitch(String description){
        this.description=description;
    }
    public static void main(String[] args){
        for (OzWitch witch:OzWitch.values()){
            System.out.println(witch+": "+witch.getDescription()+witch.ordinal());
        }
    }
}
