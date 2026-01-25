package com.examples.lld.tick_tac_toe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int size;
    private final PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if(board[row][col] != null) {
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }

//    public List<Pair<Integer,Integer>> getFreeCalls(){
//        List<Pair<Integer,Integer>> freeCalls = new ArrayList<>();
//        for(int i = 0; i < size; i++) {
//            for(int j = 0; j < size; j++) {
//                if(board[i][j] == null) {
//                    Pair<Integer,Integer> pair = new Pair<>(i, j);
//                    freeCalls.add(pair);
//                }
//            }
//        }
//        return freeCalls;
//    }

    public boolean getFreeCalls(){
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            // print each cell in the row
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(" " + board[i][j].getPieceType() + " ");
                } else {
                    System.out.print("   ");
                }
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();

            // print horizontal separator
            if (i < size - 1) {
                for (int k = 0; k < size; k++) {
                    System.out.print("---");
                    if (k < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece getBoard(int row, int col) {
        return board[row][col];
    }

}
