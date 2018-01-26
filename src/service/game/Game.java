package service.game;

import model.location.MyPoint;
import service.player.Player;

import java.util.Random;
import java.util.Scanner;

import static service.board.BoardInfo.BOARD;
import static service.game.GameInfo.COMPUTER;
import static service.game.GameInfo.PLAYER;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public class Game {

    private Player[] players;


    public Game() {
        Player player = new Player(PLAYER.toString());
        Player computer = new Player(COMPUTER.toString());
        this.players = new Player[]{player, computer};
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        int coordinateRange = BOARD.getBoardSize() - 1;

        Player player = players[0];
        Player computer = players[1];

        while (true) {

            System.out.println("Enter x coordinate to fire range from A to J ");
            String playerInput = scanner.next();

            int playerInputX = 0;

            try {
                playerInputX = BOARD.getBoardRow(playerInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("                                               ");
                continue;
            }

             System.out.println("Enter y coordinate to fire range from 1 to 10");
             int playerInputY = scanner.nextInt();
             MyPoint playerHittingPoint = null,computerHittingPoint = null;


            int computerX = Math.abs(random.nextInt() % coordinateRange) + 1;
            int computerY = Math.abs(random.nextInt() % coordinateRange) + 1;

            try {
                    playerHittingPoint = new MyPoint(playerInputX, playerInputY);
                    computerHittingPoint = new MyPoint(computerX, computerY);
                } catch (IllegalArgumentException e) {

                    System.out.println(e.getLocalizedMessage());
                    System.out.println("                                               ");
                    continue;
                }

            HitInfo playerHitInfo = computer.targetShips(playerHittingPoint);

            printHitInfoStatusOnConsole(computer, playerHitInfo, PLAYER.toString());

            HitInfo computerHitInfo = player.targetShips(computerHittingPoint);

            printHitInfoStatusOnConsole(player,computerHitInfo, COMPUTER.toString());
        }
    }

    private void printHitInfoStatusOnConsole(Player loosingPlayer, HitInfo playerHitInfo,String player) {
        if (playerHitInfo == HitInfo.SUCCESS) {

            System.out.println("                                               ");
            System.out.println(  player + " won the game");
            System.out.println("===============================================");
            System.out.println("State of the  board of the loosing player ");
            System.out.println("===============================================");
            System.out.println("                                               ");
            loosingPlayer.showCellsOnBoard();
            System.exit(0);
        }

        System.out.println();
        System.out.println(player + " hit status : ");
        System.out.println(playerHitInfo);
        System.out.println();
    }


}
