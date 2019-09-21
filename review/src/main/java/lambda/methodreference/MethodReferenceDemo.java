package lambda.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferenceDemo {
    public String getStr(Supplier<String> supplier){
        return supplier.get()+",hello";
    }
    public static void main(String[] args) {
        /*Student student1 = new Student("lili",20);
        Student student2 = new Student("tom",30);
        Student student3 = new Student("zhangsan",20);
        List<Student> students = Arrays.asList(student1,student2,student3);
        students.sort(Student::compareByName);
        students.forEach(System.out::println);
        System.out.println("--------------");
        StudentComparator comparator = new StudentComparator();
        students.sort(comparator::compareByScore);
        students.forEach(System.out::println);
        System.out.println("---------------");
        students.sort(Student::compareTo);
        students.forEach(System.out::println);*/

        List<String> cities = Arrays.asList("qindao","chongqin","tianjin");
        cities.sort(String::compareToIgnoreCase);

        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        methodReferenceDemo.getStr(String::new);


    }
}
