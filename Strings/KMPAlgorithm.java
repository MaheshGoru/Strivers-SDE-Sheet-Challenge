import java.util.*;
public class Solution {
    // TC O(nm) | SC O(1)
    // public static List< Integer > stringMatch(String text, String pattern) {
    //     // Write your code here.
    //     List<Integer> res = new ArrayList<>();
    //     int tIdx = 0;
    //     while(tIdx < text.length()){
    //         int pIdx = 0;
    //         int tempTIdx = tIdx;
    //         while(tempTIdx < text.length() && pIdx < pattern.length()){
    //             if(text.charAt(tempTIdx) != pattern.charAt(pIdx)) break;
    //             tempTIdx++;
    //             pIdx++;
    //         }
    //         if(pIdx == pattern.length()) res.add(tIdx+1);
    //         tIdx++;
    //     }
    //     return res;
    // }
	
	// KMP Algorithm | TC O(n+m) | SC O(1)
     public static List< Integer > stringMatch(String text, String pattern){
        List<Integer> res = new ArrayList<>();
        if(pattern.length() > text.length()) return res;
        int[] patternArr = buildPatternArr(pattern);
        int tIdx = 0;
        int pIdx = 0;
        while(tIdx < text.length()){
            if(text.charAt(tIdx) == pattern.charAt(pIdx)){
                tIdx++;
                pIdx++;
            }else if(pIdx > 0){
                pIdx = patternArr[pIdx-1];
            }else{
                pIdx = 0;
                tIdx++;
            }
            if(pIdx == pattern.length()) {
                res.add(tIdx-pIdx+1);
                pIdx = patternArr[pIdx-1];
            }
        }
        return res;
    }

    private static int[] buildPatternArr(String pattern){
        int j = 0;
        int i = 1;
        int[] arr = new int[pattern.length()];
        arr[0] = 0;
        while(i < pattern.length()){
            if(pattern.charAt(j) == pattern.charAt(i)){
                j++;
                arr[i] = j;
                i++;
            }else if (j > 0){
                j = arr[j-1];
            } else{
                arr[i] = 0;
                i++;
            }
        }
        return arr;
    }
}
