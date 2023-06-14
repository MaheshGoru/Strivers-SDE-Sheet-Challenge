/*https://www.codingninjas.com/codestudio/problems/1112652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution
{
	// TC O(n^2) | SC O(1)
    // public static int reversePairs(ArrayList<Integer> arr)
    // {
    //     // Write your code here.
    //     int count = 0;
    //     for(int i=1;i<arr.size();i++){
    //         for(int j=0;j<i;j++){
    //             if((arr.get(i) * 2) < arr.get(j)) count++;
    //         }
    //     }
    //     return count;
    // }

	// Merge procedure | TC O(n log n) | SC O(n)
    public static int reversePairs(ArrayList<Integer> arr){
        return mergeSort(arr, 0, arr.size()-1);
    }

    private static int mergeSort(ArrayList<Integer> arr, int start, int end){
        int count = 0;
        if(start < end){
            int mid = (start+end) / 2;
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid+1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }

    private static int merge(ArrayList<Integer> arr, int start, int mid, int end){
        int[] newArr = new int[end-start+1];
        int idx1 = start;
        int idx2 = mid+1;
        int idx = 0;
        int count = 0;
        while(idx1 <= mid && idx2 <= end){
            if(arr.get(idx1) < arr.get(idx2)){
                newArr[idx++] = arr.get(idx1);
                idx1++;
            }else{
                newArr[idx++] = arr.get(idx2);
                idx2++;
            }
        }
        while(idx1 <= mid){
            newArr[idx++] = arr.get(idx1);
            idx1++;
        }
        while(idx2 <= end){
            newArr[idx++] = arr.get(idx2);
            idx2++;
        }
        idx1 = start;
        idx2 = mid+1;
        while(idx1 <= mid && idx2 <= end){
            if(arr.get(idx1) > 2*arr.get(idx2)){
                idx2++;
            }else{
                count += (idx2-mid-1);
                idx1++;
            }
        }
        if(idx1 <= mid){
            count += (mid-idx1+1) * (end-mid);
        }
        idx = 0;
        for(int i=start;i<=end;i++){
            arr.set(i, newArr[idx++]);
        }
        return count;
    }
}
