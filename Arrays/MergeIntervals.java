/*https://www.codingninjas.com/codestudio/problems/699917?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*;
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
	// O(n log n) Time Complexity | O(n) space
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        Arrays.sort(intervals, (one, two) -> one.start <= two.start ? -1 : 1);
        List<Interval> result = new ArrayList<>();
        Interval curr = new Interval(intervals[0].start, intervals[0].finish);
        int idx = 1;
        while(idx < intervals.length){
            if(curr.finish >= intervals[idx].start){
                curr.finish = Math.max(intervals[idx].finish, curr.finish);
            }else{
                result.add(curr);
                curr = new Interval(intervals[idx].start, intervals[idx].finish);
            }
            idx++;
        }
        result.add(curr);
        return result;
    }
}

