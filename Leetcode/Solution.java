import java.io.*;
import java.util.*;


class Solution {
    public List<String> letterCasePermutation(String S) {
        int index = 0;
        List<String> res = new ArrayList<>();
        letterCasePermutationHelper(S,index,res);
        return res;
    }
    public void letterCasePermutationHelper(String s, int index, List<String> res){
        if(index == s.length()){
            res.add(s);
            return;
        }
        if(Character.isLetter(s.charAt(index))){
            char prevc = s.charAt(index);
            char nc;
            if(Character.isUpperCase(prevc)){
                nc = Character.toLowerCase(prevc);
            }
            else{
                nc = Character.toUpperCase(prevc);
            }
            s = s.substring(0,index)+nc+s.substring(index+1, s.length());
            letterCasePermutationHelper(s,index+1,res);
            s = s.substring(0,index)+prevc+s.substring(index+1,s.length());
            letterCasePermutationHelper(s,index+1,res);
        }
        else{
            letterCasePermutationHelper(s,index+1,res);
        }
    }
    public void testOne(){
        System.out.println(letterCasePermutation("a1b2"));
    }
    public static void main(String args[]){
        Solution s = new Solution();
        s.testOne();
    }
}