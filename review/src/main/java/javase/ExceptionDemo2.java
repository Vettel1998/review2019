package javase;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        System.out.println(m());
    }

    public static Person m(){
        Person p1 = new Person("lili",10,'女');
        try {
            return p1;
        }finally {
//            p1 = new Person("lisi",20,'男');
//            p1.name = "tom";
              p1.name = "tom";
        }
    }
}


class Person{
    String name;
    int age;
    char sex;

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
