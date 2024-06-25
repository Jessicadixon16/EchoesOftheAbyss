/**
 * Author: Jessica Dixon
 * Date: June 24, 2024
 * Sources: W3Schools, Stack Overflow, Codecademy
 */


package EchoesOfAbyss;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private int id;
    private String name;
    private String description;
    private boolean visited;
    private Map<String, Integer> exits;

    public Room(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.visited = false;
        this.exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addExit(String direction, int roomId) {
        exits.put(direction.toUpperCase(), roomId);
    }

    public Integer getExit(String direction) {
        return exits.get(direction.toUpperCase());
    }

    public Map<String, Integer> getExits() {
        return exits;
    }
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", visited=" + visited +
                ", exits=" + exits +
                '}';
    }
}