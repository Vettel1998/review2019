package javase;

public class OverRideDemo {
    public static void main(String[] args) {
        new B();
    }
}



class A{
    private int a;
    private void k(){}
    public double m(){
        return a;
    }

    public A(String a){
        System.out.println("父类有参构造");


    }

   public A(){
       System.out.println("父类无参构造");
   }

}


class B extends A{
    @Override
    public double m() {
        return super.m();
    }

    public B(){
        System.out.println("子类无参构造");
    }

    public B(String  a){
        super(a);
        System.out.println("子类有参构造");
    }
}