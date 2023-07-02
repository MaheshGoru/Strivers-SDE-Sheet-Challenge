/*https://www.codingninjas.com/studio/problems/ayush-gives-ninjatest_1097574?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*;
public class Solution {
	// Binary Search | TC O(mlog sum(times)) | SC O(1) 
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // Write your code here.
        long total = 0;
        for(int i=0;i<m;i++)
            total += time[i];
        long low = 0;
        long high = total;
        while(low <= high){
            long mid = low+(high-low)/2;
            long days = daysRequiredWithGivenHours(mid, time, m, n);
            if(days <= n)
                high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    private static long daysRequiredWithGivenHours(long days, int[] time, int m, int n){
        long tot = 0;
        long count = 0;
        for(int i=0;i<m;i++){
            if(time[i] > days)
                return n+1;
            count += time[i];
            if(count > days){
                tot++;
                count = time[i];
            }
        }
        return tot+1;
    }
}
