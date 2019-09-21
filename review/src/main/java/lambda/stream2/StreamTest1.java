package lambda.stream2;

import lambda.methodreference.Student;

import java.util.Arrays;
import java.util.List;

public class StreamTest1 {
    public static void main(String[] args) {
        Student st1 = new Student("lisi",60);
        Student st2 = new Student("zhangsan",70);
        Student st3 = new Student("vettelx",85);
        Student st4 = new Student("vettelx",100);

        List<Student> list = Arrays.asList(st1,st2,st3,st4);

    }
}
