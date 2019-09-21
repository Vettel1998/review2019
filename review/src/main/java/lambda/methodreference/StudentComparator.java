package lambda.methodreference;

public class StudentComparator {
    public int compareByScore(Student st1,Student st2){
        return st1.getScore()-st2.getScore();
    }

    public int compareByName(Student st1,Student st2){
        return st1.getName().compareToIgnoreCase(st2.getName());
    }
}
