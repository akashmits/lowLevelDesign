package com.lld.lowleveldesign.tictaktoe;

public class MainClass {
    public static void main(String [] arg){
        TicTacToe game= new TicTacToe();
        game.initializeGame(3);
        game.playGame();
    }
}
