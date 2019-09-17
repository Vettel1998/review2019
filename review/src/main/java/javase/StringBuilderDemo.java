package javase;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <100000000 ; i++) {
            sb.append("a");
        }
        System.out.println(sb);
    }
}
