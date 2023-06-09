/*https://www.codingninjas.com/codestudio/problems/981260?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	// O(n) Time Complexity | O(n) Space complexity
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
         int upRow = 0;
        int leftCol = 0;
        int downRow = mat.size() - 1;
        int rightCol = mat.get(0).size() - 1;

        while (upRow < downRow && leftCol < rightCol) {
            int temp = mat.get(upRow).get(leftCol);  // Save the first element of the current loop

            // Shift elements from left to right
            for(int row=upRow; row < downRow;row++){
                mat.get(row).set(leftCol, mat.get(row+1).get(leftCol));
            }

            for(int col=leftCol; col < rightCol;col++){
                mat.get(downRow).set(col, mat.get(downRow).get(col+1));
            }

            for(int row=downRow; row > upRow; row--){
                mat.get(row).set(rightCol, mat.get(row-1).get(rightCol));
            }

            for(int col=rightCol; col > leftCol; col--){
                mat.get(upRow).set(col, mat.get(upRow).get(col-1));
            }
            mat.get(upRow).set(leftCol+1, temp);
            upRow++;
            leftCol++;
            downRow--;
            rightCol--;
        }
    }
}

