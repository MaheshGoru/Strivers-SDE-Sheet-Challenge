/*https://www.codingninjas.com/codestudio/problems/job-sequencing-problem_1169460?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*; 
public class Solution
{
	// TC O(nlogn) | SC O(n)
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
        Arrays.sort(jobs, (a1, a2) -> a2[1] - a1[1]);
        int maxi = 0;
        for(int i=0;i<jobs.length;i++){
            maxi = Math.max(maxi, jobs[i][0]);
        }
        boolean[] map = new boolean[maxi];
        int idx = 0; 
        int count = 0;
        while(idx < jobs.length){
            int deadLine = jobs[idx][0];
            while(deadLine > 0 && map[deadLine-1]) deadLine--;
            if(deadLine > 0){
                map[deadLine-1] = true;
                count += jobs[idx][1];
            }
            idx++;
        }
        return count;
    }
}

