import java.io.*;
import java.util.*;

class Solution_8_9{
    public void printParens(int n){
        int left = n;
        int right = n;
        printParensHelper(left,right,"");
    }
    public void printParensHelper(int left, int right, String chosen){
        if(left > right || left < 0 || right < 0){
            return;
        }
        if(left == 0 && right == 0){
            System.out.println(chosen);
            return;
        }
        chosen = chosen + "(";
        printParensHelper(left - 1, right, chosen);
        chosen = chosen.substring(0,chosen.length()-1);
        chosen = chosen + ")";
        printParensHelper(left, right-1, chosen);
        chosen = chosen.substring(0,chosen.length()-1);
    }
    public void testOne(){
        printParens(3);
    }
    public static void main(String args[]){
        Solution_8_9 s = new Solution_8_9();
        s.testOne();
    }
}