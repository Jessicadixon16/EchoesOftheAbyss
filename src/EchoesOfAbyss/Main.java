package EchoesOfAbyss;

import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Jessica Dixon
 * Date: June 24, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a new adventurer? (yes/no)");
        String startChoice = scanner.nextLine().toLowerCase();

        if ("yes".equals(startChoice)) {
            System.out.println("What is your name:");
            String playerName = scanner.nextLine();

            System.out.println("Type 'start game' to begin your adventure:");
            String gameStartCommand = scanner.nextLine().trim().toLowerCase();

            if ("start game".equals(gameStartCommand)) {
                String filePath = "src/Rooms.txt";

                try {
                    GameController gameController = new GameController(filePath, playerName);
                    gameController.play();
                } catch (IOException e) {
                    System.err.println("File read error: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid command. Exiting the game...");
            }
        } else {
            System.out.println("You saved yourself the terror... Exiting game. Goodbye!");
        }

        scanner.close();
    }
}