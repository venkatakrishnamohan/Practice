import java.io.*;
import java.util.*;

class Solution_1_2{
    /*Brute force approach to check whether every character is present in the other string and also accounting for dups*/
    /*Building a hashmap to keep track of counts and decrementing them while looking in other string, at end hashmap should contain all zeros */
    /*Considering a constant size array*/
    public boolean arePerms(String s1, String s2){
        int[] counts = new int[128];
        for(int i=0;i<s1.length();i++){
            counts[(int)s1.charAt(i)]+=1;
        }
        for(int i=0;i<s2.length();i++){
            if(counts[(int)s2.charAt(i)] <= 0){
                return false;
            }
            counts[(int)s2.charAt(i)]-=1;
        }
        for(int i=0;i<128;i++){
            if(counts[i] != 0){
                return false;
            }
        }
        return true;
    }
    public void testEmpty(){
        if(true == arePerms("", "")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public void testFalse(){
        if(false == arePerms("abcd", "bcd")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public void testPerms(){
        if(true == arePerms("jhmtu", "mhutj")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public void testOne(){
        if(false == arePerms("a", "")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public void testNumerals(){
        if(true == arePerms("123ab", "b2a13")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase not passed");
        }
    }
    public static void main(String args[]){
        Solution_1_2 s = new Solution_1_2();
        s.testEmpty();
        s.testFalse();
        s.testNumerals();
        s.testOne();
        s.testPerms();
    }

}