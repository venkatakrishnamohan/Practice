import java.io.*;
import java.util.*;

class Palindromeall{
    public List<List<String>> printPalindromeparts(String s){
        List<String> curr = new ArrayList<>();
        List<List<String>> res = new ArrayList<List<String>>();
        printPalindromepartsHelper(s,curr,res,0,s.length()-1);
        return res;
    }
    public void printPalindromepartsHelper(String s, List<String> curr, List<List<String>> res,int start, int end){
        if(start > end){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=end;i++){
            if(isPalindrome(s.substring(start,i+1))){
                curr.add(s.substring(start,i+1));
                printPalindromepartsHelper(s,curr,res,i+1,end);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public void testOne(){
        String s = "nitin";
        List<List<String>> res = printPalindromeparts(s);
        for(List<String> l: res){
            for(String st: l){
                System.out.print(st+" ");
            }
            System.out.println("");
        }
    }
    public static void main(String args[]){
        Palindromeall s = new Palindromeall();
        s.testOne();
    }
}