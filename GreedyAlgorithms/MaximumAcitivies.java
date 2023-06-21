/*https://www.codingninjas.com/codestudio/problems/1062712?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.*;

class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

public class Solution {
	// TC O(nlogn) | SC O(1) 
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        List<Pair> times = new ArrayList<>();
        for(int i=0;i<start.size();i++){
            Pair p = new Pair(start.get(i), end.get(i));
            times.add(p);
        }
        Collections.sort(times, (a1, a2) -> (a1.end - a2.end));
        int idx = 1;
        int count = 1;
        int prev = times.get(0).end;
        while(idx < times.size()){
            if(times.get(idx).start >= prev){
                count++;
                prev = times.get(idx).end;
            }
            idx++;
        }
        return count;
    }
}
