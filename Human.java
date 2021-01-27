package prog.kiev;

import java.io.Serializable;

enum Sex{
    MALE,
    FEMALE;
}

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private String surname;
    private String name;
    private Sex sex;
    private int age;

    public Human() {
        this.surname = new String();
        this.name = new String();
    }

    public Human(String name, String surname, Sex sex, int age) {
        this.surname = surname;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() { return age; }


    @Override
    public String toString() {
        return "Human {\n" +
                "surname : " + surname + '\n' +
                "name : " + name + '\n' +
                "sex : " + sex + '\n' +
                "age : " + age + '\n' +
                '}';
    }

    @Override
    public int hashCode() {
        return surname.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        else if(obj==null) return false;
        else if(this.getClass()!=obj.getClass()) return false;
        Human human = (Human) obj;
        return human.surname.equals(this.surname);
    }
}
