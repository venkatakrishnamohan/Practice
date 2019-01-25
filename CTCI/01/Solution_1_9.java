import java.io.*;
import java.util.*;

class Solution_1_9{
    public boolean isSubstring(String s1, String s2){
        return s1.toLowerCase().contains(s2.toLowerCase());
    }
    public boolean isRotation(String s1, String s2){
        String snew = s2+s2;
        return isSubstring(snew, s1);
    }
    public void testTrue(){
        if(true == isRotation("waterbottle","erbottlewat")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testFalse(){
        if(false == isRotation("something","ingsomethin")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        if(true == isRotation("","")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        if(true == isRotation("a","a")){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_1_9 s = new Solution_1_9();
        s.testEmpty();
        s.testFalse();
        s.testOne();
        s.testTrue();
    }
}