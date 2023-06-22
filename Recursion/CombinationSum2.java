/*https://www.codingninjas.com/codestudio/problems/1112622?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.ArrayList;
import java.util.*;
public class Solution 
{
	// TC O(2^n) | SC O(n) recursion space
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(arr, 0, 0, target, res, temp);
        return res;
    }

    private static void helper(ArrayList<Integer> arr, int idx, int sum, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp){
        for(int i=idx;i<arr.size();i++){
            if(i==idx || arr.get(i-1) != arr.get(i)){
                temp.add(arr.get(i));
                if(sum+arr.get(i) == target) res.add(new ArrayList<>(temp));
                helper(arr, i+1, sum+arr.get(i), target, res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }



}
