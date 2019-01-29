import java.io.*;
import java.util.*;

class Solution_2_5{
    public LinkedList sumListBackward(LinkedList l1, LinkedList l2){
        if(l1.head == null && l2.head==null){
            return null;
        }
        if(l1.head == null){
            return l2;
        }
        else if(l2.head == null){
            return l1;
        }
        else{
            LLNode l1curr = l1.head;
            LLNode l2curr = l2.head;
            int carry = 0;
            int sum = 0;
            LinkedList lres = new LinkedList();
            while(l1curr != null && l2curr != null){
                sum = carry + l1curr.data + l2curr.data;
                carry = sum / 10;
                sum = sum % 10;
                lres.insert(sum);
                l1curr = l1curr.next;
                l2curr = l2curr.next;
            }
            while(l1curr != null){
                sum = carry + l1curr.data ;
                carry = sum / 10;
                sum = sum % 10;
                lres.insert(sum);
                l1curr = l1curr.next;
            }
            while(l2curr !=null){
                sum = carry + l2curr.data ;
                carry = sum / 10;
                sum = sum % 10;
                lres.insert(sum);
                l2curr = l2curr.next;
            }
            if(carry !=0){
                lres.insert(carry);
            }
            return lres;
        }
    }
    public LinkedList createLinkedList(int[] a){
        LinkedList ll = new LinkedList();
        for(int i=0;i<a.length;i++){
            ll.insert(a[i]);
        }
        return ll;
    }
    public void testNocarry(){
        int[] a = new int[] {7,1,6};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {5,9,2};
        LinkedList l2 = createLinkedList(b);
        int[] ans = new int[] {2,1,9};
        LinkedList res = sumListBackward(l1,l2);
        List<Integer> l = res.printData();
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testCarry(){
        int[] a = new int[] {2,9,5};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {2,0,5};
        LinkedList l2 = createLinkedList(b);
        int[] ans = new int[] {4,9,0,1};
        LinkedList res = sumListBackward(l1,l2);
        List<Integer> l = res.printData();
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testl1lessl2(){
        int[] a = new int[] {7,1};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {5,9,2};
        LinkedList l2 = createLinkedList(b);
        int[] ans = new int[] {2,1,3};
        LinkedList res = sumListBackward(l1,l2);
        List<Integer> l = res.printData();
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testl2lessl1(){
        int[] a = new int[] {4,3,2,1};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {7,6,5};
        LinkedList l2 = createLinkedList(b);
        int[] ans = new int[] {1,0,8,1};
        LinkedList res = sumListBackward(l1,l2);
        List<Integer> l = res.printData();
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
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
        LinkedList res = sumListBackward(l1,l2);
        if(res == null){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testl1Empty(){
        int[] a = new int[] {};
        LinkedList l1 = createLinkedList(a);
        int[] b = new int[] {5,9,2};
        LinkedList l2 = createLinkedList(b);
        int[] ans = new int[] {5,9,2};
        LinkedList res = sumListBackward(l1,l2);
        List<Integer> l = res.printData();
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_2_5 s = new Solution_2_5();
        s.testCarry();
        s.testNocarry();
        s.testEmpty();
        s.testl1Empty();
        s.testl1lessl2();
        s.testl2lessl1();
    }
}