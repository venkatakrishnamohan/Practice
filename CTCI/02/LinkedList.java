import java.io.*;
import java.util.*;

class LinkedList{
    LLNode head = null;
    public void LinkedList(){
    }
    public void insert(int data){
        LLNode n = new LLNode(data);
        if(head == null){
            head = n;
        }
        else{
            LLNode curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = n;
        }
    }
    public LLNode removeNode(LLNode rem){
        if(head == null){
            return null;
        }
        else{
            LLNode prev = null;
            LLNode curr = head;
            if(head == rem){
                LLNode temp = head;
                head = head.next;
                temp.next = null;
                return temp;
            }
            else{
                prev = head;
                curr = head.next;
                while(curr != rem && curr != null){
                    prev = prev.next;
                    curr = curr.next;
                }
                if(curr!=null){
                    prev.next = curr.next;
                    curr.next = null;
                    return curr;
                }
                else{
                    return null;
                }
            }
        }
    }
    public int removeData(int data){
        if(head == null){
            return -1;
        }
        else{
            LLNode prev = null;
            LLNode curr = head;
            if(head.data == data){
                LLNode temp = head;
                head = head.next;
                temp.next = null;
                return temp.data;
            }
            else{
                prev = head;
                curr = head.next;
                while(curr.data != data && curr != null){
                    prev = prev.next;
                    curr = curr.next;
                }
                if(curr!=null){
                    prev.next = curr.next;
                    curr.next = null;
                    return curr.data;
                }
                else{
                    return -1;
                }
            }
        }
    }
    public List<Integer> printData(){
        List<Integer> l = new ArrayList<>();
        while(head != null){
            //System.out.println(head.data);
            l.add(head.data);
            head = head.next;
        }
        return l;
    }
}