package javase;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = new String("ab");
        String s3 = "ab";
        String s4 = "a"+"b";
        String s5 = "a";
        s5+="b";

        System.out.println("abcc".getClass());
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
    }
}
