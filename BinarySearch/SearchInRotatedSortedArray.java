/*https://www.codingninjas.com/studio/problems/630450?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
public class Solution {
	// Binary Search | TC O(logn) | SC O(1)
    public static int search(int arr[], int key) {
        // Write your code here.
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high) / 2;
            if(arr[mid] == key) return mid;
            if(arr[low] <= arr[mid]){
                if(arr[low] <= key && key <= arr[mid]) high = mid-1;
                else low = mid+1;
            } else{
                if(arr[mid] <= key && key <= arr[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}
