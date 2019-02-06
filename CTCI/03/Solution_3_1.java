import java.io.*;
import java.util.*;

class Solution_3_1{
    public int[] arr;
    public int top1;
    public int top2;
    public int top3;
    public Solution_3_1(int size){
        arr = new int[3*size];
        top1 = -1;
        top2 = size - 1;
        top3 = size*2 - 1;
    }
    public void push(int data, int stackNo){
        if(stackNo == 1){
            if(top1 == arr.length/3 - 1){
                System.out.println("Stack is full");
            }
            else{
                top1++;
                arr[top1] = data;
            }
        }
        else if(stackNo == 2){
            if(top2 == 2*arr.length/3 - 1){
                System.out.println("Stack is full");
            }
            else{
                top2++;
                arr[top2] = data;
            }
        }
        else{
            if(top3 == arr.length - 1){
                System.out.println("Stack is full");
            }
            else{
                top3++;
                arr[top3] = data;
            }
        }
    }
    public int pop(int stackNo){
        if(stackNo == 1){
            if(top1 == -1){
                System.out.println("Stack is empty");
                return -1;
            }
            else{
                int p = arr[top1];
                top1-- ;
                return p;
            }
        }
        else if(stackNo == 2){
            if(top2 == arr.length/3 - 1){
                System.out.println("Stack is empty");
                return -1;
            }
            else{
                int p = arr[top2];
                top2-- ;
                return p;
            }
        }
        else{
            if(top3 == 2*arr.length/3 - 1){
                System.out.println("Stack is empty");
                return -1;
            }
            else{
                int p = arr[top3];
                top3-- ;
                return p;
            }
        }
    }
    public void peek(int stackNo){
        if(stackNo == 1){
            System.out.println(arr[top1]);
        }
        else if(stackNo == 2){
            System.out.println(arr[top2]);
        }
        else{
            System.out.println(arr[top3]);
        }
    }
    public static void main(String args[]){
        Solution_3_1 s = new Solution_3_1(3);
        s.pop(1);
        s.push(10,1);
        s.push(20,1);
        s.push(20,2);
        s.push(30,3);
        s.push(55,3);
        s.peek(1);
        s.peek(2);
        s.peek(3);
        s.pop(3);
        s.peek(3);
        s.push(30,1);
        s.push(40,1);
    }
}