/*https://www.codingninjas.com/codestudio/problems/1112602?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution{
	// O(n) Time Complexity | O(n) Space
    // public static int findDuplicate(ArrayList<Integer> arr, int n){
    //     // Write your code here.
    //     Set<Integer> res = new HashSet<>();
    //     for(int i=0;i<arr.size();i++){
    //         if(res.contains(arr.get(i))) return arr.get(i);
    //         res.add(arr.get(i));
    //     }
    //     return -1;
    // }
    
	// O(n) Time Complexity | O(1) Space
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        int slow = arr.get(0);
        int fast = arr.get(0);
        do {
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        }while(slow != fast);
        fast = arr.get(0);
        while(slow != fast){
            slow = arr.get(slow);
            fast = arr.get(fast);
        }
        return fast;
    }
}

