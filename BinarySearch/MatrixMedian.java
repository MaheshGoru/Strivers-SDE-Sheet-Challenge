/*https://www.codingninjas.com/studio/problems/873378?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.*;

public class Solution
{
	// TC O(n*m log n*m) | SC O(n*m)
	// public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	// {
	// 	// Write your code here.
	// 	ArrayList<Integer> list = new ArrayList<>();
	// 	for(int i=0;i<matrix.size();i++){
	// 		for(int j=0;j<matrix.get(i).size();j++){
	// 			list.add(matrix.get(i).get(j));
	// 		}
	// 	}
	// 	Collections.sort(list);
	// 	return list.size() % 2 == 1 ? list.get(list.size()/2) : ((list.get(list.size()/2) + list.get((list.size()/2)-1))/2);
	// }

	// TC O(log(max) * n * logm) | SC O(1)
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix){
		int low = 1;
		int high = 100000;
		int n = matrix.size();
		int m = matrix.get(0).size();
		while(low <= high){
			int mid = (low+high)/2;
			int count = 0;
			for(int i=0;i<n;i++){
				count += countSmallerThanEqualToMid(matrix, i, mid);
			}
			if(count > (n*m)/2) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

	private static int countSmallerThanEqualToMid(ArrayList<ArrayList<Integer>> matrix, int row, int target){
		int low = 0;
		int high = matrix.get(row).size()-1;
		while(low <= high){
			int mid = (low+high)/2;
			if(matrix.get(row).get(mid) <= target) low = mid+1;
			else high = mid-1;
		}
		return low;
	}
}
