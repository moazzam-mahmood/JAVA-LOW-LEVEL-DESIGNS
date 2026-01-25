package com.examples.lld.tick_tac_toe.model;

public class PlayingPiece {

    PieceType pieceType;

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
