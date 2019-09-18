package algorithm.to_offer;

    import java.util.Stack;

public class offer21 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length ==0) return false;
        Stack<Integer> stack = new Stack<>();
        for (int i =0,j = 0;i<pushA.length;){
            stack.push(pushA[i++]);
            while (j<popA.length && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = new String("abc");
        twice(s);
        System.out.println(s);
    }

    public static String twice(String str){
        return str += new StringBuilder(str).reverse();
    }
}


