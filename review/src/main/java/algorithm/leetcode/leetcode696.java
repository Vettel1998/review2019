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
        int result = 0;
        int current = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            current++;
            if (i+1>=s.length())
                break;
            if (s.charAt(i)!=s.charAt(i+1)){
                result+=Math.min(current,pre);
                pre = current;
                current = 0;
            }
        }

        result+=Math.min(current,pre);
        return result;
    }
    public static int count3(String s){
        int last, cur, res; last = res = 0; cur = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)== s.charAt(i-1)) cur ++;
            else{last = cur; cur = 1;}
            if(last >= cur) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        //
        String s ="00110";
        System.out.println(count2(s));

    }
}
