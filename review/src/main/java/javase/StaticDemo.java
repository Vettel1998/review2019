package javase;

public class StaticDemo {



    StaticDemo(){
        System.out.println("构造方法");
    }

    {
        i = 2;
    }

    int i =1;

    public static void main(String[] args) {
        new StaticDemo();
    }
}




class Father{
    Father(){
        System.out.println("Father");
    }
}


class Son extends Father{
    public static void m(){

    }
}
