/*https://www.codingninjas.com/codestudio/problems/subset-sum_3843086?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(2^n * 2^n log 2^n) | SC O(n) recursion space
     public static ArrayList<Integer> subsetSum(int nums[]) {
        // Write your code here..
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        helper(0,0,n,nums,ans);
        Collections.sort(ans);
        return ans;
    }
    
    public static void helper(int st,int sum,int size,int []nums,List<Integer> ans){
        if(st>=size){
            ans.add(sum);
            return;
        }
        helper(st+1,sum+nums[st],size,nums,ans);
        helper(st+1,sum,size,nums,ans);
    }

}
