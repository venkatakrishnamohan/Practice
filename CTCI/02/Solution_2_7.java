import java.io.*;
import java.util.*;

class Solution_2_7{
    public boolean DoIntersect(LinkedList l1, LinkedList l2){
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        LLNode head1 = size1 >= size2 ? advance(l1,size1 - size2):advance(l2,size2 - size1);
        LLNode head2 = size1 >= size2 ? l2.head:l1.head;
        while(head1 !=null && head2 != null){
            if(head1 == head2){
                return true;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return false;
    }
    public int getLength(LinkedList l){
        LLNode curr = l.head;
        int count = 0;
        while(curr != null){
            count+=1;
            curr = curr.next;
        }
        return count;
    }
    public LLNode advance(LinkedList l, int k){
        LLNode curr = l.head;
        int count = 0;
        while(count < k){
            count+=1;
            curr = curr.next;
        }
        return curr;
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
    public void testTrue(){
        int[] a = new int[] {1,2,3};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {4,5,3,4};
        LinkedList l2 = createLinkedList(b);
        int[] c = new int[] {1,2,3};
        LinkedList l3 = createLinkedList(c);
        traverseEnd(l1).next = l3.head;
        traverseEnd(l2).next = l3.head;
        if(DoIntersect(l1,l2)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testFalse(){
        int[] a = new int[] {1,2,3};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {4,5,3,4};
        LinkedList l2 = createLinkedList(b);
        if(!DoIntersect(l1,l2)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        int[] a = new int[] {};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {};
        LinkedList l2 = createLinkedList(b);
        if(!DoIntersect(l1,l2)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        int[] a = new int[] {1};
        LinkedList l1 = createLinkedList(a);
        if(DoIntersect(l1,l1)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testTrue2(){
        int[] a = new int[] {1,2,3,4,6,7,8};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {4,5,3,4};
        LinkedList l2 = createLinkedList(b);
        int[] c = new int[] {1,2,3};
        LinkedList l3 = createLinkedList(c);
        traverseEnd(l1).next = l3.head;
        traverseEnd(l2).next = l3.head;
        if(DoIntersect(l1,l2)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_2_7 s = new Solution_2_7();
        s.testEmpty();
        s.testFalse();
        s.testOne();
        s.testTrue();
        s.testTrue2();
    }
}