import java.io.*;
import java.util.*;

// Simple implementation with out any rollover.

public class Solution_3_3{
    List<Stack<Integer>> stack_list;
    int capacity;
    public Solution_3_3(int capacity){
        stack_list = new ArrayList<>();
        this.capacity = capacity;
    }
    public void push(int data){
        if(stack_list.size() == 0 || stack_list.get(stack_list.size()-1).size() == capacity){
            Stack<Integer> s = new Stack<>();
            stack_list.add(s);
        }
        stack_list.get(stack_list.size()-1).push(data);
    }
    public int pop(){
        int p =  stack_list.get(stack_list.size()-1).pop();
        if(stack_list.get(stack_list.size()-1).isEmpty()){
            stack_list.remove(stack_list.size()-1);
        }
        return p;
    }
    public int peek(){
        return stack_list.get(stack_list.size()-1).peek();
    }
    public int popAt(int stackNo){
        int p =  stack_list.get(stackNo).pop();
        if(stack_list.get(stackNo).isEmpty()){
            stack_list.remove(stackNo);
        }
        return p;
    }
    public static void main(String args[]){
        Solution_3_3 s = new Solution_3_3(3);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);
        s.push(80);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.popAt(1));
        System.out.println(s.popAt(1));
        System.out.println(s.popAt(1));
        System.out.println(s.popAt(1));
    }
}