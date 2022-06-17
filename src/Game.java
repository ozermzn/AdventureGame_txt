import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);

    public void login() {

        System.out.println("Please write your name.");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        System.out.println("Welcome " + playerName);
        player.characterMenu();
        player.selectCharacter();
        player.getCharacterName();
        start();

    }

    public void start() {
        while (true) {
            System.out.println("\n=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>\n");
            System.out.println("Welcome " + player.getName() + "! You are now at the home, here you heal and safely.\nWhat do you want?");
            System.out.println("1-> Home: Go back home and some rest.");
            System.out.println("2-> Forest: There is wolfs, be careful!");
            System.out.println("3-> Hospital: Smell like a rotten meat...");
            System.out.println("4-> Village: Here invaded from barbarians.");
            System.out.println("5-> Castle: Witch...Live here...(Boss)");
            System.out.println("0-> Shop: Do you need weapon or armor maybe both of them?");


            int selectLocal = scanner.nextInt();
            if (selectLocal < 0 && selectLocal > 6) {
                System.out.println("Please choose you wanna go location.");
                selectLocal = scanner.nextInt();

            }
            switch (selectLocal) {
                case 1:
                    location = new Home(player);
                    break;
                case 2:
                    location = new Forest(player);
                    break;
                case 3:
                    location = new Hospital(player);
                    break;
                case 4:
                    location = new Village(player);
                    break;
                case 5:
                    location = new Castle(player);
                    break;
                case 0:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new Home(player);

            }
            if (location.getClass().getName().equals("Home")) {
                if (player.getInventory().isCrown()==true) {
                    System.out.println("-Congrulations warrior! ");
                    System.out.println("(^o^) (^0^) (^o^)");
                    System.out.println("-You defeat the Lord Witch and you bring peace to our world.");
                    System.out.println("-We will tell forever your story. Thank you!");
                    System.out.println("YOU WIN!");
                    break;

                }

            }
            if (!location.getLocation()) {
                System.out.println("Game Over!");
                break;
            }
        }

        System.out.println("Thanks for play, be happy my friend.");

        }
}







