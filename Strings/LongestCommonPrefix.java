/*https://www.codingninjas.com/studio/problems/longest-common-prefix_628874?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf*/
public class Solution {
	// TC O(minLen.m) | SC O(1)
	// we have other approaches like divide and conquer and binary search and trie solutions on leetcode 
	// https://leetcode.com/problems/longest-common-prefix/editorial/
    public static String commonPrefix(String []arr,int n){
        //Write your code here
        int count = 0;
        boolean isCommonPrefixFound = false;
        while(!isCommonPrefixFound){
            if(count < arr[0].length()){
                char ch = arr[0].charAt(count);
                int i = 0;
                for(i=1;i<n;i++){
                    if(count >= arr[i].length() || ch != arr[i].charAt(count)){
                        isCommonPrefixFound = true;
                        break; 
                    }
                }
                if(i == n) count++;
            } else{
                isCommonPrefixFound = true;
            }
        }
        return count == 0 ? "-1" : arr[0].substring(0, count);
    }
}
