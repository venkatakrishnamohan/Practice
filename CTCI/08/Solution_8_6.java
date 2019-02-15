import java.io.*;
import java.util.*;

class Solution_8_6{
    public Stack<Integer> tHanoii(){
        Stack<Integer> p = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> d = new Stack<>();
        p.push(3);
        p.push(2);
        p.push(1);
        moveDisks(3,p,d,b);
        return d;
    } 
    public void moveTop(Stack<Integer> a, Stack<Integer> b){
        int top = a.pop();
        b.push(top);
    }
    public void moveDisks(int n, Stack<Integer> p, Stack<Integer> d, Stack<Integer> b){
        if(n>0){
            moveDisks(n-1, p, b, d);
            moveTop(p,d);
            moveDisks(n-1, b, d, p);
        }
    }
    public void testOne(){
        Stack<Integer> res = tHanoii();
        System.out.println(res.pop());
    }
    public static void main(String args[]){
        Solution_8_6 s = new Solution_8_6();
        s.testOne();
    }
}