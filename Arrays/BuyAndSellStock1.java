/*https://www.codingninjas.com/codestudio/problems/893405?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution{
	// O(n) Time complexity | O(1) space complexity
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int mini = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<prices.size();i++){
            mini = Math.min(mini, prices.get(i));
            int diff = prices.get(i) - mini;
            maxProfit = Math.max(maxProfit, diff);
        }
        return maxProfit;
    }
}
