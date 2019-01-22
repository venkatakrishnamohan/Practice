import java.io.*;
import java.util.*;

class Solution_1_3{
    public String Urlify(String s, int len){
        /*Start from the end and replace, keep 2 pointers from end and len*/
        int i=s.length()-1;
        int j=len-1;
        char[] ch = s.toCharArray();
        while(j>=0){
            if(ch[j] == ' '){
                ch[i] = '0';
                ch[i-1] = '2';
                ch[i-2] = '%';
                i = i-3;
            }
            else{
                ch[i] = ch[j];
                i-=1;
            }
            j-=1;
        }
        return new String(ch);
    }
    public void testEmpty(){
        if("".equals(Urlify("",0))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testTrue(){
        if("Mr%20John%20Smith".equals(Urlify("Mr John Smith    ",13))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testNone(){
        if("Nothing".equals(Urlify("Nothing",7))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testSpace(){
        if("%20".equals(Urlify("   ",1))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_1_3 s = new Solution_1_3();
        s.testEmpty();
        s.testTrue();
        s.testNone();
        s.testSpace();
    }
}