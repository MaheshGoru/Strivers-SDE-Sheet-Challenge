/*https://www.codingninjas.com/codestudio/problems/759408?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.io.*;
import java.util.* ;

public class Solution {
	// TC O(nlogn) | SC O(1)
    // public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
    //     // Write your code here.
    //     Arrays.sort(arr);
    //     int count = 1;
    //     int max = 1;
    //     int prev = arr[0];
    //     for(int i=1;i<N;i++){
    //         if(prev == arr[i]) continue;
    //         if(prev+1 == arr[i]){
    //             count++;
    //             max = Math.max(max, count);
    //         }else count=1;
    //         prev = arr[i];
    //     }
    //     return max;
    // }

	// TC O(n) | SC O(n)
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N){
        Set<Integer> hashSet = new HashSet<>();
        for(int num: arr){
            hashSet.add(num);
        }
        int maxi = 0;
        for(int i=0;i<arr.length;i++){
            if(!hashSet.contains(arr[i]-1)){
                int curr = 0;
                int currVal = arr[i];
                while(hashSet.contains(currVal)){
                    currVal++;
                    curr++;
                }
                maxi = Math.max(maxi, curr);
            }
        }
        return maxi;
    }
}
