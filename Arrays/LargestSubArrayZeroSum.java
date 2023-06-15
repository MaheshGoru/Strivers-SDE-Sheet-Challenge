/*https://www.codingninjas.com/codestudio/problems/920321?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	// TC O(n^2) | SC O(1)
	// public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

	// 	// Write your code here.
	// 	int longest = 0;
	// 	int count = 0;
	// 	for(int i=0;i<arr.size();i++){
	// 		count = 0;
	// 		for(int j=i;j<arr.size();j++){
	// 			count += arr.get(j);
	// 			if(count == 0){
	// 				longest = Math.max(longest, j-i+1);
	// 			}
	// 		}
	// 	}
	// 	return longest;
	// }

	// TC O(n) | SC O(n)
	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr){
		int longest = 0;
		int sum = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.size();i++){
			sum += arr.get(i);
			if(sum == 0){
				longest = i+1;
			}else{
				if(map.containsKey(sum)){
					longest = Math.max(longest, i-map.get(sum));
				}else{
					map.put(sum, i);
				}
			}
		}
		return longest;
	}
}
