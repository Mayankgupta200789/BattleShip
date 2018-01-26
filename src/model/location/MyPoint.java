package model.location;

import service.board.BoardInfo;

import java.awt.*;

/**
 * @Author Mayank Gupta
 * @Date 8/29/17
 */
public class MyPoint extends Point implements Comparable<Point>{


    public MyPoint(int x, int y) {
        super(x, y);
        int boardSize = BoardInfo.BOARD.getBoardSize();
        if( x >= boardSize
                || y >= boardSize
                || x < 0
                || y < 0 ) {
            throw new IllegalArgumentException("Please enter a valid coordinate in 10X10 board");
        }
    }

    @Override
    public int compareTo(Point o) {

        if( this.getX() == o.getX() && this.getY() == o.getY() ) {
            return 0;
        }

        if( this.getX() >= o.getX() ) {

            if( this.getY() > o.getY() ) {
                return -1;
            } else if ( this.getY() < o.getY() ) {
                return 1;
            }
        }

        if( this.getY() >= o.getY() ) {

            if( this.getX() > o.getX() ) {
                return -1;
            } else if ( this.getX() < o.getX() ) {
                return 1;
            }
        }

        if(this.getX() < o.getX() ) {
            return 1;
        } else if ( this.getX() > o.getY() ) {
            return -1;
        }

        if( this.getY() < o.getY() ) {
            return 1;
        } else if ( this.getY() < o.getY() ) {
            return -1;
        }

        return 0;
    }
}
