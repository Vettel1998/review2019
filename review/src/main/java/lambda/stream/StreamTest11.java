package lambda.stream;

import lambda.methodreference.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest11 {
    public static void main(String[] args) {
        Student st1 = new Student("lisi",60);
        Student st2 = new Student("zhangsan",70);
        Student st3 = new Student("vettelx",85);
        Student st4 = new Student("vettelx",100);

        List<Student> list = Arrays.asList(st1,st2,st3,st4);
        /*Map<String,Long> map = list.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
        System.out.println(map);*/
        Map<Boolean,List<Student>> res = list.stream().collect(Collectors.partitioningBy(st ->st.getScore()>80));
        System.out.println(res);

    }
}
