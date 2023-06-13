/*https://www.codingninjas.com/codestudio/problems/1081470?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// public static int uniquePaths(int m, int n) {
	// 	// Write your code here.
	// 	int dp[][] = new int[m][n];
	// 	for(int i=0;i<m;i++){
	// 		for(int j=0;j<n;j++){
	// 			dp[i][j] = -1;
	// 		}
	// 	}
	// 	return uniquePathsHelper(m-1, n-1, dp);
	// }

	// Recursion | Time Complexity O(2^(m*n)) | O(m+n) Space
	// private static int uniquePathsHelper(int m, int n){
	// 	if(m == 0 && n == 0) return 1;
	// 	if(m < 0 || n < 0) return 0;
	// 	int top = uniquePathsHelper(m-1, n);
	// 	int left = uniquePathsHelper(m, n-1);
	// 	return top+left;
	// }

	// Memoization | Time Complexity O(mn) | O(mn)+O(m+n) Space
	// private static int uniquePathsHelper(int m, int n, int[][] dp){
	// 	if(m == 0 && n == 0) return 1;
	// 	if(m < 0 || n < 0) return 0;
	// 	if(dp[m][n] != -1) return dp[m][n];
	// 	dp[m][n] = uniquePathsHelper(m-1, n, dp) + uniquePathsHelper(m, n-1, dp);
	// 	return dp[m][n];
	// }


	// BottomUp | Time Complexity O(mn) | O(mn) Space
	public static int uniquePaths(int m, int n){
		int dp[][] = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i == 0 && j==0) dp[i][j] = 1;
				else{
					if(i > 0) dp[i][j] += dp[i-1][j];
					if(j > 0) dp[i][j] += dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}

	// Combination Logic | TC O(m) | O(1) SC
	public static int uniquePaths(int m,int n){
		int N = m+n-2;
		int r = m-1;
		int res = 1;
		for(int i=1;i<=r;i++){
			res = res*(N-r+i)/i;
		}
		return res;
	}
}
