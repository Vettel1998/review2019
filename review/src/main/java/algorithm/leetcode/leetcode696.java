package algorithm.leetcode;

//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的
public class leetcode696 {

    // TLE报错
    public static int countBinarySubstrings(String s) {
        int result = 0;
        for (int i = 0; i <s.length()-1; i++) {
            int count = 1;
            int change = 0;
            for (int j = i+1; j <s.length() ; j++) {
                if (s.charAt(j) == s.charAt(i))
                    count++;
                else count--;
                if (s.charAt(j)!=s.charAt(j-1))
                    change++;
                if (change>2)
                    break;
                else if (count==0){
                    result++;
                    break;
                }
            }

        }
        return result;
    }

    public static int count2(String s){
        int[] count = new int[s.length()];
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            count[tmp]++;
            if (i+1>=s.length())
                break;
            if (s.charAt(i)!=s.charAt(i+1))
               tmp++;
        }
        int result = 0;
        for (int i = 0; i < tmp; i++) {
            result+=Math.min(count[i],count[i+1]);
        }
        return result;
    }

    public static void main(String[] args) {
        //
        String s ="00110";
        count2(s);

    }
}
