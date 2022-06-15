package geektime.spring.springbucks.model;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;

    // 默认无参的构造方法
    public Person() {
        super();
    }
    // 有参的构造方法
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}
