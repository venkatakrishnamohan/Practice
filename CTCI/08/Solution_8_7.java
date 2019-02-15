import java.io.*;
import java.util.*;

class Solution_8_7{
    public void permDups(String s){
        String chosen = "";
        permDupsHelper(s,chosen);
    }
    public void permDupsHelper(String s, String chosen){
        if(s.length() == 0){
            System.out.println(chosen);
            return;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            chosen = chosen+c;
            s = s.substring(0,i)+s.substring(i+1,s.length());
            permDupsHelper(s,chosen);
            chosen = chosen.substring(0,chosen.length()-1);
            s = s.substring(0,i)+c+s.substring(i,s.length());
        }
        return;
    }
    public void testOne(){
        permDups("abc");
    }
    public static void main(String args[]){
        Solution_8_7 s = new Solution_8_7();
        s.testOne();
    }
}