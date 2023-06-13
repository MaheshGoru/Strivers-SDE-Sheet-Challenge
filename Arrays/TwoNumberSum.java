/*https://www.codingninjas.com/codestudio/problems/pair-sum_697295?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.io.*;
import java.util.* ;

public class Solution{
	// TC O(n^2) | SC O(1)
    // public static List<int[]> pairSum(int[] arr, int s) {
    //     // Write your code here.
    //     List<int[]> res = new ArrayList<>();
    //     for(int i=1;i<arr.length;i++){
    //         for(int j=0;j<i;j++){
    //             if(arr[j]+arr[i] == s){
    //                 res.add(new int[]{Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])});
    //             }
    //         }
    //     }
    //     Collections.sort(res, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
    //     return res;
    // }

 // Hasing | TC O(n logn) | SC O(1)
    public static List<int[]> pairSum(int[] arr, int s){
        List<int[]> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int diff = s - arr[i];
            if(map.containsKey(diff)){
                for(int j=0;j<map.get(diff);j++){
                    res.add(new int[]{Math.min(diff, arr[i]), Math.max(diff, arr[i])});
                }
            }
            int val = 0;
            if(map.containsKey(arr[i])) val = map.get(arr[i]);
            map.put(arr[i], val+1);
        }
        Collections.sort(res, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        return res;
    }
}

