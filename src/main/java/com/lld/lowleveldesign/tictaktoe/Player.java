package com.lld.lowleveldesign.tictaktoe;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Player {
    private String name;
    private Piece piece;

    public Player(String name, Piece piece){
        this.name=name;
        this.piece=piece;
    }

}
