/*https://www.codingninjas.com/studio/problems/1172164?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(n) | SC O(n)
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        char[] freq = new char[26];
        for(int i=0;i<str1.length();i++){
            freq[str1.charAt(i)-'a']++;
        }
        for(int i=0;i<str2.length();i++){
            freq[str2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}
