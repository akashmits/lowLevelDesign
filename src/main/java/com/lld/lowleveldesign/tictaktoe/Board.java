package com.lld.lowleveldesign.tictaktoe;

public class Board {
    int size;
    Piece[][] board;

    public Board(int size){
        this.size=size;
        board= new Piece[size][size];
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] !=null)
                System.out.print(board[i][j].pieceType.name()+"   ");
                else
                    System.out.print("   ");
                System.out.print("|");

            }
            System.out.println();
        }

    }
    public boolean isEmptyPosition(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] ==null) return true;
            }
        }
        return false;
    }
    public boolean addPeice(int rowPos, int colPos,Player player){
        System.out.println("Player |"+player.getName()+" | row |"+rowPos+" | colPos |"+colPos+" |"+board[rowPos][colPos]);
        if(board[rowPos][colPos]==null){
            board[rowPos][colPos]=player.getPiece();
            return true;
        }else{
            return false;
        }
       // if()
    }

    public boolean playerWin(Player player){
        Piece piece=player.getPiece();
        boolean isWin=true;
        for(int i=0;i<size;i++){
            if(board[i][0]!=piece){
                isWin=false;
                break;
            }
        }

        if(isWin){
            for(int i=0;i<size;i++){
                if(board[0][i]!=piece){
                    isWin=false;
                    break;
                }
            }
        }

        if(isWin){
            for(int i=0;i<size;i++){
                if(board[i][i]!=piece){
                    isWin=false;
                    break;
                }
            }
        }

        return isWin;
    }
}
