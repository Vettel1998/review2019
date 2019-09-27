package algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class leetcode20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case '(':
                case '{':
                case '[': stack.push(c);break;
                case ')': {
                    if (stack.empty()||stack.pop() != '(')
                        return false;
                    break;
                }
                case '}':{
                    if (stack.empty()||stack.pop() != '{'){
                        return false;
                    }
                    break;
                }
                case ']':{
                    if (stack.empty()||stack.pop() != '['){
                        return false;
                    }
                    break;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s){
       Map<Character,Character> map = new HashMap<>();
       Stack<Character> stack = new Stack<>();
       map.put('}','{');
       map.put(')','(');
       map.put(']','[');
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                char top = stack.empty()?'#':stack.pop();
                if (top!=map.get(c))
                    return false;
            }else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid2("(){}[]");
    }
}
