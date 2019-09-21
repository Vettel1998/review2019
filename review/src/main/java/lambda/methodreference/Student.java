package lambda.methodreference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Student implements Comparable<Student>{
    private String name;
    private int score;

    public static int compareByScore(Student st1,Student st2){
        return st1.score - st2.score;
    }
    public static int compareByName(Student st1, Student st2){
        return  st1.name.compareToIgnoreCase(st2.name);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareToIgnoreCase(o.getName());
    }
}
