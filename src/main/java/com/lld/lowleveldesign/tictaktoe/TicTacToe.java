package com.lld.lowleveldesign.tictaktoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToe {
     Queue<Player> queue= new LinkedList<>();
    Board board;
    Scanner sc;

    public void  initializeGame(int boardSize) {
        board = new Board(3);
        Player p1 = new Player("Akash", new Piece(PieceType.X));
        Player p2 = new Player("Ravi", new Piece(PieceType.O));
        queue.add(p1);
        queue.add(p2);
        sc = new Scanner(System.in);
    }

    public void playGame(){

        boolean correctInput=true;
        Player turnPlayer=null;
        while(true) {
            if(correctInput) {
                turnPlayer = queue.poll();
            }
            System.out.println("Player Turn :"+turnPlayer);
            String s1 = sc.nextLine();
            if(s1.equals("")){
                System.out.println("Please enter correct Input:");
                correctInput=false;
                continue;
            }
            System.out.println("Input Read |"+s1);
            String[] positions = s1.split(",");
            int row = Integer.parseInt(positions[0]);
            int col = Integer.parseInt(positions[1]);
            if(row>=board.size  || col>=board.size || row<0 || col <0){
                System.out.println("Please enter correct Input:");
                correctInput=false;
            }
            if(!board.isEmptyPosition())
            {
                System.out.println("Game try, please start again , please 0 for restart and 1 for close");
                break;
            }
            if(board.addPeice(row,col,turnPlayer)){
                correctInput=true;
                board.printBoard();
                    if(board.playerWin(turnPlayer))
                    {
                        System.out.println("Player |"+turnPlayer.getName()+" win ");
                        break;
                    }else{
                        queue.add(turnPlayer);
                    }
            }else{
                System.out.println("Wrong Input please enter again:");
                correctInput=false;
            }
        }

    }

}
