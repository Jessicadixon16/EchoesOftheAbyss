/**
 * Author: Jessica Dixon
 * Date: June 24, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */



package EchoesOfAbyss;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class GameController {
    private Map<Integer, Room> rooms;
    private Player player;

    public GameController(String filePath, String playerName) throws IOException {
        rooms = RoomFileReader.readRoomsFile(filePath);
        player = new Player(playerName, 1); // Start in room 1
    }

    public void play() {
        printTitle();
        printIntro();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Room currentRoom = rooms.get(player.getCurrentRoomId());
            if (!currentRoom.isVisited()) {
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            } else {
                System.out.println(currentRoom.getName() + " (Visited)");
            }

            System.out.println("You can go " + currentRoom.getExits().keySet());
            System.out.print("What would you like to do? ");
            String command = scanner.nextLine().trim().toUpperCase();

            if (command.equals("X")) {
                System.out.println("Exit");
                break;
            } else if (currentRoom.getExits().containsKey(command)) {
                player.setCurrentRoomId(currentRoom.getExits().get(command));
            } else {
                System.out.println("Invalid direction entered");
            }
        }
        scanner.close();
    }

    private void printTitle() {
        System.out.println("\033[1;34m"); // Set text color to blue
        System.out.println("***************************************");
        System.out.println("*                                     *");
        System.out.println("*          Echoes of the Abyss        *");
        System.out.println("*                                     *");
        System.out.println("***************************************");
        System.out.println("\033[0m"); // Reset text color
    }

    private void printIntro() {
        System.out.println("\033[1;36m"); // Set text color to cyan
        System.out.println("Welcome to the Echoes of the Abyss!");
        System.out.println("In this game, you will explore a mysterious world,");
        System.out.println("solve puzzles, and uncover hidden secrets.");
        System.out.println("Good luck on your adventure!");
        System.out.println("\033[0m"); // Reset text color
    }

    }

