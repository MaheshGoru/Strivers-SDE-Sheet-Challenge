/*https://www.codingninjas.com/codestudio/problems/1214628?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

public class Solution {
	// O(n+m) Time Complexity | O(n+m) Space Complexity
    // public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
    //     // Write your code here.
    //     int arr[] = new int[m+n];
    //     int idxOne = 0;
    //     int idxTwo = 0;
    //     int idx = 0;
    //     while(idxOne < m && idxTwo < n){
    //         if(arr1[idxOne] <= arr2[idxTwo]){
    //             arr[idx++] = arr1[idxOne++];
    //         }else{
    //             arr[idx++] = arr2[idxTwo++];
    //         }
    //     }
    //     while(idxOne < m){
    //         arr[idx++] = arr1[idxOne++];
    //     }
    //     while(idxTwo < n){
    //         arr[idx++] = arr2[idxTwo++];
    //     }
    //     return arr;
    // }

	// O(n+mlogn+m) Time Complexity | O(1) Space
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n){
        for(int i=0;i<n;i++){
            arr1[m+i] = arr2[i];
        }
        int len = m+n;
        int gap = (len/2) + (len%2);
        while(gap > 0){
            int left = 0;
            int right = left+gap;
            while(right < len){
                if(arr1[left] > arr1[right]){
                    int temp = arr1[left];
                    arr1[left] = arr1[right];
                    arr1[right] = temp;
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2)+(gap%2);
        }
        return arr1;
    }

}

