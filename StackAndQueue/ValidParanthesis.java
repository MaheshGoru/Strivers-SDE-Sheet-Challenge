/*https://www.codingninjas.com/studio/problems/795104?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
import java.util.Stack;
public class Solution {
	// TC O(n) | SC O(n)
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
            }
            else if(stack.isEmpty()) return false;
            else{
                char popCh = stack.pop();
                if(ch == ')' && popCh != '(') return false;
                if(ch == '}' && popCh != '{') return false;
                if(ch == '[' && popCh != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
