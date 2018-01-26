package service.game;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public enum GameInfo {

    START("start"),
    PLAYER,COMPUTER;

    private String gameInfo;

    GameInfo(String gameInfo) {
        this.gameInfo = gameInfo;
    }

    GameInfo() {
    }

    public String getGameInfo() {
        return gameInfo;
    }
}
