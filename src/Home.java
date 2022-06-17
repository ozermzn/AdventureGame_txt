public class Home extends SafetyLocation{

    Home(Player player) {
        super(player,"Home");

    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getReHealth());
        System.out.println("Welcome home, you are healed: "+player.getHealth());
        return true;
    }
}
