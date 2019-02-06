import java.io.*;
import java.util.*;

// One apprach is to insert elements in sorted order at the time of insertion, but this might not support normal stack operations.
// Another approach is to sort elements only when requested.

class Solution_3_5{
    Stack<Integer> s;
    public Solution_3_5(){
        s = new Stack<>();
    }
    public void push(int data){
        s.push(data);
    }
    public int pop(){
        return s.pop();
    }
    public int peek(){
        return s.peek();
    }
    // Similar to insertion sort
    public void sort(){
        Stack<Integer> s_new = new Stack<>();
        s_new.push(s.pop());
        while(!s.isEmpty()){
            int temp = s.pop();
            int count = 0;
            while(temp <= s_new.peek()){
                s.push(s_new.pop());
                count++;
            }
            s_new.push(temp);
            while(count >0){
                s_new.push(s.pop());
                count--;
            }
        }
        s = s_new;
    }
    public static void main(String args[]){
        Solution_3_5 s = new Solution_3_5();
        s.push(20);
        s.push(10);
        s.push(30);
        s.push(2);
        System.out.println(s.peek());
        s.sort();
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}