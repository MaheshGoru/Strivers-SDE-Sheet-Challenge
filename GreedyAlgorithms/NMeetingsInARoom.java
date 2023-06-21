/*https://www.codingninjas.com/codestudio/problems/1062658?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(n log n) | SC O(1)
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> input = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(start[i]);
            temp.add(end[i]);
            temp.add(i+1);
            input.add(temp);
        }
        Collections.sort(input, (a1, a2) -> (a1.get(1) != a2.get(1)) ? (a1.get(1) - a2.get(1)) : (a1.get(2) - a2.get(2)));
        int idx = 1;
        res.add(input.get(0).get(2));
        int prev = input.get(0).get(1);
        while(idx < start.length){
            if(prev < input.get(idx).get(0)){
                res.add(input.get(idx).get(2));
                prev = input.get(idx).get(1);
            }
            idx++;
        }
        return res;
    }
}
