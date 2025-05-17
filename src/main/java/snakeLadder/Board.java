package snakeLadder;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    int rows;
    int cols;
    Map<Integer,Integer> snakeLadders;
    
    public Board(int row,int col){
        this.rows=row;
        this.cols=col;
        this.snakeLadders= new HashMap<>();
    }


    public void setSnakes(List<Pair<Integer,Integer>> snakesPosition){

        for(Pair<Integer,Integer> pair: snakesPosition){
            if(pair.k>pair.v){
                snakeLadders.put(pair.k,pair.v);
            }else{
                System.out.println("Snake Position not correct: "+pair);
            }
        }
    }

    public void setLadder(List<Pair<Integer,Integer>> ladderPosition){

        for(Pair<Integer,Integer> pair: ladderPosition){
            if(pair.k<pair.v){
                snakeLadders.put(pair.k,pair.v);
            }else{
                System.out.println("Snake Position not correct: "+pair);
            }
        }
    }




    
}