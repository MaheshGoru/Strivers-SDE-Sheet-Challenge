/*https://www.codingninjas.com/studio/problems/look-and-say-sequence_668478?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0*/
public class Solution {
	// TC O(2^n) | SC O(1) | Time Explanation in above url solutions section is very good
	public static String lookAndSaySequence(int n) {
		// Write your code here.
		String s = "1";
		for(int i=2;i<=n;i++){
			StringBuffer newS = new StringBuffer();
			char[] charArr = s.toCharArray();
			int idx = 0;
			for(int j=1;j<charArr.length;j++){
				if(charArr[j-1] != charArr[j]){
					int count = j-idx;
					newS.append(""+count+""+charArr[j-1]);
					idx = j;
				}
			}
			newS.append(""+(charArr.length-idx)+""+charArr[charArr.length-1]);
			s = newS.toString();
		}
		return s;
	}
}
