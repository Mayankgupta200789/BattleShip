package model.cell;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public enum  CellInfo {

    EMPTY_CELL('-'),
    CELL_OCCUPIED_WITH_SHIP('S'),
    CELL_DESTROYED('X');

    private char cellInfo;

    CellInfo(char cellInfo) {
        this.cellInfo = cellInfo;
    }

    public char getCellInfo() {
        return cellInfo;
    }
}
