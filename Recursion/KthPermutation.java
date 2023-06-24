/*https://www.codingninjas.com/codestudio/problems/1112626?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.*;

public class Solution {
	// TC O(n!*n + n! log n!) | SC O(n!*n)+O(n) recursion space
    // public static String kthPermutation(int n, int k) {
    //     // Write your code here.
    //     List<String> permutations = new ArrayList<>();
    //     int[] arr = new int[n];
    //     for(int i=0;i<n;i++){
    //         arr[i] = i+1;
    //     }
    //     helper(0, arr, permutations);
    //     Collections.sort(permutations);
    //     return permutations.get(k-1);
    // }

    // private static void helper(int idx, int[] arr, List<String> permutations){
    //     if(idx == arr.length){
    //         StringBuffer s = new StringBuffer();
    //         for(int i=0;i<arr.length;i++){
    //             s.append((char)(arr[i]+48));
    //         }
    //         permutations.add(s.toString());
    //     }
    //     for(int i=idx;i<arr.length;i++){
    //         swap(arr, i, idx);
    //         helper(idx+1, arr, permutations);
    //         swap(arr, i, idx);
    //     }
    // }

    // private static void swap(int[] arr, int pos1, int pos2){
    //     int temp = arr[pos1];
    //     arr[pos1] = arr[pos2];
    //     arr[pos2] = temp;
    // }

	// TC O(n^2) | SC O(n)
    public static String kthPermutation(int n, int k) {
        // Write your code here.
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            list.add(i);
            fact = fact * i;
        }
        list.add(n);
        StringBuffer s = new StringBuffer();
        k = k-1;
        while(true){
            int pos = k/fact;
            s.append(list.get(pos));
            list.remove(pos);
            if(list.size() == 0) break;
            k = k%fact;
            fact = fact / list.size();
        }
        return s.toString();
    }
}
