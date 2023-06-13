/*https://www.codingninjas.com/codestudio/problems/842495?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.io.*;
import java.util.* ;

public class Solution {
	// O(n*logn) Time Complexity | O(n) Space
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
		Map<Integer, Integer> countMap = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(!countMap.containsKey(arr[i])) countMap.put(arr[i], 0);
			countMap.put(arr[i], countMap.get(arr[i])+1);
			if(countMap.get(arr[i]) > (n/2)) return arr[i];
		}
		return -1;
	}
	// Moor's Voting Algorithm | TC O(n) | SC O(1)
	public static int findMajority(int[] arr, int n){
		int count = 0;
		int elem = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(count == 0){
				elem = arr[i];
				count++;
			}else if(elem == arr[i]){
				count++;
			}
			else if(elem != arr[i]){
				count--;
			}
		}
		count = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == elem) count++;
			if(count > n/2) return arr[i];
		}
		return -1;
	}
}
