import java.io.*;
import java.util.*;

class Solution_1_7{
    public int[][] rotateMatrix(int[][] mat){
        /* Flip rows*/
        /*Invert along diagonal*/
        int rows = mat.length;
        int cols = 0;
        if(rows > 0){
            cols = mat[0].length;
        }
        for(int i=0;i<rows/2;i++){
            for(int j=0;j<cols;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[rows-1-i][j];
                mat[rows-1-i][j] = temp;
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i<j){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }
        return mat;
    }
    public static void main(String args[]){
        Solution_1_7 s = new Solution_1_7();
        int[][] mat = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        mat = s.rotateMatrix(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}