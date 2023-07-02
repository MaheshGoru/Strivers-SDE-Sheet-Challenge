/*https://www.codingninjas.com/studio/problems/1112629?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
public class Solution {
	// TC O(k) | SC O(1)
    // public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
    //     // Write your code here.
    //     int idx = 0;
    //     int idx1 = 0;
    //     int idx2 = 0;
    //     while(idx1 < m && idx2 < n){
    //         int temp = 0;
    //         if(row1[idx1] <= row2[idx2]){
    //             temp = row1[idx1];
    //             idx1++;
    //         }else{
    //             temp = row2[idx2];
    //             idx2++;
    //         }
    //         if(idx+1 == k) return temp;
    //         idx++;
    //     }
    //     while(idx1 < m){
    //         if(idx+1 == k) return row1[idx1];
    //         idx++;
    //         idx1++;
    //     }
    //     while(idx2 < n){
    //         if(idx+1 == k) return row2[idx2];
    //         idx++;
    //         idx2++;
    //     }
    //     return 0;
    // }

	// TC O(min(logn, logm) | SC O(1)
    public static int ninjaAndLadoos(int a[], int b[], int n, int m, int k){
        if(n > m) return ninjaAndLadoos(b, a, m, n, k);
        int low = Math.max(0, k-n);
        int high = Math.min(k, m);
        int l1=0, l2=0, r1=0, r2=0;   
        while(low < high){
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;
            r2 = Integer.MAX_VALUE;
            int cnt1 = (low+high)/2;
            int cnt2 = k - cnt1;
            if(cnt1 > 0) l1 = a[cnt1-1];
            if(cnt1 < n) r1 = a[cnt1];
            if(cnt2 > 0) l2 = b[cnt2-1];
            if(cnt2 < m) r2 = b[cnt2];
            if(l1 <= r2 && l2 <= r1) break;
            else if(l1 > r2) high = cnt1-1;
            else low = cnt1+1;
        }
        return Math.max(l1, l2);
    }
}

