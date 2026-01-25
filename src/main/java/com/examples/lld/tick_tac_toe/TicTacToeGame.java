package com.examples.lld.tick_tac_toe;

import com.examples.lld.tick_tac_toe.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;
    Player winner;

    public void intializeGame() {

        //Creating 2 players
        players = new LinkedList<>();
        PlayingPieceX playerX = new PlayingPieceX();
        Player player1 = new Player("Player1", playerX);

        PlayingPieceO playerO = new PlayingPieceO();
        Player player2 = new Player("Player2", playerO);

        players.add(player1);
        players.add(player2);

        // Initialize Board of size 3
        gameBoard = new Board(3);
    }

    public GameStatus startGame() {
        boolean noWinner = true;
        while(noWinner) {

            // Remove the player whose turn is and also put the player in the list back
            Player currentPlayer = players.removeFirst();

            // Get the free space from the board
            gameBoard.printBoard();
//            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCalls();
//            if (freeSpaces.isEmpty()) {
//                noWinner = false;
//                continue;
//            }
            boolean isFreeSpaces = gameBoard.getFreeCalls();
            if(!isFreeSpaces) {
                noWinner = false;
                continue;
            }

            // Read the user input
            System.out.print("Player: " + currentPlayer.getName() + " - Please enter [row, column]: ");
            Scanner scn = new Scanner(System.in);
            String s = scn.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            boolean validMove = gameBoard.addPiece(inputRow,inputColumn,currentPlayer.getPlayingPiece());
            if (!validMove) {
                // Invalid Move: Player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again!");
                players.addFirst(currentPlayer); // Add the player back to the queue(in the front)
                continue;
            }
            players.addLast(currentPlayer);// Add the player to the end of the queue

            // Check if the valid move is a winning move or not
            boolean isWinner = checkWinner(inputRow, inputColumn,currentPlayer.getPlayingPiece().getPieceType());
            if (isWinner) {
                gameBoard.printBoard();
                winner = currentPlayer;
                return GameStatus.WIN;
            }
        }

        return GameStatus.DRAW;
    }

    public boolean checkWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //check row
        for(int i = 0; i< gameBoard.getSize(); i++) {
            if(gameBoard.getBoard(row,i) == null || !gameBoard.getBoard(row, i).getPieceType().toString().equals(pieceType.toString())){
                rowMatch = false;
            }
        }

        //check col
        for(int i = 0; i< gameBoard.getSize(); i++) {
            if (gameBoard.getBoard(i, col) == null || !gameBoard.getBoard(i, col).getPieceType().toString().equals(pieceType.toString())){
                columnMatch = false;
            }
        }

        //check diagonal
        for(int i = 0,j = 0; i< gameBoard.getSize(); i++, j++) {
            if (gameBoard.getBoard(i,j) == null || !gameBoard.getBoard(i, j).getPieceType().toString().equals(pieceType.toString())){
                diagonalMatch = false;
            }
        }

        //anti-diagonal check
        for(int i = 0,j = gameBoard.getSize()-1; i< gameBoard.getSize(); i++, j--) {
            if (gameBoard.getBoard(i,j) == null || !gameBoard.getBoard(i, j).getPieceType().toString().equals(pieceType.toString())){
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }
}
