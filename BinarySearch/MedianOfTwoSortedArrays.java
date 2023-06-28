/*https://www.codingninjas.com/studio/problems/985294?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
public class Solution {
	// TC O(n+m) | SC O(n+m)
    // public static double median(int[] a, int[] b) {
    // 	// Write your code here.
    //     int n = a.length;
    //     int m = b.length;
    //     int arr[] = new int[n+m];
    //     int idx1 = 0;
    //     int idx2 = 0;
    //     int idx = 0;
    //     while(idx1 < n && idx2 < m){
    //         if(a[idx1] <= b[idx2]){
    //             arr[idx++] = a[idx1++];
    //         }else{
    //             arr[idx++] = b[idx2++];
    //         }
    //     }
    //     while(idx1 < n){
    //         arr[idx++] = a[idx1++];
    //     }
    //     while(idx2 < m){
    //         arr[idx++] = b[idx2++];
    //     }
    //     int count = n+m;
    //     return count%2 == 0 ? (arr[count/2]+arr[(count/2)-1])/2.0 : (double)arr[count/2]; 
    // }

	// TC O(n+m) | SC O(1)
    // public static double median(int a[], int b[]){
    //     int n = a.length;
    //     int m = b.length;
    //     int idx1 = 0;
    //     int idx2 = 0;
    //     int idx = 0;
    //     int val1 = 0;
    //     int count = n+m;
    //     while(idx1 < n && idx2 < m){
    //         int temp = 0;
    //         if(a[idx1] <= b[idx2]){
    //             temp = a[idx1];
    //             idx1++;
    //         }else{
    //             temp = b[idx2];
    //             idx2++;
    //         }
    //         if(count % 2 == 1) {
    //             if(idx == count/2) return temp;
    //         }else{
    //             if(idx+1 == count/2){
    //                 val1 = temp;
    //             }else if(idx == count/2) return (val1+temp)/2.0;
    //         }
    //         idx++;
    //     }
    //     while(idx1 < n){
    //         if(count % 2 == 1) {
    //             if(idx == count/2) return a[idx1];
    //         }else{
    //             if(idx+1 == count/2){
    //                 val1 = a[idx1];
    //             }else if(idx == count/2) return (val1+a[idx1])/2.0;
    //         }
    //         idx1++;
    //         idx++;
    //     }
    //     while(idx2 < m){
    //         if(count % 2 == 1) {
    //             if(idx == count/2) return b[idx2];
    //         }else{
    //             if(idx+1 == count/2){
    //                 val1 = b[idx2];
    //             }else if(idx == count/2) return (val1+b[idx2])/2.0;
    //         }
    //         idx2++;
    //         idx++;
    //     }

    //     return 0.0;
    // }
    
	// Binary Search | TC O(min(logn, logm) | SC O(1)
    public static double median(int a[], int b[]){
        // this if is needed, because we will get ArrayIndexOutOfBoundException if we don't have this
        if(a.length > b.length) return median(b, a);
        int low = 0;
        int high = a.length;
        int n = a.length;
        int m = b.length;
        int count = n+m;
        int midPoint = (n+m+1)/2;
        int l1=0, l2=0, r1=0, r2=0;   
        while(low <= high){
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;
            r2 = Integer.MAX_VALUE;
            int cnt1 = (low+high)/2;
            int cnt2 = midPoint - cnt1;
            if(cnt1 > 0) l1 = a[cnt1-1];
            if(cnt1 < n) r1 = a[cnt1];
            if(cnt2 > 0) l2 = b[cnt2-1];
            if(cnt2 < m) r2 = b[cnt2];
            if(l1 <= r2 && l2 <= r1) break;
            else if(l1 > r2) high = cnt1-1;
            else low = cnt1+1;
        }
        return count%2==0 ? (Math.min(r1, r2)+Math.max(l1, l2))/2.0 : (double)Math.max(l1, l2);
    }
}
