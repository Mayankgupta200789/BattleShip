package model.location.util;

import java.awt.*;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public class LocationUtil {

    private LocationUtil() {
    }

    public static double distanceBetweenTwoPoints(Point from,Point to) {

        double fromX = from.getX();
        double fromY = from.getY();
        double toY = to.getY();
        double toX = to.getX();

        return fromX == toX ? Math.abs(fromY - toY ) : Math.abs(fromX - toX );
    }
}
