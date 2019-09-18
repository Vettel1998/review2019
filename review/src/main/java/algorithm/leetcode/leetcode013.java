package algorithm.leetcode;

public class leetcode013 {

    public int romanToInt(String s) {
        int[] tag = new int[256];
        tag['I'] = 1;
        tag['V'] = 5;
        tag['X'] = 10;
        tag['L'] = 50;
        tag['C'] = 100;
        tag['D'] = 500;
        tag['M'] = 1000;
        int sum = 0;
        for (int i = 0; i <s.length() ; i++) {
            if(i+1>=s.length()|| tag[s.charAt(i)]>=tag[s.charAt(i+1)])
                sum+=tag[s.charAt(i)];
            else
                sum-=tag[s.charAt(i)];
        }
        return sum;
    }

}
