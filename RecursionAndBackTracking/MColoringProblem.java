/*https://www.codingninjas.com/codestudio/problems/981273?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(n ^ m) | SC O(n) 
	public static String graphColoring(int[][] mat, int m) {
		// Write your code here
		int[] colors = new int[mat.length];
		for(int i=0;i<colors.length;i++){
			colors[i] = -1;
		}
		boolean isValid = isColored(mat, 0, m, colors);
		return isValid ? "YES" : "NO";
	}

	private static boolean isColored(int[][] mat, int node, int m, int[] colors){
		if(node == mat.length)
			return true;
		for(int i=0;i<m;i++){
			if(isValid(mat, node, i, colors)){
				colors[node] = i;
				if(isColored(mat, node+1, m, colors)) return true;
				colors[node] = -1;
			}
		}
		return false;
	}

	private static boolean isValid(int[][] mat, int node, int color, int[] colors){
		for(int i=0;i<mat.length;i++){
			if(mat[node][i] == 1 && colors[i] == color) return false;
		}
		return true;
	}

	
}

