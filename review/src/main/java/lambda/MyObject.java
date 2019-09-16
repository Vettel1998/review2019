package lambda;

import java.util.Objects;

public class MyObject {
    String id;
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return age == myObject.age &&
                Objects.equals(id, myObject.id) &&
                Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
