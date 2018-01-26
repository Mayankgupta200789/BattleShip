package service.board;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mayank Gupta
 * @Date 8/28/17
 */
public enum  BoardInfo {

    BOARD(11);

    private int boardSize;

    private static Map<String,Integer> rowMap = new HashMap<>();

    static {

        rowMap.put("A",1);
        rowMap.put("a",1);
        rowMap.put("B",2);
        rowMap.put("b",2);
        rowMap.put("C",3);
        rowMap.put("c",3);
        rowMap.put("D",4);
        rowMap.put("d",4);
        rowMap.put("E",5);
        rowMap.put("e",5);
        rowMap.put("F",6);
        rowMap.put("f",6);
        rowMap.put("G",7);
        rowMap.put("g",7);
        rowMap.put("H",8);
        rowMap.put("h",8);
        rowMap.put("I",9);
        rowMap.put("i",9);
        rowMap.put("J",10);
        rowMap.put("j",10);

    }

    BoardInfo(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Integer getBoardRow(String input ) {

        Integer rowNum = rowMap.get(input);

        if( rowNum == null ){
            throw new IllegalArgumentException("Please enter a valid row between A to I");
        }

        return rowNum;

    }
}

