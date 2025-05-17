package com.lld.lowleveldesign;

/*
you are given two lists of closed intervals,
firstList and secondList,
where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
 Each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 */

/*
Input: firstList = [[0,2],[5,10],[13,23],[24,25]],
        secondList = [[1,5],[8,12],[15,24],[25,26]]
        Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
*/
/*[0,2]->
[1,5]->
  firstListIndex=0;
 secondListIndex=0;
x1=1,X2=2
outputlist
        while(firstListIndex<fistList.size() && secondListIndex.secondLisr.size())
        {
            x1=Math.max(firstListIndex.get(firstListIndex).get(0),secondListIndex.get(secondListIndex).get(0));
            x2=Math.max(firstListIndex.get(firstListIndex).get(0),secondListIndex.get(secondListIndex).get(0));

            low<=x1<=high&&low<=x2<=high&&low1<=x1<=high1&&low1<=x2<=high1
        list.add(x1,x2);

        }
high
*/

import java.util.ArrayList;
import java.util.List;

// max,min -> 1,2
//[1,2] [3,4] []
//[5,6] [7,8]
public class Tekion {

            public static void main(String [] arg){
                  int [][] firstList=  {{0,2}};
                  int [][] secondList={{1,1}};
                //5,5
                //8,12


                  //{13,23}
                //{15,24}

                //15,23

               // {24,25}
                //{15,24}

                //max=24,min24

                List<int [] > result=findIntersectionList(firstList,secondList);

                for(int [] rs:result){
                System.out.println(rs[0]+" "+rs[1]);
                }
            }

            public static  List<int []> findIntersectionList(int [][] firstList,int [][] secondList){
                int firstListIndex=0;
                int secondListIndex=0;
                //m,n -> )(m+n)
                List<int[]> result= new ArrayList<>();
                if(firstList.length==0 ||secondList.length==0 )
                    return result;


                //[1,2]
                //[2,3]
                while(firstListIndex<firstList.length && secondListIndex<secondList.length)
                {
                    int x1=Math.max(firstList[firstListIndex][0],secondList[secondListIndex][0]);
                    int x2=Math.min(firstList[firstListIndex][1],secondList[secondListIndex][1]);
                    int start1=firstList[firstListIndex][0];
                    int high1=firstList[firstListIndex][1];

                    int start2=secondList[secondListIndex][0];
                    int high2=secondList[secondListIndex][1];

                  //  int [][] firstList=  {{0,2},{5,5},{6,10},{13,23},{24,25}};
                    //int [][] secondList={{1,4},{8,12},{15,24},{25,26}};
                    //x1=5,x2=4
                    ///1<=5
                        //4>=5
                  if(x1<=x2 && start1<=x1 && high1>=x2 && start2<=x1 && high2>=x2) {
                        result.add(new int[]{x1,x2});

                        if(high1>high2){
                            ++secondListIndex;
                        }else if(high1<high2){
                            ++firstListIndex;
                        }else{
                            ++firstListIndex;
                            ++secondListIndex;
                        }

                    }else{
                      if(high1>high2){
                          ++secondListIndex;
                      }else if(high1<high2){
                          ++firstListIndex;
                      }

                }
            }
                return result;

}
}
