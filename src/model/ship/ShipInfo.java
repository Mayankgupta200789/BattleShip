package model.ship;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public enum ShipInfo {

    SMALL_SIZE_SHIP(2),
    MEDIUM_SIZE_SHIP(3),
    LARGE_SIZE_SHIP(4),
    EXTRA_LARGE_SIZE_SHIP(5);

    private int shipSize;

    ShipInfo(int shipSize) {
        this.shipSize = shipSize;
    }

    public int getShipSize() {
        return shipSize;
    }
}
