package com.lld.lowleveldesign.tictaktoe;

import lombok.ToString;

@ToString
public class Piece {
    PieceType pieceType;

    public Piece(PieceType pieceType){
        this.pieceType=pieceType;
    }
}
