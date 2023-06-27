/*https://www.codingninjas.com/studio/problems/1112654?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Solution
{
	// HashMap Approach | TC O(n) | SC O(n)
    // public static int singleNonDuplicate(ArrayList<Integer> arr)
    // {
    //     //    Write your code here.
    //     Map<Integer,Integer> countMap = new HashMap();
    //     for(int i=0;i<arr.size();i++){
    //         if(!countMap.containsKey(arr.get(i))){
    //             countMap.put(arr.get(i), 0);
    //         }
    //         countMap.put(arr.get(i), countMap.get(arr.get(i))+1);
    //     }
    //     for(int i=0;i<arr.size();i++){
    //         if(countMap.get(arr.get(i)) == 1)
    //             return arr.get(i);
    //     }
    //     return -1;
    // }

	// Xor Operator | TC O(n) | SC O(1)
    // public static int singleNonDuplicate(ArrayList<Integer> arr){
    //     int xor = 0;
    //     for(int i=0;i<arr.size();i++){
    //         xor = xor ^ arr.get(i);
    //     }
    //     return xor;
    // }

	// Binary Search | TC O(logn) | SC O(1)
    public static int singleNonDuplicate(ArrayList<Integer> arr){
        int low = 0;
        int high = arr.size()-1;
        while(low < high){
            int mid = (low+high)/2;
            if(mid % 2 == 0){
                if(arr.get(mid).equals(arr.get(mid+1))) low = mid+1;
                else high = mid;
            }else{
                if(arr.get(mid).equals(arr.get(mid-1))) low = mid+1;
                else high = mid-1;
            }
        }
        return arr.get(low);
    }


}
