package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptinalTest2 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setName("e1");
        Employee e2 = new Employee();
        e2.setName("e2");
        List<Employee> list = Arrays.asList(e1,e2);
        Company company = new Company();
        company.setName("company1");
        //company.setEmployees(list);
        Optional<Company> optional = Optional.of(company);
        System.out.println(optional.map(Company::getEmployees).orElse(Collections.emptyList()));

    }
}
