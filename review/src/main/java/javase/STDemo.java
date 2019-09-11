package javase;

public class STDemo {
    public static void main(String[] args) {
        System.out.println(Test1.x+","+Test1.y);
    }
}



class Test1{
    Test1 t = new Test1();
    static int x = 1;
    static int y;
    public Test1(){
        x++;
        y++;
    }
}
