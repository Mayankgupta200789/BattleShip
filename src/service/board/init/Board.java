package service.board.init;

import model.cell.CellInfo;
import model.location.Location;
import model.ship.Ship;
import model.ship.ShipInfo;
import service.board.BoardInfo;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public class Board {

    private char[][] cells;

    private Ship[] ships = new Ship[]{
            new Ship(ShipInfo.SMALL_SIZE_SHIP.getShipSize()),
            new Ship(ShipInfo.MEDIUM_SIZE_SHIP.getShipSize()),
            new Ship(ShipInfo.LARGE_SIZE_SHIP.getShipSize()),
            new Ship(ShipInfo.EXTRA_LARGE_SIZE_SHIP.getShipSize())
    };

    private int boardSize;

    public Board() {
        initialize();
    }

    private void initialize() {
        this.boardSize = BoardInfo.BOARD.getBoardSize();
        cells = new char[boardSize][boardSize];

        for (int i = 1; i < boardSize; i++) {
            Arrays.fill(cells[i], CellInfo.EMPTY_CELL.getCellInfo());
        }
        placeShipsOnBoard();
        showCellsOnBoard();
    }

    private void placeShipsOnBoard() {

        Random random = new Random();

        int randomShipFromX,randomShipFromY,randomShipToX,randomShipToY;

        for (int i = 0; i < ships.length; i++) {
            Ship ship = ships[i];
            int range = boardSize - ship.getSize() - 1;

            while(true) {

                randomShipFromX = Math.abs(random.nextInt() % range) + 1;
                randomShipFromY = Math.abs(random.nextInt() % range) + 1;
                boolean isHorizontal = random.nextBoolean();

                if (isHorizontal) {
                    randomShipToX = randomShipFromX;
                    randomShipToY = randomShipFromY + ship.getSize() - 1;
                } else {
                    randomShipToX = randomShipFromX + ship.getSize() - 1;
                    randomShipToY = randomShipFromY;
                }

                Point from = new Point(randomShipFromX, randomShipFromY);
                Point to = new Point(randomShipToX, randomShipToY);
                Location location = new Location(from, to);

                if (isValidPosition(location)) {
                    addShipInACell(location);
                    ship.setLocation(location);
                    break;
                }
            }

        }
    }

    private boolean isValidPosition( Location location) {
        return !isCellOccupiedByAnotherShip(location);
    }

    private boolean isCellOccupiedByAnotherShip(Location location) {

        int sourceX = location.getSourceX();
        int destX = location.getDestinationX();
        int sourceY = location.getSourceY();
        int destY = location.getDestinationY();

        for (int i = sourceX; i <= destX; i++) {
            for (int j = sourceY; j <= destY; j++) {
                if (cells[i][j] == CellInfo.CELL_OCCUPIED_WITH_SHIP.getCellInfo()) {
                    return true;
                }
            }
        }

        return false;

    }

    private void addShipInACell(Location location) {

        int sourceX = location.getSourceX();
        int destX = location.getDestinationX();
        int sourceY = location.getSourceY();
        int destY = location.getDestinationY();

        for (int i = sourceX; i <= destX; i++) {
            for (int j = sourceY; j <= destY; j++) {
                cells[i][j] = CellInfo.CELL_OCCUPIED_WITH_SHIP.getCellInfo();
            }
        }
    }


    public void showCellsOnBoard() {

        for( int i = 1 ; i < boardSize; i++ ) {
            for( int j = 1; j < boardSize; j++ ) {
                System.out.print(cells[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public char[][] getCells() {
        return cells;
    }

    public Ship[] getShips() {
        return ships;
    }
}
