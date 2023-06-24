/*https://www.codingninjas.com/codestudio/problems/758958?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// Using Backtracking | TC O(n! * n) | SC O(n) recursion space
    // public static List<String> findPermutations(String s) {
    //     // Write your code here.
    //     List<String> permutations = new ArrayList<>();
    //     helper(s.toCharArray(), 0, permutations);
    //     return permutations;
    // }

    // private static void helper(char[] s, int idx, List<String> permutations){
    //     if(idx == s.length){
    //         permutations.add(new String(s));
    //         return;
    //     }
    //     for(int i=idx;i<s.length;i++){
    //         swap(s, i, idx);
    //         helper(s, idx+1, permutations);
    //         swap(s, i, idx);
    //     }
    // }

    // private static void swap(char[] s, int pos1, int pos2){
    //     char temp = s[pos1];
    //     s[pos1] = s[pos2];
    //     s[pos2] = temp;
    // }

	// Using Recursion | TC O(n! * n) | SC O(3n)  
    public static List<String> findPermutations(String s) {
        // Write your code here.
        List<String> permutations = new ArrayList<>();
        boolean[] freq = new boolean[s.length()];
        List<Character> temp = new ArrayList<>();
        helper(s.toCharArray(), freq, temp, permutations);
        return permutations;
    }

    private static void helper(char[] s, boolean[] freq, List<Character> temp, List<String> permutations){
        if(temp.size() == s.length){
            StringBuffer newString = new StringBuffer();
            for(int i=0;i<temp.size();i++){
                newString.append(temp.get(i));
            }
            permutations.add(newString.toString());
            return;
        }

        for(int i=0;i<s.length;i++){
            if(!freq[i]){
                freq[i] = true;
                temp.add(s[i]);
                helper(s, freq, temp, permutations);
                temp.remove(temp.size()-1);
                freq[i] = false;
            }
        }
    }
}
