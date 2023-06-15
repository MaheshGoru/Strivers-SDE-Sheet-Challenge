/*https://www.codingninjas.com/codestudio/problems/893027?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;


public class Solution 
{
	// TC O(nlogn) | SC O(n)
    // public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    // {
    //     // Write your code here.
    //     int n = arr.size();
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for(int i=0;i<arr.size();i++){
    //         map.put(arr.get(i), map.getOrDefault(arr.get(i), 0)+1);
    //     }
    //     ArrayList<Integer> list = new ArrayList<>();
    //     for(Map.Entry<Integer, Integer> entry: map.entrySet()){
    //         if(entry.getValue() > n/3){
    //             list.add(entry.getKey());
    //         }
    //     }
    //     return list;
    // }
	// Moore's Voting Algorithm | TC O(n) | SC O(1)
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr){
        int n = arr.size();
        int count1 = 0;
        int count2 = 0;
        int elem1 = Integer.MIN_VALUE;
        int elem2 = Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++){
            int num = arr.get(i);
            if(count1 == 0 && num != elem2){
                count1 = 1;
                elem1 = num;
            }else if(count2 == 0 && num != elem1){
                count2 = 1;
                elem2 = num;
            }else if(elem1 == num){
                count1++;
            }else if(elem2 == num){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<arr.size();i++){
            if(elem1 == arr.get(i)) count1++;
            if(elem2 == arr.get(i)) count2++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if(count1 > n/3) list.add(elem1);
        if(count2 > n/3) list.add(elem2);
        return list;
    }
}
