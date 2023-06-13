/*https://www.codingninjas.com/codestudio/problems/1082146?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

public class Solution {
	// O(logn) TC | SC O(1)
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here.
        long ans = 1;
        long lx = (long)x;
        long lm = (long)m;
        while(n > 0){
            if(n%2 == 1){
                ans = (ans%lm * lx%lm);
                n -= 1;
            }else{
                lx = lx%lm * lx%lm;
                n /= 2;
            }
        }
        return (int)(ans % lm);
    }
}
