/*https://www.codingninjas.com/codestudio/problems/983635?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*;

public class Solution {
	// TC O(n ^ n * (log m) | SC O(n)
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
		ArrayList<String> res = new ArrayList<String>();
		String current = new String("");
		Set<String> dict = new HashSet<>();
		for(int i=0;i<dictionary.size();i++)
			dict.add(dictionary.get(i));
		helper(s, 0, dict, current, res);
		return res;
	}

	private static void helper(String s, int idx, Set<String> dict, String current,
	ArrayList<String> res){
		if(idx == s.length()){
			res.add(current);
			return;
		}

		for(int i=idx;i<s.length();i++){
			String temp = s.substring(idx, i+1);
			if(dict.contains(temp)){
				current = current.concat(temp);
				current = current.concat(" ");
				helper(s, i+1, dict, current, res);
				current = current.substring(0, current.length()-temp.length()-1);
			}
		}
	}
}
