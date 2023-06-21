/*https://www.codingninjas.com/codestudio/problems/799400?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.*;
public class Solution {
    
	// TC O(nlogn) | SC O(1)
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);
        int aIdx = 1;
        int dIdx = 0;
        int curr = 1;
        int maxi = 1;
        while(aIdx < n){
            if(at[aIdx] <= dt[dIdx]){
                aIdx++;
                curr++;
            }else{
                curr--;
                dIdx++;
            }
            maxi = Math.max(maxi, curr);
        }
        return maxi;
    }
}
