package javase;

class Test{}

public class ProtectedDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Test test = new Test();
        //test.clone();    //compile errore

        ProtectedDemo demo = new ProtectedDemo();
        demo.clone();
    }
}
