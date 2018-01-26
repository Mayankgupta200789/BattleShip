package service.player;

import model.cell.CellInfo;
import model.location.Location;
import model.location.MyPoint;
import model.ship.Ship;
import service.board.init.Board;
import service.game.HitInfo;

import java.awt.*;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public class Player {

  private Board board;

  private int totalShipsDestroyed;

    public Player(String player) {
        System.out.println("===============================================");
        System.out.println( player  + "    board "   );
        System.out.println("===============================================");
        System.out.println("                                               ");
        this.board = new Board();
    }

    public HitInfo targetShips(MyPoint point) {
        return modifyCell(point);
    }

    public void showCellsOnBoard() {
        board.showCellsOnBoard();
    }

    private HitInfo modifyCell(MyPoint point) {

        Ship[] ships = board.getShips();
        char[][] cells = board.getCells();

        int x = (int) point.getX();
        int y = (int) point.getY();

        for (int i = 0; i < ships.length; i++) {

            Ship ship = ships[i];

            Location location = ship.getLocation();

            Point from = location.getFrom();
            Point to = location.getTo();

            if(isTargetWithinCircumferenceOfShip(from,to,point,cells)) {
                cells[x][y] = CellInfo.CELL_DESTROYED.getCellInfo();
                int livesLeft = ship.getLivesLeft();
                ship.setLivesLeft(--livesLeft);
                return isSuccessfullHit(ship);
            }
        }

        return HitInfo.MISS;

    }


    private boolean isTargetWithinCircumferenceOfShip(Point from,
                                                      Point to,
                                                      MyPoint input,
                                                      char[][] cells) {

        int x = (int)input.getX();
        int y = (int)input.getY();

        return input.compareTo(from) <= 0 && input.compareTo(to) >= 0
                && cells[x][y] != CellInfo.CELL_DESTROYED.getCellInfo()
                     && cells[x][y] == CellInfo.CELL_OCCUPIED_WITH_SHIP.getCellInfo();
    }

    private HitInfo isSuccessfullHit(Ship ship) {

        if (ship.getLivesLeft() == 0) {
            totalShipsDestroyed++;
        }

        if( totalShipsDestroyed == 4 ) {
            return HitInfo.SUCCESS;
        } else {
            return HitInfo.HIT;
        }
    }

}
