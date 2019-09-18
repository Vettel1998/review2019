package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        PersonTest test = new PersonTest();
        Person p1 = new Person("zhangsan",20);
        Person p2 = new Person("lisi",30);
        Person p3 = new Person("wangwu",40);
        List<Person> personList = Arrays.asList(p1,p2,p3);
        List<Person> personList1 = test.getByAge2(20,personList,(age,persons)-> persons.stream().filter(e->e.getAge()>age).collect(Collectors.toList()));
    }

    public List<Person> getPersonByUsername(String username,List<Person> persons){
        return persons.stream().filter(e->e.getUsername().equals(username)).collect(Collectors.toList());
    }

    public List<Person> getByAge(int age,List<Person> persons){
        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageOfPerson,personList)->
            personList.stream().filter(person -> person.getAge()<ageOfPerson).collect(Collectors.toList());

        return biFunction.apply(age,persons);
    }

    public List<Person> getByAge2(int age,List<Person> personList,BiFunction<Integer,List<Person>,List<Person>> biFunction){
        return biFunction.apply(age,personList);
    }
}
