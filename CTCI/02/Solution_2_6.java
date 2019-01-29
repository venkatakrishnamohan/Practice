import java.io.*;
import java.util.*;

class Solution_2_6{
    public boolean isPalindrome(LinkedList l){
        Stack<Integer> s = new Stack<>();
        if(l.head == null){
            return true;
        }
        LLNode curr = l.head;
        LLNode fast = l.head;
        int count = 0;
        while(fast != null && fast.next != null){
            s.push(curr.data);
            curr = curr.next;
            fast = fast.next.next;
            count+=1;
        }
        if(fast != null){
            curr = curr.next;
        }
        while(curr != null){
            int d = s.pop();
            if(curr.data != d){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
    public LinkedList createLinkedList(int[] a){
        LinkedList ll = new LinkedList();
        for(int i=0;i<a.length;i++){
            ll.insert(a[i]);
        }
        return ll;
    }
    public void testPal(){
        int[] a = new int[] {1,2,2,1};
        LinkedList ll = createLinkedList(a);
        if(isPalindrome(ll)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testNotPal(){
        int[] a = new int[] {1,2,2,1,2};
        LinkedList ll = createLinkedList(a);
        if(!isPalindrome(ll)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        int[] a = new int[] {};
        LinkedList ll = createLinkedList(a);
        if(isPalindrome(ll)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        int[] a = new int[] {1};
        LinkedList ll = createLinkedList(a);
        if(isPalindrome(ll)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testPalOdd(){
        int[] a = new int[] {1,2,1,2,1};
        LinkedList ll = createLinkedList(a);
        if(isPalindrome(ll)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_2_6 s = new Solution_2_6();
        s.testEmpty();
        s.testOne();
        s.testPal();
        s.testPalOdd();
        s.testNotPal();
    }
}