/*https://www.codingninjas.com/studio/problems/roman-numeral-to-integer_981308?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf*/
import java.util.* ;
import java.io.*; 
public class Solution {
	// TC O(n) | SC O(1)
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int value = map.get(ch);
            if (prev < value) {
                total += value - 2 * prev;
            } else {
                total += value;
            }
            prev = value;
        }

        return total;
    }
}
