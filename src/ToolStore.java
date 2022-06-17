public class ToolStore extends Location{
    ToolStore(Player player) {
        super(player);
    }

    @Override
    public boolean getLocation() {
        System.out.println("Money: "+player.getMoney());
        System.out.println("1) Weapons");
        System.out.println("2) Armors");
        System.out.println("0-Exit");
        int select = scanner.nextInt();
        int selectItem;

        switch (select){
            case 1:selectItem = weaponMenu();
            buyWeapon(selectItem);
                break;

            case 2: selectItem =armorMenu();
            buyArmor(selectItem);
                break;

            default:
        }

        return true;
    }
    public int weaponMenu(){
        System.out.println("1) Knife:        \tMoney: 30\tDamage: +2 ");
        System.out.println("2) Sword:        \tMoney: 40\tDamage: +5");
        System.out.println("3) Axes of Odin:\tMoney: 70\tDamage: +15");
        System.out.println("4) Sword of Kings\tMoney: 150\tDamage: +30");
        System.out.println("0-Cancel");
        int selectWeapon = scanner.nextInt();
        return selectWeapon;
    }

    public int armorMenu(){
        System.out.println("1) Helmet:          \tMoney: 35\tArmor: +20");
        System.out.println("2) Armor:           \tMoney: 65\tArmor: +40");
        System.out.println("3) Shield:          \tMoney: 100\tArmor: +75");
        System.out.println("4) Shield of Kings:\t Money:200\tArmor: +90");
        int selectArmor = scanner.nextInt();
        return selectArmor;
    }
    public void buyArmor(int armorID){
        int armor=0,price=0;
        String armorName=null;

        switch (armorID){
            case 1:
                armorName ="Helmet";
                armor=20;
                price =35;
                break;
            case 2:
                armorName="Armor";
                armor=40;
                price=65;
                break;
            case 3:
                armorName="Shield";
                armor = 75;
                price = 100;
                break;
            case 4:
                armorName="Shield of King";
                armor=90;
                price=200;

            case 0:
                System.out.println("Exit.");
            default:
                System.out.println("You didn't choose anyone.");

        }
        if(player.getMoney() >= price){
            player.getInventory().setArmor(armor);
            player.getInventory().setArmorName(armorName);
            player.setMoney(player.getMoney()-price);
            System.out.println("You bought a new armor! ^-^");
            System.out.println("Your new armor: "+player.getInventory().getArmor());
            System.out.println("Your money: "+player.getMoney());
        }else {
            System.out.println("You don't have enough money for this.");
        }
    }
    public void buyWeapon(int itemID){
        int damage=0,price=0;
        String weaponName=null;

            switch (itemID){
                case 1:
                    weaponName="Knife";
                    damage = 2;
                    price = 30;
                    break;

                case 2:
                    weaponName="Sword";
                    damage=5;
                    price=40;
                    break;

                case 3:
                    weaponName="Axe of Odin";
                    damage=15;
                    price=70;
                    break;
                case 4:
                weaponName="Sword of Kings";
                damage=30;
                price=150;

                case 0:
                    System.out.println("Exit.");


                default:
                    System.out.println("You didn't choose anyone.");

            }
            if(player.getMoney() >= price ) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney()-price);
                System.out.println("You bought a new weapon! ^-^");
                System.out.println("Your damage now: "+player.getTotalDamage());
                System.out.println("Your money: "+player.getMoney());


            }else {
                System.out.println("You don't have enough money for this.");
            }

        }
    }

