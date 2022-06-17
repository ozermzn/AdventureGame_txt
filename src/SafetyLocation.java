public class SafetyLocation extends Location{
    SafetyLocation(Player player,String name) {
        super(player);
        this.name=name;


    }



    public boolean getLocation(){
        return true;
    }

}
