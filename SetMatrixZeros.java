/*https://www.codingninjas.com/codestudio/problems/set-matrix-zeros_3846774?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.io.*;
import java.util.* ;

public class Solution {
    // O(n^3) Time Complexity | O(1) space
    // public static void setZeros(int matrix[][]) {
    //     // Write your code here..
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[i].length;j++){
    //             if(matrix[i][j] == 0){
    //                 for(int k=0;k<matrix[i].length;k++){
    //                     if(matrix[i][k] != 0) matrix[i][k] = -1;
    //                 }
    //                 for(int k=0;k<matrix.length;k++){
    //                     if(matrix[k][j] != 0) matrix[k][j] = -1;
    //                 }
    //             }
    //         }
    //     }
    //     for(int i=0;i< matrix.length;i++){
    //         for(int j=0;j<matrix[i].length;j++){
    //             if(matrix[i][j] == -1) matrix[i][j] = 0;
    //         }
    //     }
    // }

    // O(n^2) Time Complexity | O(m+n) space

    // public static void setZeros(int matrix[][]){
    //     Set<Integer> zeroRowNumbers = new HashSet<>();
    //     Set<Integer> zeroColNumbers = new HashSet<>();
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[i].length;j++){
    //             if(matrix[i][j] == 0){
    //                 zeroRowNumbers.add(i);
    //                 zeroColNumbers.add(j);
    //             }
    //         }
    //     }
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[i].length;j++){
    //             if(zeroRowNumbers.contains(i) || zeroColNumbers.contains(j))
    //                 matrix[i][j] = 0;
    //         }
    //     }
    // }

    // O(n^2) Time Complexity | O(1) space
    public static void setZeros(int matrix[][]){
        boolean isFirstRowHasZero = false;
        boolean isFirstColHasZero = false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0)
                isFirstColHasZero = true;
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0)
                isFirstRowHasZero = true;
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        for(int i=0;i<matrix.length;i++){
            if(isFirstColHasZero)
                matrix[i][0] = 0;
        }

        for(int i=0;i<matrix[0].length;i++){
            if(isFirstRowHasZero)
                matrix[0][i] = 0;
        }
    }

}
