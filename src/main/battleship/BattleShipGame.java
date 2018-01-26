package main.battleship;

import service.game.GameInfo;
import service.game.Game;

import java.util.Scanner;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public class BattleShipGame {

    public static void main(String args[]) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        String input = "";

        while( !input.equalsIgnoreCase(GameInfo.START.getGameInfo())) {

            System.out.println("Please enter 'START' to start the game ");
            input = scanner.nextLine();

        }

        Game game = new Game();

        game.start();
    }
}
