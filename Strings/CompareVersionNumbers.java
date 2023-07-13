/*https://www.codingninjas.com/studio/problems/1062582?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
public class Solution 
{
	// TC O(n+m) | SC O(1)
    public static int compareVersions(String a, String b) 
    {
        // Write your code here
        int aIdx = 0;
        int bIdx = 0;
        while(aIdx < a.length() && bIdx < b.length()){
            if(a.charAt(aIdx) == b.charAt(bIdx)){
                aIdx++;
                bIdx++;
            }else if(a.charAt(aIdx) < b.charAt(bIdx))
                return -1;
            else
                return 1;
        }
        while(aIdx < a.length()){
            if(a.charAt(aIdx) != '0' && a.charAt(aIdx) != '.') return 1;
            aIdx++;
        }
        while(bIdx < b.length()){
            if(b.charAt(bIdx) != '0' && b.charAt(bIdx) != '.') return -1;
            bIdx++;
        }
        return 0;
    }
}
