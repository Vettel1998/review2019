package javase;

public class InterfaceDemo {
    public static void main(String[] args) {
        IC  ic = new E();
        E c  = (E) ic;

        c.ma();
        c.mb();
        c.mc();
        c.md();
    }
}



interface Interface1{
    int a = 0;
    default void m(){

    }


    static void n(){

    }
}



class Imp implements Interface1{
    @Override
    public void m() {

    }

    static  void n(){

    }
}


abstract class Abs implements Interface1{

    abstract void n();
}


class Imp2 extends Abs{

    @Override
    void n() {

    }


}


interface IA{
    void ma();
}


interface IB extends IA{
    void mb();
}


interface IC {
    void mc();
}


interface ID extends IB,IC{
    void md();
}


class E implements ID{

    @Override
    public void ma() {

    }

    @Override
    public void mb() {

    }

    @Override
    public void mc() {

    }

    @Override
    public void md() {

    }


}