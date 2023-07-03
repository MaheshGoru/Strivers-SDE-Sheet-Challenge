/*https://www.codingninjas.com/studio/problems/799354?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*; 
import java.util.*;
public class Solution {
	// TC O(n^2) | SC O(1)	
	// public static int[] nextGreater(int[] arr, int n) {	
	// 	//Write Your code here
	// 	int[] res = new int[n];
	// 	for(int i=0;i<n;i++){
	// 		res[i] = -1;
	// 		for(int j=i+1;j<n;j++){
	// 			if(arr[j] > arr[i]){
	// 				res[i] = arr[j];
	// 				break;
	// 			}
	// 		}
	// 	}
	// 	return res;
	// }

	// TC O(n) | SC O(1)
	public static int[] nextGreater(int[] arr, int n){
		Stack<Integer> s = new Stack<>();

		int[] res = new int[n];
		s.push(-1);
		for(int i=n-1;i>=0;i--){
			if(s.isEmpty()){
				res[i] = -1;
			}else{
				while(!s.isEmpty() && s.peek() <= arr[i]){
					s.pop();
				}
				res[i] = s.isEmpty() ? -1 : s.peek();
				s.push(arr[i]);
			}
		}
		return res;
	}

}

