package com.lld.lowleveldesign.ds.backtrack;

public class AndroidPasswordPattern {
    /*
    Given an  Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:

Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
     */
    public static void main(String [] arg){
        AndroidPasswordPattern app= new AndroidPasswordPattern();
       // System.out.println(app.numberOfPatterns(1,1));
    }
    private int m;
    private int n;
    private int [][] cross= new int[10][10];
    private boolean [] visited= new boolean[10];

    public void numberOfPatterns(int m, int n) {
        this.m=m;
        this.n=n;
        cross[1][3]=cross[3][1]=2;
        cross[4][6]=cross[6][4]=5;
        cross[7][9]=cross[9][7]=8;
        cross[1][7]=cross[7][1]=4;
        cross[2][8]=cross[8][2]=5;
        cross[3][9]=cross[9][3]=6;
        cross[1][9]=cross[9][1]=5;
        cross[3][7]=cross[7][3]=5;

    }

    public int fun(int i, int cnt){
        if(cnt>n) return 0;

        visited[i]=true;

        int ans= cnt>=m ?1:0;

        for(int j=1;j<=9;j++){
            int x=cross[i][j];

            if(!visited[j] && (x==0 || visited[x])){
                ans+= fun(j,cnt+1);
            }
        }

        visited[i]=false;
        return ans;
    }

}
