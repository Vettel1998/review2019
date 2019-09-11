package javase;

public class ExtendDemo {
    public static void main(String[] args) {
        Father1 f =new Son1();
        f.m();
    }

}


class Father1{

    public static void m(){
        System.out.println("Father1");
    }

}


class Son1 extends Father1{
//    public static void m(){
//        System.out.println("Son1");
//    }
}
