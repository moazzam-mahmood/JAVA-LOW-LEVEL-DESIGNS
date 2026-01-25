package com.examples.lld.tick_tac_toe;

import com.examples.lld.tick_tac_toe.model.GameStatus;

public class PlayGame {
    public static void main(String[] args) {
        System.out.println("\n===>>> TicTacToe Game\n");
        TicTacToeGame game = new TicTacToeGame();
        game.intializeGame();
        GameStatus status = game.startGame();
        System.out.print("\n===>>> GAME OVER: ");
        switch(status){
            case WIN:
                System.out.print(game.winner.getName() + " won the game");
                break;
            case DRAW:
                System.out.print(" Its a Draw!");
                break;
            default:
                System.out.print(" Game Ends");
                break;
        }
    }
}
