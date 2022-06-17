import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int reHealth;
    private int money;
    private String name;
    private String characterName;
    private Inventory inventory;


    public Player (String name){
        this.name=name;
        this.inventory = new Inventory();

    }
    Scanner scanner = new Scanner(System.in);

    public void selectCharacter(){

        int chaMenu = characterMenu();
        switch(chaMenu){

            case 1:
                initPlayer("Samurai",10,30,15);
                break;

            case 2:
                initPlayer("Archer",16,20,20);
                break;

            case 3:
                initPlayer("Knight",13,25,5);
                break;

            case 4:
                initPlayer("Ninja",20,18,10);
                break;

            default:
                initPlayer("Samurai",10,30,15);
                break;
        }
        System.out.println("Your Character >>> "+getCharacterName()+"\tDamage:"+getDamage()+"\tHealth:"+getHealth()+"\tMoney:"+getMoney());

        System.out.println("Good luck warrior! Because you will need...");


    }

    public int characterMenu(){

        System.out.println("Choose your warrior: ");
        System.out.println("1)Samurai: \tDamage=10\tHealth=30\tMoney=15");
        System.out.println("2)Archer:  \tDamage=16\tHealth=20\tMoney=20");
        System.out.println("3)Knight:  \tDamage=13\tHealth=24\tMoney=5");
        System.out.println("4)Ninja:   \tDamage=20\tHealth=18  \tMoney=10");
        int characterID = scanner.nextInt();
        while(characterID <1 || characterID >4 ){
            System.out.println("Please choose anyone.");
            characterID = scanner.nextInt();
        }

        return characterID;
    }

    public void initPlayer(String characterName,int damage,int health,int money){
        setCharacterName(characterName);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setReHealth(health);

    }
    public int getTotalDamage(){
        return this.getDamage()+this.getInventory().getDamage();
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getReHealth() {
        return reHealth;
    }

    public void setReHealth(int reHealth) {
        this.reHealth = reHealth;
    }


}

