package jvm;

/*
*   首次主动使用才会被初始化
*   对于数组实例，其类型是由jvm在运行期间动态生成的
*
* */
public class MyTest4 {
    public static void main(String[] args) {
        /*new MyParent4();
        System.out.println("---------------");
        new MyParent4();*/

        MyParent4[] myParent4s = new MyParent4[10];
        System.out.println(myParent4s.getClass());
        MyParent4[][] myParent4s1 = new MyParent4[10][];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        int[] ints = new int[10];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

    }
}


class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}
