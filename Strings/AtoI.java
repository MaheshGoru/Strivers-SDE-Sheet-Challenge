/*https://www.codingninjas.com/studio/problems/981270?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(n) | SC O(1)
    public static int atoi(String str) {
        // Write your code here.
        boolean isNegative = str.charAt(0) == '-';
        int total = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9'){
                total = total * 10 + ((int)ch-48);
            }
        }
        return isNegative ? -1 * total : total;
    }
}

