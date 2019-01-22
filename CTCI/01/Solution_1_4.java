import java.io.*;
import java.util.*;

class Solution_1_4{
    public boolean permPalindrome(String s){
        /*Check counts of characters, only one of it can be odd and the rest should be even*/
        /*Consider only ascii characters and ignore the case and spaces*/
        int[] counts = new int[128];
        s = s.toLowerCase();
        s = s.replaceAll("\\s+","");
        for(int i=0;i<s.length();i++){
            counts[(int)s.charAt(i)]+=1;
        }
        int odd = 0;
        for(int i=0;i<128;i++){
            if(counts[i]%2 !=0){
                odd+=1;
            }
        }
        if(odd > 1){
            return false;
        }
        return true;
    }
    public void testEmpty(){
        if(true == permPalindrome("")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public void testTrue(){
        if(true == permPalindrome("Tact Coa")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public void testFalse(){
        if(false == permPalindrome("Some   thing  ")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public void testOne(){
        if(true == permPalindrome("a")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public void testNumerals(){
        if(true == permPalindrome("121")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public static void main(String args[]){
        Solution_1_4 s = new Solution_1_4();
        s.testEmpty();
        s.testFalse();
        s.testNumerals();
        s.testOne();
        s.testTrue();
    }
}