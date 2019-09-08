package juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

@Getter
@AllArgsConstructor
@ToString
class User{
    private String name;
    private int age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();

        User u1= new User("zhangsan",23);
        User u2 = new User("lisi",22);

        atomicReference.set(u1);
        System.out.println(atomicReference.compareAndSet(u1,u2)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(u1,u2)+"\t"+atomicReference.get().toString());

    }
}
