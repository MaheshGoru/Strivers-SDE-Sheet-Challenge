/*https://www.codingninjas.com/studio/problems/696444?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.ArrayList;
import java.lang.StringBuffer;

public class Solution 
{
	// TC O(2n) | SC O(1)
	public static String reverseString(String str) 
	{
		//Write your code here
		StringBuffer s = new StringBuffer();
		int start = -1;
		int end = -1;
		boolean isFirstWord = true;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch == ' ' && start != -1){
				if(!isFirstWord) s.append(" ");
				isFirstWord = false;
				s.append(reverse(str, start, end));
				start = -1;
			}
			if(ch == ' ') continue;
			if(start == -1) start = i;
			end = i;
		}
		if(start != -1){
			if(!isFirstWord) s.append(" ");
			s.append(reverse(str, start, end));
		}
		return new String(reverse(s.toString(), 0, s.length()-1));
	}

	private static char[] reverse(String str, int start, int end){
		char[] arr = new char[end-start+1];
		int idx = 0;
		while(end >= start){
			arr[idx++] = str.charAt(end--);
		}
		return arr;
	}
	


}

