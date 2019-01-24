import java.io.*;
import java.util.*;

public class Solution_1_6{
    public String compress(String s){
        StringBuilder st = new StringBuilder();
        int count = 1;
        char previous_char = Character.MIN_VALUE;
        for(int i=0;i<s.length();){
            if(previous_char == Character.MIN_VALUE){
                st.append(s.charAt(i));
                previous_char = s.charAt(i);
                i++;
            }
            else if(previous_char == s.charAt(i)){
                count+=1;
                i++;
            }
            else{
                st.append(Integer.toString(count));
                count = 1;
                previous_char = Character.MIN_VALUE;
            }
        }
        if(previous_char != Character.MIN_VALUE){
            st.append(count);
        }
        String result  = st.toString();
        if(result.length() <= s.length()){
            return result;
        }
        return s;
    }
    public void testCompress(){
        if("a2b1c5a3".equals(compress("aabcccccaaa"))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testNotcompress(){
        if("abcde".equals(compress("abcde"))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        if("".equals(compress(""))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        if("a".equals(compress("a"))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testCompress2(){
        if("a2b2".equals(compress("aabb"))){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_1_6 s = new Solution_1_6();
        s.testCompress();
        s.testEmpty();
        s.testNotcompress();
        s.testCompress2();
        s.testOne();
    }
}