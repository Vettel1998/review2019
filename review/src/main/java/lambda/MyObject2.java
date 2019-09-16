package lambda;

import java.util.Objects;

public class MyObject2 {
    String id ;
    String name;
    int age;
    char sex;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || (getClass()!= obj.getClass())) return false;
        MyObject2 object2 = (MyObject2) obj;
        return age == object2.age && sex == object2.sex
                && Objects.equals(name,object2.name) && Objects.equals(id,object2.id);
    }

    @Override
    public String toString() {
        return "MyObject2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
