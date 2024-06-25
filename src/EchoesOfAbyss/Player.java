/**
 * Author: Jessica Dixon
 * Date: June 24, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package EchoesOfAbyss;

public class Player {
    private String name;
    private int currentRoomId;

    public Player(String name, int startingRoomId) {
        this.name = name;
        this.currentRoomId = startingRoomId;
    }

    public String getName() {
        return name;
    }

    public int getCurrentRoomId() {
        return currentRoomId;
    }

    public void setCurrentRoomId(int currentRoomId) {
        this.currentRoomId = currentRoomId;
    }
}