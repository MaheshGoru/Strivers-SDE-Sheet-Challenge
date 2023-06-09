/*https://www.codingninjas.com/codestudio/problems/631055?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.util.* ;
import java.io.*;
public class Solution
{
    public static void sort012(int[] arr)
    {
        //Write your code here
        int zeroIdx = 0;
        int twoIdx = arr.length-1;
        int idx = 0;
	// O(n) Time Complexity | O(1) Space
        while(idx <= twoIdx){
            if(arr[idx] == 0){
                swap(arr, zeroIdx, idx);
                zeroIdx++;
                idx++;
            }else if(arr[idx] == 1){
                idx++;
            }else{
                swap(arr, twoIdx, idx);
                twoIdx--;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
