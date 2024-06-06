package EchoesOfAbyss;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a new adventurer? (yes/no)");
        String startChoice = scanner.nextLine().toLowerCase();

        if ("yes".equals(startChoice)) {
            System.out.println("What is your name:");
            String playerName = scanner.nextLine();

            System.out.println("Please select the map 1");
            String mapChoiceString = scanner.nextLine().trim();
            int mapChoice;

            try {
                mapChoice = Integer.parseInt(mapChoiceString);
            } catch (NumberFormatException e) {
                System.out.println("Invalid map choice. Exiting the game... Please re-run.");
                return;
            }

            String filePath = null;
            if (mapChoice == 1) {
                filePath = "src/Rooms.txt";
            } else if (mapChoice == 2) {
                filePath = "src/Rooms2.txt";
            } else {
                System.out.println("Invalid map choice. Exiting the game...");
                return;
            }

            try {
                GameController gameController = new GameController(filePath, playerName);
                gameController.play();
            } catch (IOException e) {
                System.err.println("File read error: " + e.getMessage());
            }
        } else {
            System.out.println("You saved yourself the terror... Exiting game. Goodbye!");
        }

        scanner.close();
    }
}
