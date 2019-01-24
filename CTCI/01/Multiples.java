import java.io.*;
import java.util.*;

/*Class Declaration*/
class Multiples{
    /*Function which calculates the sum of multiples of 3 or 5 less than 1000*/
    /*variable sum conatains the final answer*/
    /*upperLimit is the bound on the range of integers to consider*/
    private int sum = 0;
    public int sumMultiples(int upperLimit){
        for(int i=0;i<upperLimit;i++){
            if(i%3 == 0 || i%5==0){
                sum+=i;
            }
        }
        return sum;
    }
    /*A test function which prints the answer returned by the function*/
    public void testSum(){
        System.out.println(sumMultiples(1000));
    }
    public static void main(String args[]){
        Multiples m = new Multiples();
        m.testSum();
    }
}