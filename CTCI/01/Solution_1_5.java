import java.io.*;
import java.util.*;

class Solution_1_5{
    public boolean oneInsert(String a, String b){
        int l = a.length();
        int j=0;
        boolean advanced = false;
        for(int i=0;i<l;){
            if(a.charAt(i) == b.charAt(j)){
                j++;
                i++;
            }
            else{
                if(!advanced){
                advanced = true;
                j++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public boolean oneEdit(String a, String b){
        boolean found = false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                if(found == false){
                    found = true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public boolean oneAway(String a, String b){
        if(a.length() == b.length()){
            return oneEdit(a,b);
        }
        else if(b.length() - a.length() == 1){
            return oneInsert(a,b);
        }
        else if(a.length() - b.length() == 1){
            return oneInsert(b,a);
        }
        else{
            return false;
        }
    }
    public void testALessB(){
        if(true == oneAway("pales","pale")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testBLessA(){
        if(true == oneAway("pale","ple")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEqual(){
        if(true == oneAway("pale","pale")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }   
    public void testEdit(){
        if(true == oneAway("pale","bale")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        if(true == oneAway("","")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        if(true == oneAway("p","b")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testFalse(){
        if(false == oneAway("tabes","bale")){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_1_5 s = new Solution_1_5();
        s.testALessB();
        s.testBLessA();
        s.testEdit();
        s.testEqual();
        s.testEmpty();
        s.testFalse();
        s.testOne();
    }
}