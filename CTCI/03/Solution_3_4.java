import java.io.*;
import java.util.*;

class Solution_3_4{
    Stack<Integer> s1;
    Stack<Integer> s2;
    int top1;
    int top2;
    public Solution_3_4(){
        s1 = new Stack<>();
        s2 = new Stack<>();
        top1 = -1;
        top2 = -1;
    }
    //Empty conditions are ignored
    public void enqueue(int data){
        s1.push(data);
    }
    public int dequeue(){
        if(s2.isEmpty()){
            transfer(s1,s2);
        }
        return s2.pop();
    }
    public void transfer(Stack<Integer> s1, Stack<Integer> s2){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    public void peek(){
        if(s2.isEmpty()){
            transfer(s1,s2);
        }
        System.out.println(s2.peek());
    }
    public static void main(String args[]){
        Solution_3_4 s = new Solution_3_4();
        s.enqueue(10);
        s.enqueue(29);
        s.enqueue(30);
        s.peek();
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        s.peek();
    }
}