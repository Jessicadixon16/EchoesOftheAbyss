/**
 * Author: Jessica Dixon
 * Date: June 24, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */

package EchoesOfAbyss;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RoomFileReader {
    public static Map<Integer, Room> readRoomsFile(String filePath) throws IOException {
        Map<Integer, Room> rooms = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        Room room = null;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("ID")) {
                if (room != null) {
                    rooms.put(room.getId(), room);
                }
                int id = Integer.parseInt(line.split("=")[1].trim());
                room = new Room(id, "", "");
            } else if (line.startsWith("name")) {
                room.setName(line.split("=")[1].trim());
            } else if (line.startsWith("Description")) {
                StringBuilder description = new StringBuilder();
                while ((line = reader.readLine()) != null && !line.startsWith("exits")) {
                    description.append(line).append("\n");
                }
                room.setDescription(description.toString().trim());
            } else if (line.startsWith("You can go")) {
                String[] parts = line.split(" ");
                room.addExit(parts[3].trim(), Integer.parseInt(parts[4].trim()));
            }
        }
        if (room != null) {
            rooms.put(room.getId(), room);
        }
        reader.close();
        return rooms;
    }
}