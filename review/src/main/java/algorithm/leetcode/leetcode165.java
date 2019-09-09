package algorithm.leetcode;



//165. Compare Version Numbers

import java.util.Arrays;

public class leetcode165 {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i=0,j=0;

        while(i<v1.length&&j<v2.length){

            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[j]))
                return 1;

            if(Integer.valueOf(v1[i])<Integer.valueOf(v2[j]))
                return -1;
            j++;
            i++;
        }



        int m,n;
        for(m=v1.length-1;m>=0;m--){
            if(!v1[m].equals("0"))
                break;
        }
        for(n=v2.length-1;n>=0;n--){
            if(!v2[n].equals("0"))
                break;
        }

        if(m==n)
            return 0;


        return (m>n)?1:-1;




    }


    public static void main(String[] args) {
        String version1 = "01", version2 = "1";
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        System.out.println(v1.length);

        System.out.println(Integer.valueOf("01") == Integer.valueOf("1"));
        //System.out.println( compareVersion(version1,version2));


    }
}
