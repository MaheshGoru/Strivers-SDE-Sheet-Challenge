/*https://www.codingninjas.com/codestudio/problems/759331?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.*;
public class Solution 
{
	// TC O(2^n) | SC O(n) Recursion space
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        // Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> temp = new ArrayList();
        helper(arr, n, k, 0, 0, temp, res);
        return res;
    }

    private static void helper(ArrayList<Integer> arr, int n, int K, int idx, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
        if(idx == n)
            return;
        temp.add(arr.get(idx));
        if(sum+ arr.get(idx) == K) res.add(new ArrayList<>(temp));
        helper(arr, n, K, idx+1, sum+arr.get(idx), temp, res);
        temp.remove(temp.size()-1);
        helper(arr, n, K, idx+1, sum, temp, res);
    }
}
