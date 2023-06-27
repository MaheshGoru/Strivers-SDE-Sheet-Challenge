/*https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
public class Solution {
	// TC O(n * log m) | SC O(1)
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 1;
        int high = m;
        while(low <= high){
            int mid = (low+high) / 2;
            long ans = 1;
            boolean flag = false;
            for(int i=1;i<=n;i++){
                ans = ans * mid;
                if(ans > m) {
                    high = mid-1;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                if(ans == m) return mid;
                else if(ans < m) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }

private static double multiply(double number, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans; 
    }
	// printing upto 6 decimals | TC O(n * log (m * 10 ^ d)) | SC O(1)  
    private static void getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-7; 
        
        while((high - low) > eps) {
            double mid = (low + high) / 2.0; 
            if(multiply(mid, n) < m) {
                low = mid; 
            }
            else {
                high = mid; 
            }
        }
        
        System.out.println(n+"th root of "+m+" is "+low);  
        
    }
}

