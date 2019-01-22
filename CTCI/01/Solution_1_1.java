import java.io.*;
import java.util.*;

class Solution_1_1{
    public boolean isUnique(String s){
        /*Brute force approach is to look at every position and check for the remaining string for that particular character */
        /*Using a hashmap to keep track of the characters and their counts, If any of it goes greater than 1, it is not unique*/
        /*Using an array of constant size (128 for ascii charcters) to keep count*/
        int[] counts = new int[128];
        for(int i=0;i<s.length();i++){
            if(counts[(int)s.charAt(i)] > 0){
                return false;
            }
            counts[(int)s.charAt(i)] +=1;
        }
        return true;
    }
    public void testEmpty(){
        String s = "";
        if(true == isUnique(s)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public void testTrue(){
        String s = "abcdef";
        if(true == isUnique(s)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public void testDup(){
        String s = "racecar";
        if(false == isUnique(s)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public void testOne(){
        String s = "r";
        if(true == isUnique(s)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public void testNumbers(){
        String s = "12311";
        if(false == isUnique(s)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public static void main(String args[]){
        Solution_1_1 s = new Solution_1_1();
        s.testEmpty();
        s.testTrue();
        s.testDup();
        s.testOne();
        s.testNumbers();
    }
}