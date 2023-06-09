/*https://www.codingninjas.com/codestudio/problems/893046?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
	// O(n) Time Complexity | O(1) Space
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation)
	{
		// Write your code here.
		boolean isNextPermutationFound = false;
		for(int i=permutation.size()-2;i>=0;i--){
			if(permutation.get(i) < permutation.get(i+1)){
				int nextHighestIdx = findSmallest(permutation, i);
				swap(permutation, i, nextHighestIdx);
				reverse(permutation, i+1, permutation.size()-1);
				isNextPermutationFound = true;
				break;
			}
		}
		if(!isNextPermutationFound){
			reverse(permutation, 0, permutation.size()-1);
		}
		return permutation;
	}

	private static int findSmallest(ArrayList<Integer> permutation, int idx){
		int minIdx = idx;
		int tempIdx = permutation.size() -1 ;
		// while(tempIdx > idx){
		// 	if(permutation.get(idx) < permutation.get(tempIdx)){
		// 		minIdx = tempIdx;
		// 		break;
		// 	}
		// 	tempIdx--;
		// }
		int start = idx+1;
		int end = tempIdx;
		while(start <= end){
			int mid = (start+end) / 2;
			if(permutation.get(mid) >= permutation.get(idx)){
				start = mid+1;
				minIdx = mid;
			}else{
				end = mid-1;
			}
		}
		return minIdx;
	}
	private static void reverse(ArrayList<Integer> permutation, int start, int end){
		while(start < end){
			swap(permutation, start, end);
			start++;
			end--;
		}
	}
	private static void swap(ArrayList<Integer> permutation, int i, int j){
		int temp = permutation.get(i);
		permutation.set(i, permutation.get(j));
		permutation.set(j, temp);
	}
}

