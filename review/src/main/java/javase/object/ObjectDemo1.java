package javase.object;

public class ObjectDemo1 implements Cloneable{
    int a = 1;
    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectDemo1 objectDemo1 = new ObjectDemo1();
        ObjectDemo1 objectDemo11 = (ObjectDemo1) objectDemo1.clone();
        System.out.println(objectDemo1);
        System.out.println(objectDemo1.equals(objectDemo11));
    }

    
    @Override
    public boolean equals(Object obj) {
        return this.a == ((ObjectDemo1)obj).a;
    }
}


class ObjectTest{
    public static void main(String[] args) {
        ObjectDemo1 objectDemo1 = new ObjectDemo1();
        Object obj = new ObjectTest();
        // obj.clone()
    }
}