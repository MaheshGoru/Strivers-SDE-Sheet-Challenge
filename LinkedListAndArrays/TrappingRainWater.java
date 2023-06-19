/*https://www.codingninjas.com/codestudio/problems/630519?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(n) | SC O(n)
    public static long getTrappedWater(long[] arr, int n) {
        // Write your code here.
        long[] rightMax = new long[n];
        long maxi = arr[n-1];
        for(int i=n-2;i>=0;i--){
            maxi = Math.max(maxi, arr[i]);
            rightMax[i] = maxi;
        }
        maxi = arr[0];
        long sum = 0;
        for(int i=1;i<n-1;i++){
            maxi = Math.max(maxi, arr[i]);
            sum += Math.min(maxi,rightMax[i])-arr[i];
        }
        return sum;
    }

	// Two pointer approach | TC O(n) | SC O(1)
    // public static long getTrappedWater(long[] height, int n){
    //     int left = 0;
    //     int right = n-1;
    //     long maxLeft = 0;
    //     long maxRight = 0;
    //     long count = 0;
    //     while(left < right){
    //         if(height[left] <= height[right]){
    //             if(height[left] >= maxLeft){
    //                 maxLeft = height[left];
    //             }else{
    //                 count += maxLeft - height[left];
    //             }
    //             left++;
    //         }else{
    //             if(height[right] >= maxRight){
    //                 maxRight = height[right];
    //             }else{
    //                 count += maxRight - height[right];
    //             }
    //             right--;
    //         }
    //     }
    //     return count;
    // }
}

