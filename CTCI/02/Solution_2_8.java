import java.io.*;
import java.util.*;

class Solution_2_8{
    public LLNode DetectLoop(LinkedList l){
        LLNode curr = l.head;
        LLNode runner = l.head;
        while(runner!=null && runner.next !=null){
            // Advance the pointers first and the verify if they collide;
            curr = curr.next;
            runner = runner.next.next;
            if(curr == runner){
                break;
            }
        }
        if(runner == null || runner.next == null){
            return null;
        }
        else{
            curr = l.head;
            while(curr != runner){
                curr = curr.next;
                runner = runner.next;
            }
            return curr;
        }
    }
    public LinkedList createLinkedList(int[] a){
        LinkedList ll = new LinkedList();
        for(int i=0;i<a.length;i++){
            ll.insert(a[i]);
        }
        return ll;
    }
    public LLNode traverseEnd(LinkedList l){
        LLNode curr = l.head;
        while(curr.next != null){
            curr = curr.next;
        }
        return curr;
    }
    public void testLoop(){
        int[] a = new int[] {1,2,2,1,2,3,4};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {1,2};
        LinkedList l2 = createLinkedList(b);
        LLNode aLast = traverseEnd(l1);
        LLNode bLast = traverseEnd(l2);
        aLast.next = l2.head;
        bLast.next = aLast;
        if(aLast == DetectLoop(l1)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testNoLoop(){
        int[] a = new int[] {1,2,2,1,2,3,4};
        LinkedList l1 = createLinkedList(a);
        if(null == DetectLoop(l1)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        int[] a = new int[] {};
        LinkedList l1 = createLinkedList(a);
        if(null == DetectLoop(l1)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        int[] a = new int[] {1};
        LinkedList l1 = createLinkedList(a);
        LLNode aLast = traverseEnd(l1);
        aLast.next = aLast;
        if(aLast == DetectLoop(l1)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testLoop2(){
        int[] a = new int[] {1,2,3,4};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {1};
        LinkedList l2 = createLinkedList(b);
        LLNode aLast = traverseEnd(l1);
        LLNode bLast = traverseEnd(l2);
        aLast.next = l2.head;
        bLast.next = aLast;
        if(aLast == DetectLoop(l1)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_2_8 s = new Solution_2_8();
        s.testEmpty();
        s.testOne();
        s.testLoop();
        s.testLoop2();
        s.testNoLoop();
    }
}