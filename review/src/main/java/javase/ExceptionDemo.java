package javase;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println(m());
    }

    public static int m(){
        int i=1;
        try {
            return i;
        }finally {
            i++;
        }
    }
}
