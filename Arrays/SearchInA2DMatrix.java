/*https://www.codingninjas.com/codestudio/problems/980531?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.ArrayList;
public class Solution {
	// O(log m)+log(n) Time Complexity | O(1) Space
    // static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
    //     // Write your code here.
    //     int top = 0;
    //     int bottom = mat.size()-1;
    //     while(top <= bottom){
    //         int midRow = (top+bottom) / 2;
    //         if(mat.get(midRow).get(0) <= target && mat.get(midRow).get(mat.get(midRow).size()-1) >= target){
    //             return binarySearch(mat.get(midRow), target);
    //         }else if(mat.get(midRow).get(0) > target){
    //             bottom = midRow-1;
    //         }else{
    //             top = midRow+1;
    //         }
    //     }
    //     return false;
    // }

    // private static boolean binarySearch(ArrayList<Integer> array, int target){
    //     int left = 0;
    //     int right = array.size()-1;
    //     while(left <= right){
    //         int mid = (left+right)/2;
    //         if(array.get(mid) == target) return true;
    //         else if(array.get(mid) > target) right = mid-1;
    //         else left = mid+1;
    //     }
    //     return false;
    // }

	//Time Complexity O(log m*n) | O(1) Space
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target){
        int m = mat.size();
        int n = mat.get(0).size();
        int low = 0;
        int high = (m*n)-1;
        while(low <= high){
            int mid = (low+high)/2;
            int midElement = mat.get(mid/n).get(mid%n);
            if(midElement == target) return true;
            else if(midElement < target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}

