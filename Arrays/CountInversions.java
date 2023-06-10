/*https://www.codingninjas.com/codestudio/problems/count-inversions_615?leftPanelTab=1*/
import java.util.* ;
import java.io.*;
public class Solution {
	// O(n^2) Time Complexity | O(1) Space
    // public static long getInversions(long arr[], int n) {
    //     // Write your code here.
    //     long count = 0;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[i] > arr[j])
    //                 count++;
    //         }
    //     }
    //     return count;
    // }
	// O(nlogn) Time Complexity | O(n) space
    public static long getInversions(long arr[], int n){
       return mergeSort(arr, 0, n-1);
    }

    private static long mergeSort(long arr[], int left, int right){
        long count = 0;
        if(left < right){
            int mid = (left+right)/2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid+1, right);
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    private static long merge(long arr[], int left, int mid, int right){
        long newArr[] = new long[right-left+1];
        int idx1 = left;
        int idx2 = mid+1;
        int idx = 0;
        long count = 0;
        while(idx1 <= mid && idx2 <= right){
            if(arr[idx1] < arr[idx2]){
                newArr[idx++] = arr[idx1++];
            }else{
                newArr[idx++] = arr[idx2++];
                count = count + (mid-idx1+1);
            }
        }
        while(idx1 <= mid){
            newArr[idx++] = arr[idx1++];
        }
        while(idx2 <= right){
            newArr[idx++] = arr[idx2++];
        }
        for(int i=0;i<idx;i++){
            arr[left+i] = newArr[i];
        }
        return count;
    }
}
