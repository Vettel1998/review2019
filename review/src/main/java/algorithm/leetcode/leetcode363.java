package algorithm.leetcode;

import java.util.TreeSet;

public class leetcode363 {
    public static int maxSumSubmatrix(int[][] matrix, int k){
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        if(col == 0) return 0;

        //rectangle[i][j]记录顶点为[0,0],[i,j]的矩形的面积
        int[][] rectangle = new int[row][col];
        for(int i = 0 ; i<row ;  i++) {
            for(int j = 0 ; j<col ; j++) {
                int area = matrix[i][j];
                if(i>0) {
                    area += rectangle[i-1][j];
                }
                if(j>0) {
                    area += rectangle[i][j-1];
                }
                //减去重复计算的面积
                if(i>0 && j>0) {
                    area -= rectangle[i-1][j-1];
                }

                rectangle[i][j] = area;
            }
        }


        int result = Integer.MIN_VALUE;
        for(int startRow = 0 ; startRow < row ; startRow++) {
            for(int endRow = startRow ; endRow < row ; endRow++) {
                //记录从startRow到endRow之间所有以最左侧边为起点的矩形的面积
                TreeSet<Integer> treeSet = new TreeSet<Integer>();
                treeSet.add(0);
                for(int endCol = 0 ; endCol < col ; endCol++) {
                    int area = rectangle[endRow][endCol];
                    if(startRow > 0) {
                        area -= rectangle[startRow-1][endCol];
                    }
                    //可以减去的左侧矩形的最小面积，即大于S[(row1,0),(row2, col2)] - k的最小值
                    Integer remain = treeSet.ceiling(area - k);
                    if(remain != null) {
                        result = Math.max(result, area - remain);
                    }
                    treeSet.add(area);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][]  matrix = {{2,2,-1}};
        System.out.println(maxSumSubmatrix(matrix,0));
    }
}
