public abstract class BattleLocation extends Location{
   protected Obstacle obstacle;
   protected String award;
    BattleLocation(Player player, String name,Obstacle obstacle, String award) {

        super(player);
        this.name=name;
        this.obstacle = obstacle;
        this.award = award;
    }

    @Override
    public boolean getLocation() {
        int obstacleCount = obstacle.count();
        System.out.println("Here: "+this.getName());
        System.out.println(obstacleCount+" enemy "+ obstacle.getName()+" appeared.");
        System.out.println("Do you wanna fight?");
        System.out.println("Yes -> tap <Y>");
        System.out.println("No  -> tap <N>");
        String selectCase = scanner.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("Y")){
            if(combat(obstacleCount)){
                System.out.println("Your money: "+player.getMoney());
                if(this.award.equals("crown") && player.getInventory().isCrown()==false){
                    System.out.println("You take 'Crown'. (^O^)");
                    player.getInventory().setCrown(true);
                }

                return true;
            }else{
                System.out.println("You lose...");
                return false;
            }
        }

        return true;

}       public boolean combat(int obsCount){
        for(int i=0 ; i<obsCount ; i++){
            int defObstacleHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while(player.getHealth() > 0 && obstacle.getHealth() > 0){
                System.out.println("Hit -> 'H'");
                System.out.println("Run away -> 'R'");
                String select= scanner.nextLine();
                select = select.toUpperCase();
               if(select.equals("H")) {
                   System.out.println("You hit the enemy!");
                   obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                   afterHit();

                   if (obstacle.getHealth() > 0) {

                       System.out.println("Enemy hit to you!");
                       player.setHealth(player.getHealth()-obstacle.getDamage());
                       afterHit();
                   }
               }else{
                    break;
                }

            }

            if(obstacle.getHealth() <=0 && player.getHealth() >0){
                System.out.println("You kill the enemy.");
                System.out.println(".........................................................");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("You take: '"+obstacle.getAward()+"' gold.");
                System.out.println("Your money: '"+player.getMoney()+" 'gold.");
                obstacle.setHealth(defObstacleHealth);
            }else if (player.getHealth() <=0){
                return false;
            }
        }
        return true;
    }
    public void playerStats(){
        System.out.println("Player status: ");
        System.out.println("Health: "+player.getHealth());
        System.out.println("Damage: "+player.getDamage());
        if(player.getInventory().getDamage()>0){
            System.out.println("Weapon: "+player.getInventory().getWeaponName());
        }
        if(player.getInventory().getArmor()>0){
            System.out.println("Armor: "+player.getInventory().getArmorName()+" + "+player.getInventory().getArmor());


        }
        System.out.println("-----------------------------");
    }

    public void enemyStats(){
        System.out.println(obstacle.getName()+" status:");
        System.out.println("Health: "+obstacle.getHealth());
        System.out.println("Damage: "+obstacle.getDamage());
        System.out.println("-----------------------------");

    }
    public void afterHit(){
        System.out.println("Player health: => "+player.getHealth());
        System.out.println(obstacle.getName() +" => health: "+obstacle.getHealth());
        System.out.println("..................................................................................");
    }


}
