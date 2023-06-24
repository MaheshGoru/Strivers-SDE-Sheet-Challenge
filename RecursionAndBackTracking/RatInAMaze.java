/*https://www.codingninjas.com/codestudio/problems/758966?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(4^(m*n)) | SC O(m*n)
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = 0;
            }
        }
        visited[0][0] = 1;
        helper(maze, 0, 0, n, visited, res);
        return res;
    }

    private static void helper(int[][] maze, int row, int col, int n, int[][] visited, ArrayList<ArrayList<Integer>> res){
        if(row == n-1 && col == n-1){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    list.add(visited[i][j]);
                }
            }
            res.add(list);
            return;
        }
        int[][] delta = {{-1,0}, {0,1}, {1, 0}, {0,-1}};
        for(int i=0;i<4;i++){
            int rowIdx = row+delta[i][0];
            int colIdx = col+delta[i][1];
            if(rowIdx >= 0 && rowIdx < n && colIdx >= 0 && colIdx < n && maze[rowIdx][colIdx] == 1 && visited[rowIdx][colIdx] == 0){
                visited[rowIdx][colIdx] = 1;
                helper(maze, rowIdx, colIdx, n, visited, res);
                visited[rowIdx][colIdx] = 0;
            }
        }
    }
}
