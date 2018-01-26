package model.ship;

import model.location.Location;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public class Ship {

    private int size;

    private int livesLeft;

    private Location location;

    public Ship(int size) {

        this.size = size;
        this.livesLeft = size;
    }

    public int getSize() {
        return size;
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
