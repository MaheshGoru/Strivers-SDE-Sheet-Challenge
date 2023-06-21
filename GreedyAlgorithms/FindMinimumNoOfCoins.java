/*https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.* ;
import java.io.*; 
public class Solution
{
// TC O(n) | SC O(1)
public static int findMinimumCoins(int amount)
    {
        // Write your code here.
        int[] denominations = {1,2,5,10,20,50,100,500,1000};
        int count = 0;
        int idx = 8;
        while(amount > 0 && idx >= 0){
            count += amount/denominations[idx];
            amount = amount % denominations[idx];
            idx--;
        }
        return count;
    }
}

