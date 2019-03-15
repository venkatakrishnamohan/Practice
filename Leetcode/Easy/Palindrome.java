import java.io.*;
import java.util.*;

class Palindrome{
    public String palindromeSubstring(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];

    // Size 1 substrings
        for(int i=0;i<s.length();i++){
            dp[i][i] = true;
        }
        int maxlength = 1;
        int start = 0;
    // Size 2 substrings
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxlength = 2;
            }
        }
    // Size > 2 substrings
        for(int i=3;i<=s.length();i++){
            for(int j=0;j<s.length()-i+1;j++){
                int end = j+i-1;
                if(s.charAt(j) == s.charAt(end) && dp[j+1][end-1]){
                    dp[j][end] = true;
                    if(i>maxlength){
                        start = j;
                        maxlength = i;
                    }
                }
            }
        }
        return s.substring(start,start+maxlength-1);
    }
    public void testOne(){
        String s = "forgeeksskeegfor";
        System.out.println(palindromeSubstring(s));
    }
    public static void main(String args[]){
        Palindrome s = new Palindrome();
        s.testOne();
    }
}