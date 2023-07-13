/*https://www.codingninjas.com/studio/problems/893000?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/

public class Solution {
	// TC O(n^2) | SC O(1)
    // public static int minCharsforPalindrome(String str) {
    //     //Write your code here
    //     int start = 0;
    //     int end = str.length()-1;
    //     int tempEnd = str.length()-1;
    //     while(start < end){
    //         if(str.charAt(start) == str.charAt(end)){
    //             start++;
    //             end--;
    //         }else{
    //             end = tempEnd-1;
    //             tempEnd = end;
    //             start = 0;
    //         }
    //     }
    //     return str.length()-tempEnd-1;
    // }

	// KMP Algorithm Use | TC O(2n) | SC O(2n)
    public static int minCharsforPalindrome(String str){
        String reverse = reverse(str);
        String newString = str+"$"+reverse;
        int[] patterns = buildPattern(newString);
        return str.length()-patterns[newString.length()-1];
    }

    private static int[] buildPattern(String str){
        int[] patterns = new int[str.length()];
        patterns[0] = 0;
        int idx = 1;
        int pIdx = 0;
        while(idx < str.length()){
            if(str.charAt(pIdx) == str.charAt(idx)){
                pIdx++;
                patterns[idx] = pIdx;
                idx++;
            }else{
                if(pIdx > 0)
                    pIdx = patterns[pIdx-1];
                else{
                    pIdx = 0;
                    idx++;
                }
            }
        }
        return patterns;
    }

    private static String reverse(String str){
        char[] arr = str.toCharArray();
        int start = 0;
        int end = str.length()-1;
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--; 
        }
        return new String(arr);
    }

}
