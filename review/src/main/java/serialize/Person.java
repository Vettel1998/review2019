package serialize;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Person implements Serializable {

    private static final long serialVersionUID = 60464219501551471L;
    private String name;
    private int a;
    private int b;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
