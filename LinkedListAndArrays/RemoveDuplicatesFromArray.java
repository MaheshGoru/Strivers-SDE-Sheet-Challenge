/*https://www.codingninjas.com/codestudio/problems/1102307?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.util.ArrayList;
public class Solution {
	// TC O(n) | SC O(1)
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		// Write your code here.
		int count = 1;
		int idx = 1;
		while(idx < n){
			if(!arr.get(idx-1).equals(arr.get(idx))){
				count++;
			}
			idx++;
		}
		return count;
	}
}
