package concentric;

/*

There are N monsters, moving on a one  directional plane, they can move either to right or left.
The health of monster i is represented by ith element of the health array.
Where as direction of each monster is represented by direction array,
1 if it is moving to right or -1 if it is moving to the left. Each monster moves with a same constant speed.
        When two monsters reach same position they would fight,
        the one with the lesser health will be eliminated.
         If they are the same health, both will be eliminated.
          Monsters traveling in the same direction won't collide with each other.
        Print the final state of the monsters after all fights.
         First print number of monsters left and their health and direction.
        N = 3
        health = [5, 10, 5]
        direction = [1, 1, -1]


        2
        5 right
        10 right
        */

 //the one with the lesser health will be eliminated.
// If they are the same health, both will be eliminated.
/*
N = 3
        health = [10, 2, 5]
        direction = [1, 1, -1]


 */

//output: remaining monster and direction

import snakeLadder.Pair;

import java.util.Stack;

public class Test {

    public static  void main(String [] arg){
        int N = 3;
        int [] health = {10, 2, 5};
        int [] direction = {1, 1, -1};

        remainingMonster(N,health,direction);

        int N1 = 3;
        int [] health1 = {10, 2, 5};
        int [] direction1 = {-1, 1, -1};

        remainingMonster(N1,health1,direction1);


        int N2 = 3;
        int [] health2 = {10, 18, 5};
        int [] direction2 = {-1, 1, -1};

       // <- 10.   18 ->  <- 5
        remainingMonster(N1,health2,direction2);

        int N3 = 4;
        int [] health3 = {10, 18, 5,20};
        int [] direction3 = {-1, 1, -1,-1};

        remainingMonster(N3,health3,direction3);




    }

    public static  void remainingMonster(int N, int [] health, int [] direction){
        if(N==0)
        {
            return;
        }
        else if(N==1)
        {
            System.out.println("Remaining monster :"+N+" | Health |"+health[0]);
        }

        Stack<int []> stack= new Stack<>();
        // int [] health2 = {10, 18, 5};
        // int [] direction2 = {-1, 1, -1};
        //stack.push(new int []{health[0],direction[1]});
        //health = [10, 10, 5]
        //direction = [1, -1, -1]

        //    health = [5, 10]
        //        direction = [1, -1]
        for(int i=0;i<N;i++){
            if(stack.isEmpty() || stack.peek()[1]==direction[i] ){
                stack.push(new int []{health[i],direction[i]});
            }
            else {
                // -1 ,1
                //  int [] health3 = {10, 18, 5,20};
                //        int [] direction3 = {-1, 1, -1,-1};
                int currDirect=direction[i];
                while(stack.peek()[1]!=currDirect){

                    //-1 1
                    // 1 -1

                    if( stack.peek()[1]==-1 && direction[i]==1){
                        stack.push(new int []{health[i],direction[i]});
                        break;
                    }
                    int [] currPos=stack.pop();
                    if(currPos[0]!=health[i]){
                        if(currPos[0]>health[i]){
                            stack.add(currPos);
                            break;
                        }
                    }else if(currPos[0]==health[i]){
                        break;
                    }

                    if(stack.isEmpty() || stack.peek()[1]==direction[i] ||  stack.peek()[1]==-1 && direction[i]==1){
                        stack.push(new int []{health[i],direction[i]});
                        break;
                    }
                }
            }
        }

        System.out.println("NO of Monster Remaining |"+stack.size());

        while(!stack.isEmpty()){
            System.out.println("Monster health |"+stack.pop()[0]);
        }
    }
}
