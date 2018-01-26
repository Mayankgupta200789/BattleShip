package model.location;

import java.awt.*;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public class Location {

    private Point from;
    private Point to;

    public Location(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public int getSourceX(){
        return (int)Math.min(from.getX(),to.getX());
    }

    public int getDestinationX(){
        return (int)Math.max(from.getX(),to.getX());

    }

    public int getSourceY(){
        return (int)Math.min(from.getY(),to.getY());
    }

    public int getDestinationY(){
        return (int)Math.max(from.getY(),to.getY());

    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

}
