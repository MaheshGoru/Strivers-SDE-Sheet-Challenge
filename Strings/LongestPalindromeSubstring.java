/*https://leetcode.com/problems/longest-palindromic-substring/submissions/991196518/*/
class Solution {
	// TC O(n^3) | SC O(1)
    // public String longestPalindrome(String s) {
    //     for(int length=s.length();length>=1;length--){
    //         for(int start=0;start<s.length()-length+1;start++){
    //             if(isPalindrome(s, start, start+length-1))
    //                 return s.substring(start, start+length);
    //         }
    //     }
    //     return "";
    // }

    // private boolean isPalindrome(String s, int start, int end)
    // {
    //     while(start < end){
    //         if(s.charAt(start) != s.charAt(end)) return false;
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }

	// TC O(n^2) | SC O(n^2) | DP
    // public String longestPalindrome(String s){
    //     boolean dp[][] = new boolean[s.length()][s.length()];
    //     int ansStart = 0;
    //     int ansEnd = 1;
    //     for(int i=0;i<s.length();i++){
    //         dp[i][i] = true;
    //         if(i != s.length()-1 && s.charAt(i) == s.charAt(i+1)){
    //             dp[i][i+1] = true;
    //             if(ansEnd-ansStart < 2){
    //                 ansStart = i;
    //                 ansEnd = i+2;
    //             }
    //         }
    //     }

    //     for(int length=3;length<=s.length();length++){
    //         for(int start=0;start<=s.length()-length;start++){
    //             if(s.charAt(start) == s.charAt(start+length-1)){
    //                 dp[start][start+length-1] = dp[start+1][start+length-2];
    //                 if(dp[start][start+length-1] && (ansEnd - ansStart) < length){
    //                     ansStart = start;
    //                     ansEnd = start+length;
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(ansStart, ansEnd);
    // }

	// TC O(n^2) | SC O(1) | Expand approach
    public String longestPalindrome(String s) {
        int[] ans = new int[]{0, 0};
        
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i, s);
            if (oddLength > ans[1] - ans[0] + 1) {
                int dist = oddLength / 2;
                ans[0] = i - dist;
                ans[1] = i + dist;
            }
            
            int evenLength = expand(i, i + 1, s);
            if (evenLength > ans[1] - ans[0] + 1) {
                int dist = (evenLength / 2) - 1;
                ans[0] = i - dist;
                ans[1] = i + 1 + dist;
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }
    
    private int expand(int i, int j, String s) {
        int left = i;
        int right = j;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

}

