/*https://www.codingninjas.com/codestudio/problems/759332?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.ArrayList;
public class Solution {
	// TC Exponential O(n! * n) | SC O(n^2)
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        // Write your code here.
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                arr[i][j] = 0;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(0, n, arr, res);
        return res;
    }

    private static void helper(int idx, int n, int[][] arr, ArrayList<ArrayList<Integer>> res){
        if(idx == n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    temp.add(arr[i][j]);
            }
            res.add(temp);
            return;
        }

        for(int j=0;j<n;j++){
            if(isValid(arr, idx, j, n)){
                arr[idx][j] = 1;
                helper(idx+1, n, arr, res);
                arr[idx][j] = 0;
            }
        }

    }

    private static boolean isValid(int[][] arr, int row, int col, int n){
        // col check
        for(int i=0;i<row;i++){
            if(arr[i][col] == 1) return false;
        }
        // top diagonal
        int i=row-1, j=col-1;
        while(i >= 0 && j >= 0){
            if(arr[i][j] == 1) return false;
            i--;
            j--;
        }
        i = row-1;
        j = col+1;
        while(i >= 0 && j < n){
            if(arr[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }
}
