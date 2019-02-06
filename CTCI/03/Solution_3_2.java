import java.io.*;
import java.util.*;

public class Solution_3_2{
    public Stack<Integer> s;
    public Stack<Integer> s_min;
    public Solution_3_2(){
        s = new Stack<>();
        s_min = new Stack<>();
    }
    public void push(int data){
        if(data < min()){
            s_min.push(data);
            s.push(data);
        }
        else{
            s.push(data);
        }
    }
    public int pop(){
        int p = s.pop() ;
        if(p == min()){
            return s_min.pop();
        }
        else{
            return p;
        }
    }
    public int min(){
        if(s_min.isEmpty()){
            return Integer.MAX_VALUE;
        }
        else{
            return s_min.peek();
        }
    }
    public static void main(String args[]){
        Solution_3_2 s = new Solution_3_2();
        s.push(10);
        s.push(5);
        s.push(20);
        System.out.println(s.min());
        s.pop();
        s.pop();
        System.out.println(s.min());
    }
}