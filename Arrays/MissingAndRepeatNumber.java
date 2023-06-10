/*https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution {

	// O(n) Time Complexity | O(1) space
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        long s = 0;
        long s2 = 0;
        for(int i=0;i<n;i++){
            s += arr.get(i);
            s2 += Math.pow(arr.get(i), 2);
        }
        long sn = (n*(n+1))/2;
        long sn2 = (n * (n+1) * ((2*n)+1)) / 6;
        long val1 = s-sn;
        long val2 = (s2-sn2) / val1;
        long x = (val1+val2)/2;
        long y = x - val1;
        return new int[]{(int)y, (int)x};
    }


}
