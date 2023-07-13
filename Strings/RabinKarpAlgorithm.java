/*https://www.codingninjas.com/studio/problems/stringmatch-rabincarp_1115738?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf*/
import java.util.ArrayList;
import java.util.List;

public class Solution {
	// TC O(mn) | SC O(1)
    public static List< Integer > stringMatch(String text, String pattern){
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        int tIdx = 0;
        while(tIdx < text.length()){
            int pIdx = 0;
            int tempTIdx = tIdx;
            while(tempTIdx < text.length() && pIdx < pattern.length()){
                if(text.charAt(tempTIdx) != pattern.charAt(pIdx)) break;
                tempTIdx++;
                pIdx++;
            }
            if(pIdx == pattern.length()) res.add(tIdx+1);
            tIdx++;
        }
        return res;
    }


	static int prime = 101;
    static int q = 10000;

	// RabinKarp Algorithm | TC Avg O(n+m) Worst O(nm) | SC O(1)
    public static List< Integer > stringMatch(String text, String pattern){
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        if(pattern.length() > text.length()) return res;
        long pHash = calculateHash(pattern, 0, pattern.length()-1);
        long tHash = calculateHash(text, 0, pattern.length()-1);
        long power = 1;
        for(int i=0;i<pattern.length()-1;i++){
            power = (power * prime)%q;
        }
        int pIdx = 0;
        int idx = pattern.length()-1;
        while(idx < text.length()){
            if(idx-pIdx == (pattern.length()-1)){
                if(tHash == pHash && bothEqual(text, pIdx, idx, pattern)){
                    res.add(pIdx+1);
                }
                tHash = (tHash - ((text.charAt(pIdx)) * power)) % q;
                if(tHash < 0){
                    tHash += q;
                }
                tHash = (tHash * prime)%q;
                pIdx++;
            }else{
                idx++;
                if(idx < text.length())
                    tHash = (tHash + text.charAt(idx))%q;
            }
        }
        return res;
    }

    private static boolean bothEqual(String text, int start, int end, String pattern)
    {
        int idx = 0;
        while(idx < pattern.length()){
            if(text.charAt(start) != pattern.charAt(idx)) return false;
            idx++;
            start++;
        }
        return true;
    }
    private static long calculateHash(String s, int start, int end){
        long hash = 0;
        while(start <= end){
            hash = ((hash * prime) + s.charAt(start)) % q;
            start++;
        }
        return hash;
    }
}
