/*https://www.codingninjas.com/codestudio/problems/630526?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*;

public class Solution {
	// O(n) Time Complexity | O(1) Space
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long currSum = 0;
		long maxSum = 0;
		for(int i=0;i<arr.length;i++){
			currSum += arr[i];
			if(currSum < 0)
				currSum = 0;
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum < 0 ? 0 : maxSum;
	}

}

