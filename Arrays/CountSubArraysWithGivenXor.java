/*https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	// TC O(n ^ 2) | SC O(1)
	// public static int subarraysXor(ArrayList<Integer> arr, int x) {
	// 	// Write your code here.
	// 	int count = 0;
	// 	for(int i=0;i<arr.size();i++){
	// 		int xor = 0;
	// 		for(int j=i;j<arr.size();j++){
	// 			xor = xor ^ arr.get(j);
	// 			if(xor == x) count++;
	// 		}
	// 	}
	// 	return count;
	// }

	// TC O(n) | SC O(n)
	public static int subarraysXor(ArrayList<Integer> arr, int x){
		Map<Integer, Integer> map = new HashMap<>();
		int xr = 0;
		map.put(xr, 1);
		int cnt = 0;
		for(int i=0;i<arr.size();i++){
			xr = xr ^ arr.get(i);
			int xrn = xr ^ x;
			if(map.containsKey(xrn)){
				cnt += map.get(xrn);
			}

			if(map.containsKey(xr)){
				map.put(xr, map.get(xr)+1);
			}else{
				map.put(xr, 1);
			}
		}
		return cnt;
	}
}
