/*https://www.codingninjas.com/codestudio/problems/893028?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(n^2) | SC O(1)
	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

	    // Write your code here.
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++){
			int start = i+1;
			int end = arr.length-1;
			while(start < end){
				int sum = arr[i]+arr[start]+arr[end];
				if(sum == K){
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(arr[i]);
					temp.add(arr[start]);
					temp.add(arr[end]);
					res.add(temp);
					while(start < end && arr[start] == arr[start+1]) start++;
					start++;
					while(end > start && arr[end] == arr[end-1]) end--;
					end--;
				}else if(sum < K){
					start++;
				}else{
					end--;
				}
			}
			while(i < arr.length-1 && arr[i] == arr[i+1]) i++;
		}
		return res;
	}

}

