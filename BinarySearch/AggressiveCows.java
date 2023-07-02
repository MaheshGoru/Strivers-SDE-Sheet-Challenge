/*https://www.codingninjas.com/studio/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTab=1*/
import java.util.*;
public class Solution {
	// Binary Search | TC O(n log n) | Sc O(1)
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length-1];
        while(low <= high){
            int mid = (low+high)/2;
            int cows = noOfCowsPlacedWithDistance(stalls, mid);
            if(cows < k) high = mid-1;
            else low = mid+1;
        }
        return high;
    }

    private static int noOfCowsPlacedWithDistance(int[] stalls, int distance){
        int count = 1;
        int prev = 0;
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-stalls[prev] >= distance){
                count++;
                prev = i;
            }
        }
        return count;
    }
}
