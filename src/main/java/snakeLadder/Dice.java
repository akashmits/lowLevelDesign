package snakeLadder;

public class Dice {
    int numberOfDice;
    public Dice(int n){
        this.numberOfDice=n;
    }

    public int thorowDice(){
        int number=0;

        for(int i=0;i<this.numberOfDice;i++){
            number+=Math.random()*6+1;
        }

        return number;
    }
}
