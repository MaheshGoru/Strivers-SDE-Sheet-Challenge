/*https://www.codingninjas.com/studio/problems/799482?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=2*/
import java.util.*;
public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> s1;
    Stack<Integer> s2;
    Queue() {
        // Initialize your data structure here.
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        while(!s1.isEmpty()){
            s2.add(s1.pop());
        }
        s2.add(val);
        while(!s2.isEmpty()){
            s1.add(s2.pop());
        }
    }

    int deQueue() {
        // Implement the dequeue() function.
        
        return s1.size() == 0 ? -1 : s1.pop(); 
    }

    int peek() {
        // Implement the peek() function here.
        return s1.size() == 0 ? -1 : s1.peek();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        return s1.size() == 0;
    }
}
