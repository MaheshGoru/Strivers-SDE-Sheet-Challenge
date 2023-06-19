/*https://www.codingninjas.com/codestudio/problems/892994?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.ArrayList;

public class Solution {
	// TC O(n^2) | SC O(1) 
	// public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
	// 	// Write your code here.
	// 	int longest = 0;
	// 	for(int i=0;i<arr.size();i++){
	// 		int curr = 1;
	// 		int tempK = arr.get(i) == 0 ? 1 : 0;
	// 		for(int j=i+1;j<arr.size();j++){
	// 			if(arr.get(j) == 0) tempK++;
	// 			if(tempK > k) break;
	// 			curr++;
	// 		}
	// 		longest = Math.max(curr, longest);
	// 	}
	// 	return longest;
	// }

	// Two pointer approach | TC O(n) | SC O(1)
	public static int longestSubSeg(ArrayList<Integer> arr, int n, int k){
		int i=0, j=0;
		for(i=0;i<n;i++){
			if(arr.get(i) == 0)
				k--;
			if(k<0 && arr.get(j++) == 0)
				k++;
		}
		return i-j;
	}
}
