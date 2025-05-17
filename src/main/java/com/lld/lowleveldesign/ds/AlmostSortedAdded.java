package com.lld.lowleveldesign.ds;

import snakeLadder.Pair;

import java.util.Stack;

public class AlmostSortedAdded {

    public static void main(String [] arg){
        int [] a={3,4,2,5,1};
        int test1=almostSortedArray(a);
        System.out.println("Test1 |"+(test1>=2?test1-1:0));

        int [] b={1,2,3,4,5};
        test1=almostSortedArray(b);
        System.out.println("Test2 |"+(test1>2?test1-1:0));

        int [] c={5,4,3,2,1};
        test1=almostSortedArray(c);
        System.out.println("Test3 |"+(test1>2?test1-1:0));




    }

    private static void usingLIS_DP_Approach(int[] nums, int n) {
        int[] lisDP = new int[n];
        lisDP[0] = 1;
        int maxLISLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lisDP[i] = 1; // as the number itself is also in a increasing sequence
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // to check if incoming numbers are greater than previous ones
                    lisDP[i] = Math.max(lisDP[i], lisDP[j] + 1); //If yes we add 1 to previous ones and get Max value
                    maxLISLen = Math.max(lisDP[i], maxLISLen);
                }
            }
        }
        int minDeletionReq = n - maxLISLen;
        System.out.println("Minimum deletion required to make array sorted sequence :" + minDeletionReq);
    }
    public static int almostSortedArray(int [] arr){
        Stack<Pair<Integer,Integer>> stack = new Stack<>();

        int max_len=1;

        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(new Pair<>(arr[i],1));
            }else{
                int max_val=0;

                while(!stack.isEmpty() && stack.peek().k<arr[i]){
                    max_val=Math.max(max_val,stack.peek().v+1);
                    stack.pop();
                }
                System.out.println("Max Val :"+max_val+" | max_len|"+max_len);
                stack.push(new Pair<>(arr[i],max_val));
                max_len=Math.max(max_len,max_val);
            }
        }
        return arr.length-max_len;
    }
}
