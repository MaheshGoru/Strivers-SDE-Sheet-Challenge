/*https://www.codingninjas.com/codestudio/problems/758961?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
public class Solution {
	// TC O( 9 ^ n ^ 2) | SC O(n) recursion space 
	public static boolean isItSudoku(int matrix[][]) {

		// Write your code here.
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(matrix[i][j] == 0){
					for(int k=1;k<=9;k++){
						if(isValid(matrix, i, j, k)){
							matrix[i][j] = k;
							if(isItSudoku(matrix)) return true;
							matrix[i][j] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(int matrix[][], int row, int col, int val){
		for(int i=0;i<9;i++){
			if(i!=row && matrix[i][col] == val) return false;
		}
		for(int j=0;j<9;j++){
			if(j != col && matrix[row][j] == val) return false;
		}
		int rowIdx = (row/3) * 3;
		int colIdx = (col/3) * 3;
		for(int i=rowIdx;i<rowIdx+3;i++){
			for(int j= colIdx;j<colIdx+3;j++){
				if(i != row && j != col && matrix[i][j] == val) return false;
			}
		}
		return true;
	}

	
}

