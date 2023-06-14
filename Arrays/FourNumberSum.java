/*https://www.codingninjas.com/codestudio/problems/983605?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.io.*;
import java.util.* ;

public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      // Write your code here.
      Map<Integer, List<Integer[]>> map = new HashMap<>();
      Arrays.sort(arr);
      for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
          int sum = arr[i]+arr[j];
          if(map.containsKey(sum)){
            List<Integer[]> temp = map.get(sum);
            temp.add(new Integer[]{i, j});
            map.put(sum, temp);
          }else{
            List<Integer[]> temp = new ArrayList<>();
            temp.add(new Integer[]{i, j});
            map.put(sum, temp);
          }
        }
      }
      for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
          int currentSum = arr[i]+arr[j];
          int diff = target-currentSum;
          if(map.containsKey(diff)){
            List<Integer[]> pairs = map.get(diff);
            for(Integer[] pair: pairs){
              if(pair[0] != i && pair[0] != j && pair[1] != i && pair[1] != j){
                return "Yes";
              }
            }
          }
        }
      }
      return "No";
  }
}

