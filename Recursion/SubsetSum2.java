/*https://www.codingninjas.com/codestudio/problems/unique-subsets_3625236?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(2^n) | SC O(n) recursion space
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        uniqueSubsetsHelper(arr, 0, res, temp);
        return res;
    }

    private static void uniqueSubsetsHelper(int arr[], int idx, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i=idx;i<arr.length;i++){
            if(i==idx || arr[i-1] != arr[i]){
                temp.add(arr[i]);
                uniqueSubsetsHelper(arr, i+1, res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

}
