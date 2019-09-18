package algorithm.to_offer;

import java.util.ArrayList;

public class offer19 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int direction  = 1;
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bot = matrix.length-1;
        int col = 0;
        int row = 0;
        for (int i = 0; i <matrix[0].length*matrix.length ; i++) {
            result.add(matrix[row][col]);
            switch (direction){
                case 1:{
                    col++;
                    if(col>right){
                        col--;
                        row++;
                        top++;
                        direction=2;
                    }
                    break;
                }
                case 2:{
                    row++;
                    if (row>bot){
                        row--;
                        col--;
                        right--;
                        direction=3;
                    }
                    break;
                }
                case 3:{
                    col--;
                    if (col<left){
                        col++;
                        row--;
                        bot--;
                        direction=4;
                    }
                    break;
                }
                case 4:{
                    row--;
                    if (row<top){
                        row++;
                        col++;
                        left++;
                        direction=1;
                    }
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);
    }

}
