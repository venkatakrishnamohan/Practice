import java.io.*;
import java.util.*;

class Solution_1_8{
    public int[][] makeZeros(int[][] mat){
        int rows = mat.length;
        int cols = 0;
        if(rows>0){
            cols = mat[0].length;
        }
        boolean row1 = false;
        boolean col1 = false;
        for(int j=0;j<cols;j++){
            if(mat[0][j] == 0){
                row1 = true;
                break;
            }
        }
        for(int i=0;i<rows;i++){
            if(mat[i][0] == 0){
                col1 = true;
                break;
            }
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(mat[i][j] == 0){
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }
        for(int j= 1;j<cols;j++){
            if(mat[0][j] == 0){
                for(int i=1;i<rows;i++){
                    mat[i][j] = 0;
                }
            }
        }
        for(int i= 1;i<rows;i++){
            if(mat[i][0] == 0){
                for(int j=1;j<cols;j++){
                    mat[i][j] = 0;
                }
            }
        }
        if(row1){
            for(int j=0;j<cols;j++){
                mat[0][j] = 0;
            }
        }
        if(col1){
            for(int i=0;i<rows;i++){
                mat[i][0] = 0;
            }
        }
        return mat;
    }
    public static void main(String args[]){
        Solution_1_8 s = new Solution_1_8();
        int[][] mat = new int[][]{
            {1,2,3,4},
            {0,2,3,0},
            {1,4,7,9},
            {2,0,4,5}
        };
        mat = s.makeZeros(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}