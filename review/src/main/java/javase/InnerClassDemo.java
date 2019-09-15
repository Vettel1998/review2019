package javase;

public class InnerClassDemo {


    public static void main(String[] args) {
        int i = Outer1.Inner1.a;


    }
}





//成员内部类

class Outer1{
    private int a = 0;
    public class Inner1{
        public static final int a =1;

        public void m1(){
            m();
        }

    }
    private String s = "123";


    public static void m(){
        int a=1;
        class Inner2{
            int k=1;
            public void m(){
                System.out.println(k++);
            }
        }

        Inner2 inner2 = new Inner2();
        inner2.m();
    }
}

