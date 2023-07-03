/*https://www.codingninjas.com/studio/problems/1112581?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.*;
import java.io.*;

public class Solution{
	// TC O(n) | SC O(n)
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(0);
        }
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr.get(i) <= s.peek()){
                s.pop();
            }
            int val = s.isEmpty() ? -1 : s.peek();
            s.push(arr.get(i));
            res.set(i, val);
        }
        return res;
    }
}
