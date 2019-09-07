package algorithm.dp;

import java.util.Scanner;


//01背包问题
public class Exercise3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ,m ;
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] f = new int[n][m+1];

        int[]  v = new int[n];
        int[]  w = new int[n];
        for (int i = 0; i <n ; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();

        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=m ; j++) {
                f[i][j] = f[i-1][j];
                if(j>=v[i])
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-v[i]]+w[i]);
            }
        }

        int res = 0;
        for (int i = 0; i <= m ; i++) {
            res  = Math.max(res,f[n-1][i]);
        }

        System.out.println(res);

    }
}
