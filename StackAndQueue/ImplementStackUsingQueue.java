/*https://www.codingninjas.com/studio/problems/795152?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
public class Stack {

    // Define the data members.
    Queue<Integer> q1 ;
    Queue<Integer> q2 ;
    int current = 1;

    public Stack() {
        // Implement the Constructor.
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        current = 1;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        // Implement the getSize() function.
        return current == 1 ? q1.size() : q2.size();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
        return current == 1 ? q1.isEmpty() : q2.isEmpty();
    }

    public void push(int element) {
        // Implement the push(element) function.
        if(current == 1){
            q2.add(element);
            moveElements(q1, q2);
            current = 2;
        }else{
            q1.add(element);
            moveElements(q2, q1);
            current = 1;
        }
    }

    private void moveElements(Queue q1, Queue q2){
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
    }

    public int pop() {
        // Implement the pop() function.
        if(current == 1){
            return q1.isEmpty() ? -1 : q1.poll();
        } else{
            return q2.isEmpty() ? -1 : q2.poll();
        }
    }

    public int top() {
        // Implement the top() function.
        if(current == 1){
            return q1.isEmpty() ? -1 : q1.peek();
        } else{
            return q2.isEmpty() ? -1 : q2.peek();
        }
    }
}
