/*https://www.codingninjas.com/codestudio/problems/975286?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
	// O(n log n) | SC O(1)
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
			Arrays.sort(items, (a1, a2) -> {
				double ratio1 = (double)(a2.value) / (double)a2.weight;
				double ratio2 = (double)(a1.value) / (double)a1.weight;
				if(ratio2 < ratio1) return 1;
				if(ratio2 > ratio1) return -1;
				else return 0;
			});
			double maximumValue = 0;
			for(int i=0;i<n;i++){
				if(w >= items[i].weight){
					maximumValue += items[i].value;
					w -= items[i].weight;
				}else{
					maximumValue += ((double)(items[i].value)/items[i].weight)*w;
					w = 0;
				}
				if(w == 0)
					break;
			}
			return maximumValue;
    }
}

