package snakeLadder;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderGame {
    Queue<Pair<Player,Position>> queue;
    Dice dice;
    Board board;

    public static void main(String [] args){
        Board board = new Board(10,10);

        List<Pair<Integer,Integer>> snakes= new ArrayList<>();
        snakes.add(new Pair<>(37,11));
        snakes.add(new Pair<>(96,4));

        board.setSnakes(snakes);

        List<Pair<Integer,Integer>> ladders= new ArrayList<>();
        ladders.add(new Pair<>(11,53));
        ladders.add(new Pair<>(27,98));

        board.setLadder(ladders);

        List<Player> players= new ArrayList<>();
        players.add(new Player("Akash"));
        players.add(new Player("Ram"));


        SnakeAndLadderGame snakeAndLadderGame= new SnakeAndLadderGame(players,2,board);
        System.out.println("Starting the game");
        snakeAndLadderGame.gameStart();


    }
    public SnakeAndLadderGame(List<Player> playerList, int numberOfDice, Board board){
       queue= new LinkedList<>();

       for(Player player:playerList){
           queue.add(new Pair(player, new Position(0,0)));
       }

       this.dice= new Dice(numberOfDice);
       this.board=board;
    }

    public void gameStart(){

        while(!queue.isEmpty())
        {
            Pair<Player,Position> currPlayer =queue.poll();
            Player player =currPlayer.k;
            Position position =currPlayer.v;


            int diceNum=dice.thorowDice();
            //System.out.println("Player Turn :"+player.name+" | Dice Number Received|"+diceNum);

            int newRow=position.currRow+diceNum;
            int newCol=position.currCol+diceNum;

            System.out.println("Player Turn :"+player.name+" | Dice Number Received|"+diceNum+"| New Row"+newRow +" |newCol |"+newCol);

            if(newRow> board.rows || newCol> board.cols){
                queue.add(currPlayer);
            }else if(newRow==board.rows && newCol== board.cols){
                System.out.println("Player Win the game. Name :"+player.name);
                break;
            }
            else{
                int index =newRow*board.rows+newCol;

                Integer newPosition=board.snakeLadders.get(index);

                if(newPosition==null){
                    position.currRow= newRow;
                    position.currCol=newCol;
                    queue.add(currPlayer);
                }else{
                    position.currRow=newPosition/ board.rows;
                    position.currCol=newPosition% board.cols;
                    queue.add(currPlayer);
                }
            }

        }
    }
}
